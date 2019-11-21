import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestPackageActor extends AbstractActor {

    public static Props props() {
//        return Props.create(TestPackageActor.class);
        return new RoundRobinPool(5).props(Props.create(TestPackageActor.class, logResultsActor));
    }

    @Override
    public Receive createReceive() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(jscript);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(functionName, params).toString();
    }
}
