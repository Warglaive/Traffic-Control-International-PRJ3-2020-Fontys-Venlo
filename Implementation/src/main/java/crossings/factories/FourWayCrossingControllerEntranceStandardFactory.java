package crossings.factories;

import crossings.FourWayCrossingControllerEntranceStandard;
import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import crossings.LaneType;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.STRAIGHT;
import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;

public class FourWayCrossingControllerEntranceStandardFactory {
    Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList;
    public int straightNumberLightsLeft; // chances
    public int pedestrianNumberLightsLeft;//int chances
    public int straightNumberLightsRight; //int chances
    public StraightTrafficLightBehaviour straightTrafficLightBehaviour;
    public int goDuration;//int chances
    public int cycleTime;// int chances
    public Location location;
    public int secondsBetweenLaneSwitch;
    //left Straight Map
    private HashMap leftStraightMap;
    //right Straight Map
    private HashMap rightStraightMap;
    //Top Straight Map
    private HashMap topStraightMap;
    //Bottom Straight Map
    private HashMap bottomStraightMap;

    //Getter
    public FourWayCrossingControllerEntranceStandard getFourWayCrossingControllerEntranceStandard(int straightNumberLightsLeft, int straightNumberLightsRight, int pedestrianNumberLightsLeft, StraightTrafficLightBehaviour straightTrafficLightBehaviour, int goDuration, int cycleTime, Location location, int secondsBetweenLaneSwitch) {
        //Initialize StraightMap HashMaps
        this.leftStraightMap = new HashMap();
        this.rightStraightMap = new HashMap();
        this.topStraightMap = new HashMap();
        this.bottomStraightMap = new HashMap();
        //Take values from Constructor
        this.straightNumberLightsLeft = straightNumberLightsLeft;
        this.pedestrianNumberLightsLeft = pedestrianNumberLightsLeft;
        this.straightNumberLightsRight = straightNumberLightsRight;
        this.goDuration = goDuration;
        this.cycleTime = cycleTime;
        this.location = location;
        this.secondsBetweenLaneSwitch = secondsBetweenLaneSwitch;
        //add values to laneMaps and then add laneMaps to ParameterMap
        var leftLaneMap = mapLeftStraight();
        var rightLaneMap = mapRightStraight();
        var topLaneMap = mapTopStraight();
        var bottomLaneMap = mapBottomStraight();
        //Parameter Map
        var parameterMap = new HashMap();
        //Direction map (Straight)
        leftLaneMap.put(STRAIGHT, leftStraightMap);
        //add laneMaps to ParameterMap
        parameterMap.put(LEFT_LANE, leftLaneMap);
        parameterMap.put(RIGHT_LANE, rightLaneMap);
        parameterMap.put(TOP_LANE, topLaneMap);
        parameterMap.put(BOTTOM_LANE, bottomLaneMap);

        return new FourWayCrossingControllerEntranceStandard(parameterList, secondsBetweenLaneSwitch);
    }

    public HashMap mapLeftStraight() {
        this.leftStraightMap.put(NUMBER_LIGHTS, this.straightNumberLightsLeft);
        this.leftStraightMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        this.leftStraightMap.put(LOCATION, this.location);
        this.leftStraightMap.put(GO_DURATION, this.goDuration);
        this.leftStraightMap.put(CYCLE_TIME, this.cycleTime);
        return this.leftStraightMap;
    }

    public HashMap mapRightStraight() {
        this.rightStraightMap.put(NUMBER_LIGHTS, this.straightNumberLightsLeft);
        this.rightStraightMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        this.rightStraightMap.put(LOCATION, this.location);
        this.rightStraightMap.put(GO_DURATION, this.goDuration);
        this.rightStraightMap.put(CYCLE_TIME, this.cycleTime);
        return this.rightStraightMap;
    }

    public HashMap mapTopStraight() {
        this.topStraightMap.put(NUMBER_LIGHTS, this.straightNumberLightsLeft);
        this.topStraightMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        this.topStraightMap.put(LOCATION, this.location);
        this.topStraightMap.put(GO_DURATION, this.goDuration);
        this.topStraightMap.put(CYCLE_TIME, this.cycleTime);
        return this.topStraightMap;
    }

    public HashMap mapBottomStraight() {
        this.bottomStraightMap.put(NUMBER_LIGHTS, this.straightNumberLightsLeft);
        this.bottomStraightMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        this.bottomStraightMap.put(LOCATION, this.location);
        this.bottomStraightMap.put(GO_DURATION, this.goDuration);
        this.bottomStraightMap.put(CYCLE_TIME, this.cycleTime);
        return this.bottomStraightMap;
    }
}
