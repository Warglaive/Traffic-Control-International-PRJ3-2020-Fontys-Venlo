package crossings.fourWay;

import crossings.crossingControllers.fourWay.FourWayCrossingControllerEntrance;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;

import java.util.Map;

/**
 * The type Four way crossing entrance.
 */
public abstract class FourWayCrossingEntrance implements FourWayCrossing, Runnable {
    private FourWayCrossingControllerEntrance controller;

    /**
     * Creates a crossing and the parts required for it
      * @param parameterList Contains the Information required to create Lanes and lane controllers, LaneType is the position of the lane.
     * @param secondsBetweenLaneSwitch The seconds that it takes to start the cycle on another lanes.
     */
    public FourWayCrossingEntrance(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        this.changeController(parameterList, secondsBetweenLaneSwitch);
    }

    /**
     * Starts cycling lanes
     */
    @Override
    public void run() {
        cycleLanes();
    }

    /**
     * A before specified cycle, that decides in what order lights are being switched on and off is being executed
     * upon calling this method.
     */
    @Override
    public void cycleLanes() {
        this.controller.cycleLanes();
    }

    /**
     * Gets controller
     * @return this FourWayCrossingControllerEntrance
     */
    @Override
    public FourWayCrossingControllerEntrance getController() {
        return controller;
    }

    /**
     * Set controller
     * @param controller the controller to be set
     */
    @Override
    public void setController(FourWayCrossingControllerEntrance controller) {
        this.controller = controller;
    }


}
