package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

public abstract class Crossing {

    public abstract void changeController(
            Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList
    );

    public abstract FourWayCrossingControllerEntrance getController();

    public abstract void setController(FourWayCrossingControllerEntrance controller);

}
