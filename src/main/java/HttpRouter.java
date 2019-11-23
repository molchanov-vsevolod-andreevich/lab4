import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import scala.concurrent.Future;

public class HttpRouter extends AllDirectives {
    private final ActorRef routeActor;

    private HttpRouter(ActorSystem system) {
        routeActor = system.actorOf(RouteActor.props(), "routeActor");
    }

    private Route createRoute() {
        return route(
                path("test", () ->
                        route(
                                post(() ->
                                        entity(Jackson.unmarshaller(TestPackageRequest.class), msg -> {
                                            routeActor.tell(msg, ActorRef.noSender());
                                            return complete("Test started!");
                                        })))),
                path("put", () ->
                        get(() ->
                                parameter("packageId", (packageId) ->
                                {
                                    Future<Object> res = Patterns.ask(routeActor, new StoreActor.GetMessage(packageId), 5000);
                                    return completeOKWithFuture(res, Jackson.marshaller());
                                }))));
    }
}
