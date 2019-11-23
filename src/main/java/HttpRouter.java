import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.server.AllDirectives;

public class HttpRouter extends AllDirectives {
    private final ActorRef routeActor;

    private MainHttp(ActorSystem system) {
        routeActor = system.actorOf(RouteActor.props(), "routeActor");
    }
}
