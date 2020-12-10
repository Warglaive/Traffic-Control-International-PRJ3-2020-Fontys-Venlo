package crossings;

import lane.Lane;
import lane.LaneStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;

public class FourWayCrossingControllerEntranceStandard extends FourWayCrossingControllerEntrance {
    public FourWayCrossingControllerEntranceStandard(HashMap<LaneType, HashMap<LaneParameterKey, Object>> parameterList) {
        super(parameterList);
    }

    @Override
    public void changeLeftLane(HashMap<LaneParameterKey, Object> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setLeftLane(newLane);
    }
}
