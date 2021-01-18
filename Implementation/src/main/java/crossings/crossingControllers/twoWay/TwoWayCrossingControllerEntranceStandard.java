package crossings.crossingControllers.twoWay;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lane.Lane;
import lane.LaneStandard;

import java.util.Map;

public class TwoWayCrossingControllerEntranceStandard extends TwoLaneCrossingControllerEntrance {
    public TwoWayCrossingControllerEntranceStandard(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        super(parameterList, secondsBetweenLaneSwitch);
    }

    /**
     * Creates a new (standard) left lane and sets it with the given parameters.
     *
     * @param parameterList Required parameters for constructing a lane
     */

    @Override
    public void changeLeftLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane standardLeftLane = new LaneStandard(
                parameterList
        );

        super.setLeftLane(standardLeftLane);
    }

    /**
     * Creates a new (standard) right lane and sets it with the given parameters.
     *
     * @param parameterList Required parameters for constructing a lane
     */
    
    @Override
    public void changeRightLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane standardRightLane = new LaneStandard(
                parameterList
        );

        super.setLeftLane(standardRightLane);
    }
}
