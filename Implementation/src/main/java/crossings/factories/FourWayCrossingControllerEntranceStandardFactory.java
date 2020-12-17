package crossings.factories;

import crossings.FourWayCrossingControllerEntranceStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;

import static crossings.LaneControllerType.PEDESTRIAN;
import static crossings.LaneControllerType.STRAIGHT;
import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;

public class FourWayCrossingControllerEntranceStandardFactory {

    //Getter
    public FourWayCrossingControllerEntranceStandard getFourWayCrossingControllerEntranceStandard(
            int straightNumberLightsLeft, int pedestrianNumberLightsLeft, int straightNumberLightsRight,
            int pedestrianNumberLightsRight, int straightNumberLightsTop, int pedestrianNumberLightsTop,
            int straightNumberLightsBottom, int pedestrianNumberLightsBottom,
            StraightTrafficLightBehaviour straightTrafficLightBehaviour, int goDuration, int cycleTime, Location location,
            int secondsBetweenLaneSwitch) {
        //VehiclesMaps
        var leftStraightVehiclesMap = new HashMap();
        var rightStraightVehiclesMap = new HashMap();
        var topStraightVehiclesMap = new HashMap();
        var bottomStraightVehiclesMap = new HashMap();
        //PedestrianMaps
        var leftStraightPedestriansMap = new HashMap();
        var rightStraightPedestriansMap = new HashMap();
        var topStraightPedestriansMap = new HashMap();
        var bottomStraightPedestriansMap = new HashMap();
        //
        var leftLaneVehiclesArgumentsMap = mapLeftStraighVehiclestLane(straightNumberLightsLeft, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var rightLaneVehiclesArgumentsMap = mapRightStraightVehiclesLane(straightNumberLightsRight, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var topLaneVehiclesArgumentsMap = mapTopStraightVehiclesLane(straightNumberLightsTop, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var bottomLaneVehiclesArgumentsMap = mapBottomStraightVehiclesLane(straightNumberLightsBottom, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        //Parameter Map
        var parameterMap = new HashMap();
        //Vehicles
        leftStraightVehiclesMap.put(STRAIGHT, leftLaneVehiclesArgumentsMap);
        rightStraightVehiclesMap.put(STRAIGHT, rightLaneVehiclesArgumentsMap);
        topStraightVehiclesMap.put(STRAIGHT, topLaneVehiclesArgumentsMap);
        bottomStraightVehiclesMap.put(STRAIGHT, bottomLaneVehiclesArgumentsMap);
        //Pedestrian
        leftStraightPedestriansMap.put(PEDESTRIAN, pedestrianNumberLightsLeft);
        rightStraightPedestriansMap.put(PEDESTRIAN, pedestrianNumberLightsRight);
        topStraightPedestriansMap.put(PEDESTRIAN, pedestrianNumberLightsTop);
        bottomStraightPedestriansMap.put(PEDESTRIAN, pedestrianNumberLightsBottom);

        //add laneMaps to ParameterMap
        parameterMap.put(LEFT_LANE, leftStraightVehiclesMap);
        parameterMap.put(RIGHT_LANE, rightStraightVehiclesMap);
        parameterMap.put(TOP_LANE, topStraightVehiclesMap);
        parameterMap.put(BOTTOM_LANE, bottomStraightVehiclesMap);

        return new FourWayCrossingControllerEntranceStandard(parameterMap, secondsBetweenLaneSwitch);
    }

    public HashMap mapLeftStraighVehiclestLane(int straightNumberLightsLeft, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var leftLaneMap = new HashMap();
        leftLaneMap.put(NUMBER_LIGHTS, straightNumberLightsLeft);
        leftLaneMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneMap.put(LOCATION, location);
        leftLaneMap.put(GO_DURATION, goDuration);
        leftLaneMap.put(CYCLE_TIME, cycleTime);
        return leftLaneMap;
    }

    public HashMap mapRightStraightVehiclesLane(int straightNumberLightsRight, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var rightLaneMap = new HashMap();
        rightLaneMap.put(NUMBER_LIGHTS, straightNumberLightsRight);
        rightLaneMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        rightLaneMap.put(LOCATION, location);
        rightLaneMap.put(GO_DURATION, goDuration);
        rightLaneMap.put(CYCLE_TIME, cycleTime);
        return rightLaneMap;
    }

    public HashMap mapTopStraightVehiclesLane(int straightNumberLightsTop, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var topLaneMap = new HashMap();
        topLaneMap.put(NUMBER_LIGHTS, straightNumberLightsTop);
        topLaneMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        topLaneMap.put(LOCATION, location);
        topLaneMap.put(GO_DURATION, goDuration);
        topLaneMap.put(CYCLE_TIME, cycleTime);
        return topLaneMap;
    }

    public HashMap mapBottomStraightVehiclesLane(int straightNumberLightsBottom, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var bottomLaneMap = new HashMap();
        bottomLaneMap.put(NUMBER_LIGHTS, straightNumberLightsBottom);
        bottomLaneMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        bottomLaneMap.put(LOCATION, location);
        bottomLaneMap.put(GO_DURATION, goDuration);
        bottomLaneMap.put(CYCLE_TIME, cycleTime);
        return bottomLaneMap;
    }
}
