package crossings.crossingControllers.twoWay;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lane.Lane;

import java.util.Map;

import static crossings.parameterEnums.LaneType.LEFT_LANE;
import static crossings.parameterEnums.LaneType.RIGHT_LANE;

public abstract class TwoLaneCrossingControllerEntrance implements TwoWayCrossingController {
    /**
     * The lanes belonging to a crossing
     */
    private Lane leftLane;
    private Lane rightLane;

    /**
     * The time before the next lane start its cycle
     */

    private int secondsBetweenLaneSwitch;

    public TwoLaneCrossingControllerEntrance(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        this.changeLeftLane(parameterList.get(LEFT_LANE));
        this.changeRightLane(parameterList.get(RIGHT_LANE));
        this.secondsBetweenLaneSwitch = secondsBetweenLaneSwitch;

    }

    public abstract void changeLeftLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList);

    public abstract void changeRightLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> laneControllerTypeMapMap);

    @Override
    public void cycleLanes() {

    }
}
