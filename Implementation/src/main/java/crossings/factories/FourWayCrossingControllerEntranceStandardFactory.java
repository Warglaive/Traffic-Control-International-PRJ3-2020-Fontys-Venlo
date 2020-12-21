package crossings.factories;

import crossings.crossingControllers.fourWay.FourWayCrossingControllerEntranceStandard;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;

import java.util.HashMap;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static crossings.parameterEnums.LaneParameterKey.*;
import static crossings.parameterEnums.LaneType.*;

public class FourWayCrossingControllerEntranceStandardFactory {
    //Getter

    public FourWayCrossingControllerEntranceStandard getFourWayCrossingControllerEntranceStandard(
            //all number of lights is for straight crossings
            //Vehicles number of lights per lane
            int straightNumberLightsLeftVehicles,
            int straightNumberLightsRightVehicles,
            int straightNumberLightsTopVehicles,
            int straightNumberLightsBottomVehicles,
            //Pedestrians number of lights per lane
            int straightNumberLightsLeftPedestrians,
            int straightNumberLightsRightPedestrians,
            int straightNumberLightsTopPedestrians,
            int straightNumberLightsBottomPedestrians,
            //Vehicles traffic light behaviour
            StraightTrafficLightBehaviour straightTrafficLightBehaviour,
            //Pedestrian traffic light behaviour
            PedestrianLightBehaviour pedestrianLightBehaviour,
            //GoDuration Vehicles
            int goDurationVehiclesLight,
            int goDurationPedestriansLight,
            //CycleTimeVehicles
            int cycleTimeVehiclesLight,
            int cycleTimePedestrianLight,
            //Location
            Location location,
            int secondsBetweenLaneSwitch) {
        //VehiclesMaps
        Map<LaneControllerType, Map<LaneParameterKey, Object>> leftStraightVehiclesMap = new HashMap();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> rightStraightVehiclesMap = new HashMap();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> topStraightVehiclesMap = new HashMap();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> bottomStraightVehiclesMap = new HashMap();
        //PedestrianMaps
        Map<LaneControllerType, Map<LaneParameterKey, Object>> leftStraightPedestriansMap = new HashMap();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> rightStraightPedestriansMap = new HashMap();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> topStraightPedestriansMap = new HashMap();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> bottomStraightPedestriansMap = new HashMap();
        //Vehicles take Arguments from Methods
        Map<LaneParameterKey, Object> leftLaneVehiclesArgumentsMap = mapLeftStraightVehiclesArgumentsLane(straightNumberLightsLeftVehicles, goDurationVehiclesLight, cycleTimeVehiclesLight, location, straightTrafficLightBehaviour);
        Map<LaneParameterKey, Object> rightLaneVehiclesArgumentsMap = mapRightStraightVehiclesArgumentsLane(straightNumberLightsRightVehicles, goDurationVehiclesLight, cycleTimeVehiclesLight, location, straightTrafficLightBehaviour);
        Map<LaneParameterKey, Object> topLaneVehiclesArgumentsMap = mapTopStraightVehiclesArgumentsLane(straightNumberLightsTopVehicles, goDurationVehiclesLight, cycleTimeVehiclesLight, location, straightTrafficLightBehaviour);
        Map<LaneParameterKey, Object> bottomLaneVehiclesArgumentsMap = mapBottomStraightVehiclesArgumentsLane(straightNumberLightsBottomVehicles, goDurationVehiclesLight, cycleTimeVehiclesLight, location, straightTrafficLightBehaviour);
        //Pedestrians take Arguments from Methods
        Map<LaneParameterKey, Object> leftLanePedestriansArgumentsMap = mapLeftStraightPedestrianArgumentsLane(straightNumberLightsLeftPedestrians, goDurationPedestriansLight, cycleTimePedestrianLight, location, pedestrianLightBehaviour);
        Map<LaneParameterKey, Object> rightLanePedestrianArgumentsMap = mapRightStraightPedestrianArgumentsLane(straightNumberLightsRightPedestrians, goDurationPedestriansLight, cycleTimePedestrianLight, location, pedestrianLightBehaviour);
        Map<LaneParameterKey, Object> topLanePedestrianArgumentsMap = mapTopStraightPedestrianArgumentsLane(straightNumberLightsTopPedestrians, goDurationPedestriansLight, cycleTimePedestrianLight, location, pedestrianLightBehaviour);
        Map<LaneParameterKey, Object> bottomLanePedestrianArgumentsMap = mapBottomStraightPedestrianArgumentsLane(straightNumberLightsBottomPedestrians, goDurationPedestriansLight, cycleTimePedestrianLight, location, pedestrianLightBehaviour);
        //Parameter Map
        Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterMap = new HashMap();
        //Vehicles
        leftStraightVehiclesMap.put(STRAIGHT, leftLaneVehiclesArgumentsMap);
        rightStraightVehiclesMap.put(STRAIGHT, rightLaneVehiclesArgumentsMap);
        topStraightVehiclesMap.put(STRAIGHT, topLaneVehiclesArgumentsMap);
        bottomStraightVehiclesMap.put(STRAIGHT, bottomLaneVehiclesArgumentsMap);
        //Pedestrian
        leftStraightPedestriansMap.put(PEDESTRIAN, leftLanePedestriansArgumentsMap);
        rightStraightPedestriansMap.put(PEDESTRIAN, rightLanePedestrianArgumentsMap);
        topStraightPedestriansMap.put(PEDESTRIAN, topLanePedestrianArgumentsMap);
        bottomStraightPedestriansMap.put(PEDESTRIAN, bottomLanePedestrianArgumentsMap);

        //add laneVehiclesMaps to ParameterMap
        parameterMap.put(LEFT_LANE, leftStraightVehiclesMap);
        parameterMap.put(RIGHT_LANE, rightStraightVehiclesMap);
        parameterMap.put(TOP_LANE, topStraightVehiclesMap);
        parameterMap.put(BOTTOM_LANE, bottomStraightVehiclesMap);
        //add laneVehiclesMaps to ParameterMap
        parameterMap.put(LEFT_LANE, leftStraightPedestriansMap);
        parameterMap.put(RIGHT_LANE, rightStraightPedestriansMap);
        parameterMap.put(TOP_LANE, topStraightPedestriansMap);
        parameterMap.put(BOTTOM_LANE, bottomStraightPedestriansMap);
        return new FourWayCrossingControllerEntranceStandard(parameterMap, secondsBetweenLaneSwitch);
    }

    //Pedestrians Argument map methods
    private HashMap mapBottomStraightPedestrianArgumentsLane(int straightNumberLightsBottomPedestrians, int goDuration, int cycleTime, Location location, PedestrianLightBehaviour straightTrafficLightBehaviour) {
        var leftLaneArgumentsMap = new HashMap();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsBottomPedestrians);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;

    }

    private HashMap mapTopStraightPedestrianArgumentsLane(int straightNumberLightsTopPedestrians, int goDuration, int cycleTime, Location location, PedestrianLightBehaviour straightTrafficLightBehaviour) {
        var leftLaneArgumentsMap = new HashMap();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsTopPedestrians);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;
    }

    private HashMap mapRightStraightPedestrianArgumentsLane(int straightNumberLightsRightPedestrians, int goDuration, int cycleTime, Location location, PedestrianLightBehaviour straightTrafficLightBehaviour) {
        var leftLaneArgumentsMap = new HashMap();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsRightPedestrians);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;
    }

    private HashMap mapLeftStraightPedestrianArgumentsLane(int straightNumberLightsLeftPedestrians, int goDuration, int cycleTime, Location location, PedestrianLightBehaviour straightTrafficLightBehaviour) {
        var leftLaneArgumentsMap = new HashMap();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsLeftPedestrians);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;
    }

    //Vehicles Argument map methods
    private Map<LaneParameterKey, Object> mapLeftStraightVehiclesArgumentsLane(int straightNumberLightsLeft, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        Map<LaneParameterKey, Object> leftLaneArgumentsMap = new HashMap();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsLeft);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;
    }

    private Map<LaneParameterKey, Object> mapRightStraightVehiclesArgumentsLane(int straightNumberLightsRight, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        Map<LaneParameterKey, Object> rightLaneArgumentsMap = new HashMap();
        rightLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsRight);
        rightLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        rightLaneArgumentsMap.put(LOCATION, location);
        rightLaneArgumentsMap.put(GO_DURATION, goDuration);
        rightLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return rightLaneArgumentsMap;
    }

    private Map<LaneParameterKey, Object> mapTopStraightVehiclesArgumentsLane(int straightNumberLightsTop, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        Map<LaneParameterKey, Object> topLaneArgumentsMap = new HashMap();
        topLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsTop);
        topLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        topLaneArgumentsMap.put(LOCATION, location);
        topLaneArgumentsMap.put(GO_DURATION, goDuration);
        topLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return topLaneArgumentsMap;
    }

    private Map<LaneParameterKey, Object> mapBottomStraightVehiclesArgumentsLane(int straightNumberLightsBottom, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        Map<LaneParameterKey, Object> bottomLaneArgumentsMap = new HashMap();
        bottomLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsBottom);
        bottomLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        bottomLaneArgumentsMap.put(LOCATION, location);
        bottomLaneArgumentsMap.put(GO_DURATION, goDuration);
        bottomLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return bottomLaneArgumentsMap;
    }
    /*
    String[] bla = String{"bottom","top"};
    for(int i = 0; i<bla.length();i++))
    {
        bla[i]+laneArgumentsMap.
    }
    */
}
