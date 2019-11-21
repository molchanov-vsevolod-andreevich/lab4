import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class RouteActor extends AbstractActor {
    private ActorRef storeActor;
    private ActorRef testPackageActor;

    private RouteActor(final ActorSystem system) {
        storeActor = system.actorOf(StoreActor.props(), "storeActor");
        testPackageActor = system.actorOf(new RoundRobinPool(5).props(Props.create(TestPackageActor.class, storeActor)), "testActor");
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
