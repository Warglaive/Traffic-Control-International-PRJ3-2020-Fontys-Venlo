package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

public abstract class FourWayCrossingEntrance implements FourWayCrossing {
    private FourWayCrossingControllerEntrance controller;

    public FourWayCrossingEntrance(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        this.changeController(parameterList, secondsBetweenLaneSwitch);
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
