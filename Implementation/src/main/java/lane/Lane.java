package lane;

import lane.laneControllers.LaneController;

/**
 * The interface Lane.
 */
public interface Lane extends Runnable{
    /**
     * Gets straight lane controller.
     *
     * @return the straight lane controller
     */
    LaneController getStraightLaneController();

    /**
     * Cycle straight lights.
     *
     * @throws InterruptedException the interrupted exception
     */
    void cycleStraightLights() throws InterruptedException;
}
