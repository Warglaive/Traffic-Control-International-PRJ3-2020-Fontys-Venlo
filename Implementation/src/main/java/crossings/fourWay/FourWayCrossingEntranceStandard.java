package crossings.fourWay;

import crossings.crossingControllers.fourWay.FourWayCrossingControllerEntranceStandard;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;

import java.util.Map;

/**
 * Four way crossing entrance standard. Creates a four way crossing with four fields of type lane (lane of type standard)
 */
public class FourWayCrossingEntranceStandard extends FourWayCrossingEntrance {
    /**
     * Creates a crossing and the parts required for it
     * @param parameterList Contains the Information required to create Lanes and lane controllers, LaneType is the position of the lane.
     * @param secondsBetweenLaneSwitch The seconds that it takes to start the cycle on another lanes.
     */
    public FourWayCrossingEntranceStandard(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        super(parameterList, secondsBetweenLaneSwitch);
    }


    /**
     *
     * @param parameterList Parameters required by controllers constructor (needed to create lanes)
     * @param secondsBetweenLaneSwitch When two lanes have finished their cycle, the amount of time specified in this parameter
     */
    @Override
    public void changeController(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        FourWayCrossingControllerEntranceStandard crossingController =
                new FourWayCrossingControllerEntranceStandard(parameterList, secondsBetweenLaneSwitch);

        super.setController(crossingController);
    }
}
