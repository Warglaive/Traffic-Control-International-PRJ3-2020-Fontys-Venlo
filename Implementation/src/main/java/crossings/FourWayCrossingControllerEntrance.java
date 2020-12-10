package crossings;

import lane.Lane;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;
import java.util.HashMap;
import java.util.Map;

public abstract class FourWayCrossingControllerEntrance {
    private Lane leftLane;

    public FourWayCrossingControllerEntrance(
            Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList) {

        this.changeLeftLane(parameterList.get(LEFT_LANE));

    }

    public abstract void changeLeftLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );


    public void setLeftLane(Lane leftLane) {
        this.leftLane = leftLane;
    }

    public Lane getLeftLane() {
        return leftLane;
    }
}
