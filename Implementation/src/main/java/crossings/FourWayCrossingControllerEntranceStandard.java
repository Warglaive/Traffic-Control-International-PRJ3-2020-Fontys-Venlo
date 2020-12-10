package crossings;

import lane.Lane;
import lane.LaneStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

public class FourWayCrossingControllerEntranceStandard extends FourWayCrossingControllerEntrance {
    public FourWayCrossingControllerEntranceStandard(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList) {
        super(parameterList);
    }

    @Override
    public void changeLeftLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setLeftLane(newLane);
    }
}
