package crossings;

import lane.Lane;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;
import java.util.HashMap;

public abstract class FourWayCrossingControllerEntrance {
    private Lane leftLane;

    public FourWayCrossingControllerEntrance(
            HashMap<LaneType, HashMap<LaneParameterKey, Object>> parameterList) {

        this.changeLeftLane(parameterList.get(LEFT_LANE));

    }

    public abstract void changeLeftLane(
            HashMap<LaneParameterKey, Object> parameterList
    );


    public void setLeftLane(Lane leftLane) {
        this.leftLane = leftLane;
    }

    public Lane getLeftLane() {
        return leftLane;
    }
}
