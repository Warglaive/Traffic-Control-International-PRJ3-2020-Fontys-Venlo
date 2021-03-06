package lane;

import lane.laneControllers.LaneController;

/**
 * The interface Lane.
 */
public interface Lane {
    /**
     * Gets straight lane controller.
     *
     * @return the straight lane controller
     */
    LaneController getStraightLaneController();

    LaneController getPedestrianLaneController();

    /**
     * Cycle straight lights.
     *
     * @throws InterruptedException the interrupted exception
     */
    void cycleStraightLights() throws InterruptedException;
}
