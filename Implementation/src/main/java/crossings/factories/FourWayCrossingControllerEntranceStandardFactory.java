package crossings.factories;

import crossings.FourWayCrossingControllerEntranceStandard;
import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import crossings.LaneType;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.*;
import static crossings.LaneType.*;
import static crossings.LaneParameterKey.*;

public class FourWayCrossingControllerEntranceStandardFactory {
    Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList;


    int straightNumberLightsLeft; // chances
    int pedestrianNumberLightsLeft;//int chances
    int straightNumberLightsRight; //int chances
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;
    int goDuration;//int chances
    int cycleTime;// int c
    Location location;
    int secondsBetweenLaneSwitch;

    //Getter
    public FourWayCrossingControllerEntranceStandard getFourWayCrossingControllerEntranceStandard(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        this.parameterList = parameterList;
        this.secondsBetweenLaneSwitch = secondsBetweenLaneSwitch;
        var parameterMap = new HashMap();
        var leftLaneMap = new HashMap();
        var leftStraightMap = new HashMap();
        //make a method for the args.
        //

        leftLaneMap.put(STRAIGHT,leftStraightMap);
        parameterMap.put(LEFT_LANE,leftLaneMap);

        parameterMap.put(LEFT_LANE,leftLaneMap);
        return new

    FourWayCrossingControllerEntranceStandard(parameterList, secondsBetweenLaneSwitch);


   /*void mapLeftStraight() {
        leftStraightMap.put(NUMBER_LIGHTS, straightNumberLightsLeft);
        leftStraightMap.put(LIGHT_BEHAVIOUR, straightLightsBehaviour);
        leftStraightMap.put(LOCATION, location);
        leftStraightMap.put(GO_DURATION, goDuration);
        leftStraightMap.put(CYCLE_TIME, cycleTime);
        return leftStraightMap;
    }

    */
}}