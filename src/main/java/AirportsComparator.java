import scala.Tuple2;

import java.io.Serializable;
import java.util.Comparator;

public class AirportsComparator implements Comparator<Tuple2<String, String>>, Serializable {
    @Override
    public int compare(Tuple2<String, String> o1, Tuple2<String, String> o2) {
        int res = o1._1().compareTo(o2._1());
        if (res == 0) {
            res = o1._2().compareTo(o2._2());
        }
        return res;
    }
}