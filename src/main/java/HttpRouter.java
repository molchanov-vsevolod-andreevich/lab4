import akka.actor.ActorRef;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;

import java.util.concurrent.Future;

public class HttpRouter extends AllDirectives {

    private Route createRoute(ActorRef routeActor) {
        return route(
                path("test", () ->
                        route(
                                post(() ->
                                        entity(Jackson.unmarshaller(TestPackageMsg.class), msg -> {
                                            routeActor.tell(msg, ActorRef.noSender());
                                            return complete("Test started!");
                                        })))),
                path("put", () ->
                        get(() ->
                                parameter("packageID", (packageID) ->
                                {
                                    Future<Object> res = Patterns.ask(routeActor, 5000)
                                    routeActor.tell(new StoreActor.StoreMessage(key, value), ActorRef.noSender());
                                    return complete("value saved to store! key=" + key + " value=" + value);
                                }))));
    }
}
