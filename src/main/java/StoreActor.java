import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreActor extends AbstractActor {
    private Map<String, ArrayList<TestPackageResponse.TestResult>> store = new HashMap<>();

    public static Props props() {
        return Props.create(StoreActor.class);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestPackageResponse.TestToStore.class, m -> {
                    System.out.println("Hey");
                    String packageId = m.getPackageId();
                    TestPackageResponse.TestResult testResult = m.getTestResult();
                    if (store.containsKey(packageId)) {
                        store.get(packageId).add(testResult);
                    } else {
                        ArrayList<TestPackageResponse.TestResult> newPackage = new ArrayList<>();
                        newPackage.add(testResult);
                        store.put(packageId, newPackage);
                    }
                })
                .match(GetMessage.class, req -> sender().tell(
                        (store.get(req.getKey()) == null) ? "There is no such package" :
                                new TestPackageResponse(req.getKey(),
                                        (TestPackageResponse.TestResult[]) store.get(req.getKey()).toArray()),
                        self())
                ).build();
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