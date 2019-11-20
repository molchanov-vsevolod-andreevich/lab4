import java.io.Serializable;
import java.util.Iterator;

public class DelaysInfo implements Serializable {
    private float maxDelay;
    private float delayAndCancelPercentage;

    public DelaysInfo() {
        maxDelay = 0f;
        delayAndCancelPercentage = 0f;
    }

    public DelaysInfo(Iterable<String> delays) {
        float max = Float.MIN_VALUE;
        float numOfFlights = 0f;
        float numOfDelaysAndCancels = 0f;

        Iterator<String> it = delays.iterator();
        while (it.hasNext()) {
            numOfFlights++;
            String nextDelay = it.next();
            if (nextDelay.isEmpty()) {
                numOfDelaysAndCancels++;
            } else {
                float delay = Float.parseFloat(nextDelay);
                if (delay > 0f) {
                    numOfDelaysAndCancels++;
                    if (delay > max) {
                        max = delay;
                    }
                }
            }
        }

        if (numOfDelaysAndCancels == 0f) {
            new DelaysInfo();
        } else {
            maxDelay = max;
            delayAndCancelPercentage = numOfDelaysAndCancels * 100f / numOfFlights;
        }
    }

    public float getMaxDelay() {
        return maxDelay;
    }

    public float getDelayAndCancelPercentage() {
        return delayAndCancelPercentage;
    }

    @Override
    public String toString() {
        if (delayAndCancelPercentage == 0f) {
            return "no delays or cancels";
        } else {
            return "maximum delay: " + maxDelay + " minutes\n\tpercentage of delayed and canceled flights: " + delayAndCancelPercentage + "%";
        }
    }
}
