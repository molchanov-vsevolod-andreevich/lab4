import akka.actor.AbstractActor;
import akka.actor.Props;

public class StoreActor extends AbstractActor {

    public static Props props() {
        return Props.create(StoreActor.class);
    }

    @Override
    public Receive createReceive() {
        return null;
    }

    public static class StoreMessage {
        public StoreMessage(String key, String value) {
        }
    }
}