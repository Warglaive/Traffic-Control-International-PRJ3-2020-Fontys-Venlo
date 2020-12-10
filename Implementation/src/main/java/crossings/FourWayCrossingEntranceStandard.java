package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;

import java.util.HashMap;
import java.util.Map;


public class FourWayCrossingEntranceStandard extends FourWayCrossingEntrance {
    public FourWayCrossingEntranceStandard(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList) {
        super(parameterList);
    }


    @Override
    public void changeController(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList) {
        FourWayCrossingControllerEntranceStandard crossingController =
                new FourWayCrossingControllerEntranceStandard(parameterList);

        super.setController(crossingController);
    }
}
