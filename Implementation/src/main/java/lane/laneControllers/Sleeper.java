package lane.laneControllers;

import java.util.concurrent.TimeUnit;

public class Sleeper {
    public void sleep(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
