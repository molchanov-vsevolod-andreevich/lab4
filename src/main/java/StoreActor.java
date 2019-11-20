import akka.actor.AbstractActor;
import akka.actor.Props;

public class StoreActor extends AbstractActor {

    public static Props props() {
        return Props.create()
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
