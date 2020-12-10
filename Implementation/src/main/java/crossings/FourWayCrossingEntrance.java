package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;

public abstract class FourWayCrossingEntrance extends Crossing implements FourWayCrossing {
    private FourWayCrossingControllerEntrance controller;

    public FourWayCrossingEntrance(HashMap<LaneType, HashMap<LaneParameterKey, Object>> parameterList) {
        this.changeController(parameterList);
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
