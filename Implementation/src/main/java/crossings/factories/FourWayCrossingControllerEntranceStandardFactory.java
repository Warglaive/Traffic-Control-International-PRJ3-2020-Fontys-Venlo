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
        Map<LaneControllerType, Map<LaneParameterKey, Object>> leftStraightVehiclesMap = new HashMap<>();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> rightStraightVehiclesMap = new HashMap<>();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> topStraightVehiclesMap = new HashMap<>();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> bottomStraightVehiclesMap = new HashMap<>();
        //PedestrianMaps
        Map<LaneControllerType, Map<LaneParameterKey, Object>> leftStraightPedestriansMap = new HashMap<>();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> rightStraightPedestriansMap = new HashMap<>();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> topStraightPedestriansMap = new HashMap<>();
        Map<LaneControllerType, Map<LaneParameterKey, Object>> bottomStraightPedestriansMap = new HashMap<>();
        //Vehicles take Arguments from Methods
        //put the first arguments for each side in an array, iterate over each while executing the method.
        int[] straightNumberOfLightsVehicles = new int[]{straightNumberLightsLeftVehicles, straightNumberLightsRightVehicles, straightNumberLightsBottomVehicles, straightNumberLightsBottomVehicles};
        Map<LaneParameterKey, Object> leftLaneVehiclesArgumentsMap = mapStraightLaneVehiclesArguments(straightNumberOfLightsVehicles[0], goDurationVehiclesLight, cycleTimeVehiclesLight, location, straightTrafficLightBehaviour);
        Map<LaneParameterKey, Object> rightLaneVehiclesArgumentsMap = mapStraightLaneVehiclesArguments(straightNumberOfLightsVehicles[1], goDurationVehiclesLight, cycleTimeVehiclesLight, location, straightTrafficLightBehaviour);
        Map<LaneParameterKey, Object> topLaneVehiclesArgumentsMap = mapStraightLaneVehiclesArguments(straightNumberOfLightsVehicles[2], goDurationVehiclesLight, cycleTimeVehiclesLight, location, straightTrafficLightBehaviour);
        Map<LaneParameterKey, Object> bottomLaneVehiclesArgumentsMap = mapStraightLaneVehiclesArguments(straightNumberOfLightsVehicles[3], goDurationVehiclesLight, cycleTimeVehiclesLight, location, straightTrafficLightBehaviour);

        //Pedestrians take Arguments from Methods
        //put the first arguments for each side in an array, iterate over each while executing the method.
        int[] straightNumberOfLightsPedestrians = new int[]{straightNumberLightsLeftPedestrians, straightNumberLightsRightPedestrians, straightNumberLightsTopPedestrians, straightNumberLightsBottomPedestrians};
        Map<LaneParameterKey, Object> leftLanePedestriansArgumentsMap = mapStraightLanePedestrianArguments(straightNumberOfLightsPedestrians[0], goDurationPedestriansLight, cycleTimePedestrianLight, location, pedestrianLightBehaviour);
        Map<LaneParameterKey, Object> rightLanePedestrianArgumentsMap = mapStraightLanePedestrianArguments(straightNumberOfLightsPedestrians[1], goDurationPedestriansLight, cycleTimePedestrianLight, location, pedestrianLightBehaviour);
        Map<LaneParameterKey, Object> topLanePedestrianArgumentsMap = mapStraightLanePedestrianArguments(straightNumberOfLightsPedestrians[2], goDurationPedestriansLight, cycleTimePedestrianLight, location, pedestrianLightBehaviour);
        Map<LaneParameterKey, Object> bottomLanePedestrianArgumentsMap = mapStraightLanePedestrianArguments(straightNumberOfLightsPedestrians[3], goDurationPedestriansLight, cycleTimePedestrianLight, location, pedestrianLightBehaviour);
        //Parameter Map
        Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterMap = new HashMap<>();
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


    private Map<LaneParameterKey, Object> mapStraightLanePedestrianArguments(int straightNumberLightsLeftPedestrians, int goDuration, int cycleTime, Location location, PedestrianLightBehaviour straightTrafficLightBehaviour) {
        Map<LaneParameterKey, Object> leftLaneArgumentsMap = new HashMap<>();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsLeftPedestrians);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;
    }

    //Vehicles Argument map methods
    private Map<LaneParameterKey, Object> mapStraightLaneVehiclesArguments(int straightNumberLightsLeft, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        Map<LaneParameterKey, Object> leftLaneArgumentsMap = new HashMap<>();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsLeft);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;
    }
}
