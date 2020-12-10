package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;

import java.util.HashMap;


public class FourWayCrossingEntranceStandard extends FourWayCrossingEntrance {
    public FourWayCrossingEntranceStandard(HashMap<LaneType, HashMap<LaneParameterKey, Object>> parameterList) {
        super(parameterList);
    }


    @Override
    public void changeController(HashMap<LaneType, HashMap<LaneParameterKey, Object>> parameterList) {
        FourWayCrossingControllerEntranceStandard crossingController =
                new FourWayCrossingControllerEntranceStandard(parameterList);

        super.setController(crossingController);
    }
}
