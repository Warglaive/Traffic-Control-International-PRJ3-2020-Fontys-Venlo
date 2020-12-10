package crossing;

import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import crossings.LaneType;
import lightBehaviours.LightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.STRAIGHT;
import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;

public class TestUtils {
    public static Map<LaneControllerType, Map<LaneParameterKey, Object>> getLaneParamMap(
            int straightGoDuration, int straightCycleTime, LightBehaviour lightBehaviour, Location location) {


        var laneStraightParams = new HashMap();
        laneStraightParams.put(NUMBER_LIGHTS, 2);
        laneStraightParams.put(LIGHT_BEHAVIOUR, lightBehaviour);
        laneStraightParams.put(LOCATION, location);
        laneStraightParams.put(GO_DURATION, straightGoDuration);
        laneStraightParams.put(CYCLE_TIME, straightCycleTime);

        var lane = new HashMap();
        lane.put(STRAIGHT, laneStraightParams);

        return lane;
    }

    public static Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> getFourLaneParamMap(
            int straightGoDuration, int straightCycleTime, LightBehaviour lightBehaviour, Location location) {

        var fourLanes = new HashMap();

        fourLanes.put(LEFT_LANE, getLaneParamMap(
                straightGoDuration, straightCycleTime, lightBehaviour, location
        ));
        fourLanes.put(RIGHT_LANE, getLaneParamMap(
                straightGoDuration, straightCycleTime, lightBehaviour, location
        ));
        fourLanes.put(TOP_LANE, getLaneParamMap(
                straightGoDuration, straightCycleTime, lightBehaviour, location
        ));
        fourLanes.put(BOTTOM_LANE, getLaneParamMap(
                straightGoDuration, straightCycleTime, lightBehaviour, location
        ));

        return fourLanes;
    }
}
