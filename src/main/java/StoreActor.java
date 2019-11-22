import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String, String> store = new HashMap<>();

    public static Props props() {
        return Props.create(StoreActor.class);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(StoreMessage.class, m -> {
                    store.put(m.getKey(), m.getValue());
                    System.out.println("receive message! " + m.toString());
                })
                .match(GetMessage.class, req -> sender().tell(
                        new StoreMessage(req.getKey(), store.get(req.getKey())), self())
                ).build();
    }

    protected static class StoreMessage {
        String packageID;

        public StoreMessage(String packageID) {
            this.packageID = packageID;
        }

        public String getPackageID() {
            return packageID;
        }
    }

    protected static class GetMessage {
        String key;

        public GetMessage(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }
}