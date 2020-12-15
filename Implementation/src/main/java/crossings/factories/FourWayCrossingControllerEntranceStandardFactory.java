package crossings.factories;

import crossings.FourWayCrossingControllerEntranceStandard;
import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import crossings.LaneType;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.PEDESTRIAN;
import static crossings.LaneControllerType.STRAIGHT;
import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;

public class FourWayCrossingControllerEntranceStandardFactory {
    Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList;

    //Getter
    public FourWayCrossingControllerEntranceStandard getFourWayCrossingControllerEntranceStandard(
            int straightNumberLightsLeft, int pedestrianNumberLightsLeft, int straightNumberLightsRight,
            int pedestrianNumberLightsRight, int straightNumberLightsTop, int pedestrianNumberLightsTop,
            int straightNumberLightsBottom, int pedestrianNumberLightsBottom,
            StraightTrafficLightBehaviour straightTrafficLightBehaviour, int goDuration, int cycleTime, Location location,
            int secondsBetweenLaneSwitch) {
        //
        //Initialize StraightMap HashMaps
        var leftStraightMap = new HashMap();
        var rightStraightMap = new HashMap();
        var topStraightMap = new HashMap();
        var bottomStraightMap = new HashMap();
        var leftLaneMap = mapLeftStraightLane(straightNumberLightsLeft, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var rightLaneMap = mapRightStraightLane(straightNumberLightsRight, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var topLaneMap = mapTopStraightLane(straightNumberLightsTop, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var bottomLaneMap = mapBottomStraightLane(straightNumberLightsBottom, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        //Parameter Map
        var parameterMap = new HashMap();
        //Left lane straight direction map
        leftLaneMap.put(STRAIGHT, leftStraightMap);
        leftLaneMap.put(PEDESTRIAN, pedestrianNumberLightsLeft);
        //Right lane straight direction map
        rightLaneMap.put(STRAIGHT, rightStraightMap);
        rightLaneMap.put(PEDESTRIAN, pedestrianNumberLightsRight);
        //Top lane straight direction map
        topLaneMap.put(STRAIGHT, topStraightMap);
        topLaneMap.put(PEDESTRIAN, pedestrianNumberLightsTop);
        //Bottom lane straight direction map
        bottomLaneMap.put(STRAIGHT, bottomStraightMap);
        topLaneMap.put(PEDESTRIAN, pedestrianNumberLightsBottom);

        //add laneMaps to ParameterMap
        parameterMap.put(LEFT_LANE, leftLaneMap);
        parameterMap.put(RIGHT_LANE, rightLaneMap);
        parameterMap.put(TOP_LANE, topLaneMap);
        parameterMap.put(BOTTOM_LANE, bottomLaneMap);

        return new FourWayCrossingControllerEntranceStandard(this.parameterList, secondsBetweenLaneSwitch);
    }

    public HashMap mapLeftStraightLane(int straightNumberLightsLeft, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var leftLaneMap = new HashMap();
        leftLaneMap.put(NUMBER_LIGHTS, straightNumberLightsLeft);
        leftLaneMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneMap.put(LOCATION, location);
        leftLaneMap.put(GO_DURATION, goDuration);
        leftLaneMap.put(CYCLE_TIME, cycleTime);
        return leftLaneMap;
    }

    public HashMap mapRightStraightLane(int straightNumberLightsRight, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var rightLaneMap = new HashMap();
        rightLaneMap.put(NUMBER_LIGHTS, straightNumberLightsRight);
        rightLaneMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        rightLaneMap.put(LOCATION, location);
        rightLaneMap.put(GO_DURATION, goDuration);
        rightLaneMap.put(CYCLE_TIME, cycleTime);
        return rightLaneMap;
    }

    public HashMap mapTopStraightLane(int straightNumberLightsTop, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var topLaneMap = new HashMap();
        topLaneMap.put(NUMBER_LIGHTS, straightNumberLightsTop);
        topLaneMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        topLaneMap.put(LOCATION, location);
        topLaneMap.put(GO_DURATION, goDuration);
        topLaneMap.put(CYCLE_TIME, cycleTime);
        return topLaneMap;
    }

    public HashMap mapBottomStraightLane(int straightNumberLightsBottom, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var bottomLaneMap = new HashMap();
        bottomLaneMap.put(NUMBER_LIGHTS, straightNumberLightsBottom);
        bottomLaneMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        bottomLaneMap.put(LOCATION, location);
        bottomLaneMap.put(GO_DURATION, goDuration);
        bottomLaneMap.put(CYCLE_TIME, cycleTime);
        return bottomLaneMap;
    }
}
