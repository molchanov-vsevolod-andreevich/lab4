import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String, ArrayList<TestPackageResponse.TestResult>> store = new HashMap<>();

    static Props props() {
        return Props.create(StoreActor.class);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestPackageResponse.TestResult.class, m -> {
                    String packageId = m.getPackageId();
                    if (store.containsKey(packageId)) {
                        store.get(packageId).add(m);
                    } else {
                        ArrayList<TestPackageResponse.TestResult> newPackage = new ArrayList<>();
                        newPackage.add(m);
                        store.put(packageId, newPackage);
                    }
                })
                .match(GetMessage.class, req -> {
                    int s = store.get(req.getKey()).size();
                    TestPackageResponse.TestResult[] results new TestPackageResponse.TestResult[s];

                    sender().tell(
                            (store.get(req.getKey()) == null) ? AkkaAppConstants.NO_SUCH_PACKAGE_MESSAGE :
                                    new TestPackageResponse(req.getKey(),
                                            store.get(req.getKey()).toArray()),
                            self());
                        }
                ).build();
    }

    static class GetMessage {
        private final String key;

        GetMessage(String key) {
            this.key = key;
        }

        String getKey() {
            return key;
        }
    }
}