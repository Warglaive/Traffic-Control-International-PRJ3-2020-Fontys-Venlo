package crossings;

import crossings.crossingController.FourWayCrossingControllerEntranceStandard;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;

import java.util.Map;


public class FourWayCrossingEntranceStandard extends FourWayCrossingEntrance {
    public FourWayCrossingEntranceStandard(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        super(parameterList, secondsBetweenLaneSwitch);
    }


    @Override
    public void changeController(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        FourWayCrossingControllerEntranceStandard crossingController =
                new FourWayCrossingControllerEntranceStandard(parameterList, secondsBetweenLaneSwitch);

        super.setController(crossingController);
    }
}
