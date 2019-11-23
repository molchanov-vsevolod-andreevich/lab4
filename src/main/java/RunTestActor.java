import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestActor extends AbstractActor {

    static Props props() {
        return Props.create(TestActor.class);
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestToEval.class, msg -> {
                    boolean isCorrect;
                    String result;
                    String expectedResult = msg.getTest().getExpectedResult();
                    Object[] params = msg.getTest().getParams();
                    String testName = msg.getTest().getTestName();

                    ScriptEngine engine = new ScriptEngineManager().getEngineByName(AkkaAppConstants.JS_ENGINE_NAME);
                    engine.eval(msg.getJsScript());
                    Invocable invocable = (Invocable) engine;
                    result = invocable.invokeFunction(msg.getFunctionName(), params).toString();
                    isCorrect = result.equals(expectedResult);

                    getContext().actorSelection(AkkaAppConstants.STORE_ACTOR_PATH)
                            .tell(new TestPackageResponse.TestResult(msg.getPackageId(), testName,
                                                    isCorrect,
                                                    result,
                                                    expectedResult,
                                                    params),
                                    self());
                })
                .build();
    }
}
