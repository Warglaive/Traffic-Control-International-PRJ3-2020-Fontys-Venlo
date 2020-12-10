package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;

public abstract class Crossing {

    public abstract void changeController(HashMap<LaneType, HashMap<LaneParameterKey, Object>> parameterList);

    public abstract FourWayCrossingControllerEntrance getController();

    public abstract void setController(FourWayCrossingControllerEntrance controller);

}
