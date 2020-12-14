package crossings.factories;

import crossings.FourWayCrossingControllerEntranceStandard;
import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import crossings.LaneType;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    int cycleTime;// int chances
    Location location;
    int secondsBetweenLaneSwitch;

    //Getter
    public FourWayCrossingControllerEntranceStandard getFourWayCrossingControllerEntranceStandard(int straightNumberLightsLeft, int straightNumberLightsRight, int pedestrianNumberLightsLeft, StraightTrafficLightBehaviour straightTrafficLightBehaviour, int goDuration, int cycleTime, Location location, int secondsBetweenLaneSwitch) {
        this.parameterList = new HashMap<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>>();
        this.straightNumberLightsLeft = straightNumberLightsLeft;
        this.pedestrianNumberLightsLeft = pedestrianNumberLightsLeft;
        this.straightNumberLightsRight = straightNumberLightsRight;
        this.goDuration = goDuration;
        this.cycleTime = cycleTime;
        this.location = location;
        this.secondsBetweenLaneSwitch = secondsBetweenLaneSwitch;
        var parameterMap = new HashMap();
        var leftLaneMap = new HashMap();
        var leftStraightMap = new HashMap();
        //make a method for the args.
        //

        leftLaneMap.put(STRAIGHT, leftStraightMap);
        parameterMap.put(LEFT_LANE, leftLaneMap);

        parameterMap.put(LEFT_LANE, leftLaneMap);
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
    }
}
