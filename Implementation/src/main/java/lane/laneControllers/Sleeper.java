package lane.laneControllers;

import java.util.concurrent.TimeUnit;

public class Sleeper {
    /**
     * Calls Thread.sleep with given seconds.
     * @param seconds Seconds the thread should sleep
     * @throws InterruptedException
     */
    public void sleep(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
