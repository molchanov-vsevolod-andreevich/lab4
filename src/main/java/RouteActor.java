import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class RouteActor extends AbstractActor {
    private ActorRef storeActor;
    private ActorRef testPackageActor;


    @Override
    public Receive createReceive() {
        return null;
    }
}
