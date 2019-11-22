import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;

public class RouteActor extends AbstractActor {
    private final ActorRef storeActor;
    private final ActorRef testPackageActor;

    public RouteActor() {
        storeActor = getContext().actorOf(StoreActor.props(), "storeActor");
        testPackageActor = getContext().actorOf(new RoundRobinPool(5).props(TestPackageActor.props()), "testActor");
    }

    public static Props props() {
        return Props.create(RouteActor.class);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(StoreActor.GetMessage.class, req -> {
//                    System.out.println("Hey");
                    storeActor.tell(req, sender());
                })
                .match(TestPackageRequest.class, msg -> {
//                    System.out.println(msg.getPackageId() + " " + msg.getJsScript() + " " + msg.getFunctionName() + " ");
//                    for (TestPackageRequest.Test test : msg.getTests()) {
//                        System.out.println(test.getTestName() + " " + test.getExpectedResult());
//                        for (Object par : test.getParams()) {
//                            System.out.println(par);
//                        }
//                    }
                    for (TestPackageRequest.Test test : msg.getTests()) {
                        testPackageActor.tell(new TestPackageRequest.TestToEval(msg.getPackageId(),
                                        msg.getJsScript(),
                                        msg.getFunctionName(),
                                        test),
                                self());
                    }
                })
                .build();
    }
}
