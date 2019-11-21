import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RouteActor extends AbstractActor {
    private ActorRef storeActor;
    private ActorRef testPackageActor;

    private RouteActor() {
        storeActor = getContext().actorOf(StoreActor.props(), "storeActor");
        testPackageActor = getContext().actorOf(new RoundRobinPool(5).props(TestPackageActor.props()), "testActor");
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}