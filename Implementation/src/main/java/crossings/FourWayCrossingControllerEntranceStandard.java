package crossings;

import lane.Lane;
import lane.LaneStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

public class FourWayCrossingControllerEntranceStandard extends FourWayCrossingControllerEntrance {
    public FourWayCrossingControllerEntranceStandard(
            Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        super(parameterList, secondsBetweenLaneSwitch);
    }

    @Override
    public void changeLeftLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setLeftLane(newLane);
    }

    @Override
    public void changeRightLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setRightLane(newLane);
    }

    @Override
    public void changeTopLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setTopLane(newLane);
    }

    @Override
    public void changeBottomLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setBottomLane(newLane);
    }
}
