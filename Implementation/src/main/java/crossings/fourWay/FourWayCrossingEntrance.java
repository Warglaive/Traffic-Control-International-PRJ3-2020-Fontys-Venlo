package crossings.fourWay;

import crossings.crossingControllers.fourWay.FourWayCrossingControllerEntrance;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;

import java.util.Map;

public abstract class FourWayCrossingEntrance implements FourWayCrossing, Runnable {
    private FourWayCrossingControllerEntrance controller;

    /**
     * Creates a crossing and the parts required for it
      * @param parameterList Contains the Information required to create Lanes and lane controllers, LaneType is the position of the lane.
     * @param secondsBetweenLaneSwitch Te seconds that it takes to start the cycle on another lanes.
     */
    public FourWayCrossingEntrance(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        this.changeController(parameterList, secondsBetweenLaneSwitch);
    }

    @Override
    public void run() {
        cycleLanes();
    }

    @Override
    public void cycleLanes() {
        this.controller.cycleLanes();
    }

    @Override
    public FourWayCrossingControllerEntrance getController() {
        return controller;
    }

    @Override
    public void setController(FourWayCrossingControllerEntrance controller) {
        this.controller = controller;
    }


}
