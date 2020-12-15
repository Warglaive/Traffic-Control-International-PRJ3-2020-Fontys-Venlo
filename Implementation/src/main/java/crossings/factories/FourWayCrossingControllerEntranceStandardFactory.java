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

    public StraightTrafficLightBehaviour straightTrafficLightBehaviour; //remains the same
    public int goDuration;//int changes
    public int cycleTime;// int changes
    public Location location; //remains the same
    public int secondsBetweenLaneSwitch;

    //Getter
    public FourWayCrossingControllerEntranceStandard getFourWayCrossingControllerEntranceStandard(
            int straightNumberLightsLeft, int pedestrianNumberLightsLeft, int straightNumberLightsRight,
            int pedestrianNumberLightsRight, int straightNumberLightsTop, int pedestrianNumberLightsTop,
            int straightNumberLightsBottom, int pedestrianNumberLightsBottom,
            StraightTrafficLightBehaviour straightTrafficLightBehaviour, int goDuration, int cycleTime, Location location,
            int secondsBetweenLaneSwitch) {
        //
        this.straightTrafficLightBehaviour = straightTrafficLightBehaviour;
        //Initialize StraightMap HashMaps
        var leftStraightMap = new HashMap();
        var rightStraightMap = new HashMap();
        var topStraightMap = new HashMap();
        var bottomStraightMap = new HashMap();
        this.goDuration = goDuration;
        this.cycleTime = cycleTime;
        this.location = location;
        this.secondsBetweenLaneSwitch = secondsBetweenLaneSwitch;
        var leftLaneMap = mapLeftStraightLane(straightNumberLightsLeft, goDuration, cycleTime, location);
        var rightLaneMap = mapRightStraightLane(straightNumberLightsRight, goDuration, cycleTime, location);
        var topLaneMap = mapTopStraightLane(straightNumberLightsTop, goDuration, cycleTime, location);
        var bottomLaneMap = mapBottomStraightLane(straightNumberLightsBottom, goDuration, cycleTime, location);
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

    public HashMap mapLeftStraightLane(int straightNumberLightsLeft, int goDuration, int cycleTime, Location location) {
        var leftLaneMap = new HashMap();
        leftLaneMap.put(NUMBER_LIGHTS, straightNumberLightsLeft);
        leftLaneMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        leftLaneMap.put(LOCATION, location);
        leftLaneMap.put(GO_DURATION, goDuration);
        leftLaneMap.put(CYCLE_TIME, cycleTime);
        return leftLaneMap;
    }

    public HashMap mapRightStraightLane(int straightNumberLightsRight, int goDuration, int cycleTime, Location location) {
        var rightLaneMap = new HashMap();
        rightLaneMap.put(NUMBER_LIGHTS, straightNumberLightsRight);
        rightLaneMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        rightLaneMap.put(LOCATION, location);
        rightLaneMap.put(GO_DURATION, goDuration);
        rightLaneMap.put(CYCLE_TIME, cycleTime);
        return rightLaneMap;
    }

    public HashMap mapTopStraightLane(int straightNumberLightsTop, int goDuration, int cycleTime, Location location) {
        var topLaneMap = new HashMap();
        topLaneMap.put(NUMBER_LIGHTS, straightNumberLightsTop);
        topLaneMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        topLaneMap.put(LOCATION, location);
        topLaneMap.put(GO_DURATION, goDuration);
        topLaneMap.put(CYCLE_TIME, cycleTime);
        return topLaneMap;
    }

    public HashMap mapBottomStraightLane(int straightNumberLightsBottom, int goDuration, int cycleTime, Location location) {
        var bottomLaneMap = new HashMap();
        bottomLaneMap.put(NUMBER_LIGHTS, straightNumberLightsBottom);
        bottomLaneMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        bottomLaneMap.put(LOCATION, location);
        bottomLaneMap.put(GO_DURATION, goDuration);
        bottomLaneMap.put(CYCLE_TIME, cycleTime);
        return bottomLaneMap;
    }
}
