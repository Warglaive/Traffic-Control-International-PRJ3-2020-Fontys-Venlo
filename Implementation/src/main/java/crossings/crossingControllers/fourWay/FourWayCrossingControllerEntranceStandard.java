package crossings.crossingControllers.fourWay;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lane.Lane;
import lane.LaneStandard;

import java.util.Map;

/**
 * A four way crossing controller entrance that creates standard lanes.
 */
public class FourWayCrossingControllerEntranceStandard extends FourWayCrossingControllerEntrance {
    /**
     * Passes necessary parameters to lane constructors and sets the returning lanes as fields.
     * @param parameterList Parameters for lane constructors.
     * @param secondsBetweenLaneSwitch When two lanes have finished their cycle, the amount of time specified in this parameter
     *  will pass until the next two lanes begin their cycle.
     */
    public FourWayCrossingControllerEntranceStandard(
            Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        super(parameterList, secondsBetweenLaneSwitch);
    }

    /**
     * Creates a new (standard) left lane and sets it with the given parameters.
     * @param parameterList Required parameters for constructing a lane
     */
    @Override
    public void changeLeftLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setLeftLane(newLane);
    }

    /**
     * Creates a new (standard) right lane and sets it with the given parameters.
     * @param parameterList Required parameters for constructing a lane
     */
    @Override
    public void changeRightLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setRightLane(newLane);
    }

    /**
     * Creates a new (standard) top lane and sets it with the given parameters.
     * @param parameterList Required parameters for constructing a lane
     */
    @Override
    public void changeTopLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setTopLane(newLane);
    }

    /**
     * Creates a new (standard) bottom lane and sets it with the given parameters.
     * @param parameterList Required parameters for constructing a lane
     */
    @Override
    public void changeBottomLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {
        Lane newLane = new LaneStandard(
                parameterList
        );

        super.setBottomLane(newLane);
    }
}
