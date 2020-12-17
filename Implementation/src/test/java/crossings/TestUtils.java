package crossings;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lightBehaviours.LightBehaviour;
import lights.Location;

import java.util.HashMap;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static crossings.parameterEnums.LaneParameterKey.*;
import static crossings.parameterEnums.LaneType.*;

public class TestUtils {
    public static Map<LaneControllerType, Map<LaneParameterKey, Object>> getLaneParamMap(
            int goDuration, int cycleTime, LightBehaviour straightLightBehaviour, LightBehaviour pedestrianLightBehaviour, Location location) {
        var laneStraightParams = getControllerParamMap(
                goDuration, cycleTime, straightLightBehaviour, location
        );

        var lane = new HashMap();
        lane.put(STRAIGHT, laneStraightParams);

        var lanePedestrianParams = getControllerParamMap(
                goDuration, cycleTime, pedestrianLightBehaviour, location
        );

        lane.put(PEDESTRIAN, lanePedestrianParams);

        return lane;
    }

    public static Map<LaneParameterKey, Object> getControllerParamMap(int goDuration, int cycleTime, LightBehaviour lightBehaviour, Location location) {
        var laneStraightParams = new HashMap();
        laneStraightParams.put(NUMBER_LIGHTS, 2);
        laneStraightParams.put(LIGHT_BEHAVIOUR, lightBehaviour);
        laneStraightParams.put(LOCATION, location);
        laneStraightParams.put(GO_DURATION, goDuration);
        laneStraightParams.put(CYCLE_TIME, cycleTime);

        return laneStraightParams;
    }

    public static Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> getFourLaneParamMap(
            int goDuration, int cycleTime, LightBehaviour straightLightBehaviour, LightBehaviour pedestrianLightBehaviour, Location location) {

        var fourLanes = new HashMap();

        fourLanes.put(LEFT_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(RIGHT_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(TOP_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(BOTTOM_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));

        return fourLanes;
    }
}
