import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;

public class RouteActor extends AbstractActor {
    private ActorRef storeActor;
    private ActorRef testPackageActor;

    RouteActor() {
        storeActor = getContext().actorOf(StoreActor.props(), "storeActor");
        testPackageActor = getContext().actorOf(new RoundRobinPool(5).props(TestPackageActor.props()), "testActor");
    }

    public static Props props() {
        return Props.create(StoreActor.class);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(StoreActor.GetMessage.class, req -> {
                    storeActor.tell(req, sender());
                })
                .match(TestPackageRequest.class, msg -> {
                    for (TestPackageRequest.Test test : msg.getTests()) {
                        testPackageActor.tell(new TestPackageRequest(msg.getPackageId(),
                                        msg.getJsScript(),
                                        msg.getFunctionName(),
                                        new TestPackageRequest.Test[]{test}),
                                self());
                    }
                })
                .build();
    }
}
