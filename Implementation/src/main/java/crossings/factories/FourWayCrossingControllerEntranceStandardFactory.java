package crossings.factories;

import crossings.FourWayCrossingControllerEntranceStandard;
import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import crossings.LaneType;

import java.util.Map;

public class FourWayCrossingControllerEntranceStandardFactory {
    //Getter
    public FourWayCrossingControllerEntranceStandard getFourWayCrossingControllerEntranceStandard(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        return new FourWayCrossingControllerEntranceStandard(parameterList, secondsBetweenLaneSwitch);
    }
}
