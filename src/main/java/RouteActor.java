import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.routing.RoundRobinPool;

public class RouteActor extends AbstractActor {
    private ActorRef storeActor;
    private ActorRef testPackageActor;

    RouteActor() {
        storeActor = system.actorOf(StoreActor.props(), "storeActor");
        testPackageActor = system.actorOf(new RoundRobinPool(5).props(TestPackageActor.props()), "testActor");
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
