import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestPackageActor extends AbstractActor {

    static Props props() {
        return Props.create(TestPackageActor.class);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestPackageRequest.TestToEval.class, msg -> {
                    boolean isCorrect;
                    String result;
                    String expectedResult = msg.getTest().getExpectedResult();
                    Object[] params = msg.getTest().getParams();
                    String testName = msg.getTest().getTestName();

                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(msg.getJsScript());
                    Invocable invocable = (Invocable) engine;
                    result = invocable.invokeFunction(msg.getFunctionName(), params).toString();
                    isCorrect = result.equals(expectedResult);

                    getContext().actorSelection("/user/routeActor/storeActor")
                            .tell(new TestPackageResponse.TestToStore(msg.getPackageId(),
                                            new TestPackageResponse.TestResult(testName,
                                                    isCorrect,
                                                    result,
                                                    expectedResult,
                                                    params)),
                                    self());
//                    System.out.println(result);
                })
                .build();
    }
}
