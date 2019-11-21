import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.RepointableActorRef;
import akka.routing.RoundRobinPool;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestPackageActor extends AbstractActor {

    public static Props props(RepointableActorRef storeActor) {
        return new RoundRobinPool(5).props(Props.create(TestPackageActor.class, storeActor));
    }

    @Override
    public Receive createReceive() {
        return null;
//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
//        engine.eval(jscript);
//        Invocable invocable = (Invocable) engine;
//        return invocable.invokeFunction(functionName, params).toString();
    }
}
