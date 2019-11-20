import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;

public class AirportApp {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flightsCSV = sc.textFile("664600583_T_ONTIME_sample.csv");
        JavaRDD<String> airportsCSV = sc.textFile("L_AIRPORT_ID.csv");

        JavaPairRDD<Tuple2<String, String>, DelaysInfo> airportsPairsDelaysInfo = Util.parseFlights(flightsCSV);
        Map<String, String> airportsCodesToNames = Util.parseAirports(airportsCSV);

        final Broadcast<Map<String, String>> airportsBroadcasted = sc.broadcast(airportsCodesToNames);
        JavaRDD<AirportsDelaysInfo> airportsDelaysInfo = airportsPairsDelaysInfo.map(info ->
                new AirportsDelaysInfo(info._1(), info._2(), airportsBroadcasted.value()));

        airportsDelaysInfo.saveAsTextFile("output");
    }
}
