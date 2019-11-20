import scala.Tuple2;

import java.io.Serializable;
import java.util.Map;

public class AirportsDelaysInfo implements Serializable {
    private String originAirportID;
    private String originAirportName;

    private String destAirportID;
    private String destAirportName;

    private DelaysInfo delays;

    public AirportsDelaysInfo(Tuple2<String, String> airportsPair, DelaysInfo delays, Map<String, String> airportsCodesToNames) {
        originAirportID = airportsPair._1();
        originAirportName = airportsCodesToNames.get(originAirportID);

        destAirportID = airportsPair._2();
        destAirportName = airportsCodesToNames.get(destAirportID);

        this.delays = delays;
    }

    public String getOriginAirportID() {
        return originAirportID;
    }

    public String getOriginAirportName() {
        return originAirportName;
    }

    public String getDestAirportID() {
        return destAirportID;
    }

    public String getDestAirportName() {
        return destAirportName;
    }

    @Override
    public String toString() {
        return "FROM: " + originAirportName + " (code " + originAirportID + ") \nTO: " +
                destAirportName + " (code " + destAirportID + ")\n\t" + delays +
                "———————————————————————————————————————————————————————————————————————";
    }
}
