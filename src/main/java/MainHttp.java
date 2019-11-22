import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.util.concurrent.CompletionStage;
import scala.concurrent.Future;

public class MainHttp extends AllDirectives {
    private final ActorRef routeActor;

    private MainHttp(ActorSystem system) {
        routeActor = system.actorOf(RouteActor.props(), "routeActor");
    }

    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("routes");

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        MainHttp instance = new MainHttp(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                instance.createRoute().flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8080),
                materializer
        );
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
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
