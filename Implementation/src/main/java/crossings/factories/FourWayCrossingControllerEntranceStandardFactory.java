package crossings.factories;

import crossings.crossingControllers.fourWay.FourWayCrossingControllerEntranceStandard;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;

import java.util.HashMap;

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
            int goDuration, int cycleTime, Location location,
            int secondsBetweenLaneSwitch) {
        //VehiclesMaps
        HashMap leftStraightVehiclesMap = new HashMap();
        HashMap rightStraightVehiclesMap = new HashMap();
        HashMap topStraightVehiclesMap = new HashMap();
        HashMap bottomStraightVehiclesMap = new HashMap();
        //PedestrianMaps
        HashMap leftStraightPedestriansMap = new HashMap();
        HashMap rightStraightPedestriansMap = new HashMap();
        HashMap topStraightPedestriansMap = new HashMap();
        HashMap bottomStraightPedestriansMap = new HashMap();
        //Vehicles take Arguments from Methods
        HashMap leftLaneVehiclesArgumentsMap = mapLeftStraightVehiclesArgumentsLane(straightNumberLightsLeftVehicles, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        HashMap rightLaneVehiclesArgumentsMap = mapRightStraightVehiclesArgumentsLane(straightNumberLightsRightVehicles, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        HashMap topLaneVehiclesArgumentsMap = mapTopStraightVehiclesArgumentsLane(straightNumberLightsTopVehicles, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        HashMap bottomLaneVehiclesArgumentsMap = mapBottomStraightVehiclesArgumentsLane(straightNumberLightsBottomVehicles, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        //Pedestrians take Arguments from Methods
        HashMap leftLanePedestriansArgumentsMap = mapLeftStraightPedestrianArgumentsLane(straightNumberLightsLeftPedestrians, goDuration, cycleTime, location, pedestrianLightBehaviour);
        HashMap rightLanePedestrianArgumentsMap = mapRightStraightPedestrianArgumentsLane(straightNumberLightsRightPedestrians, goDuration, cycleTime, location, pedestrianLightBehaviour);
        HashMap topLanePedestrianArgumentsMap = mapTopStraightPedestrianArgumentsLane(straightNumberLightsTopPedestrians, goDuration, cycleTime, location, pedestrianLightBehaviour);
        HashMap bottomLanePedestrianArgumentsMap = mapBottomStraightPedestrianArgumentsLane(straightNumberLightsBottomPedestrians, goDuration, cycleTime, location, pedestrianLightBehaviour);
        //Parameter Map
        HashMap parameterMap = new HashMap();
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
    private HashMap mapLeftStraightVehiclesArgumentsLane(int straightNumberLightsLeft, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var leftLaneArgumentsMap = new HashMap();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsLeft);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;
    }

    private HashMap mapRightStraightVehiclesArgumentsLane(int straightNumberLightsRight, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var rightLaneArgumentsMap = new HashMap();
        rightLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsRight);
        rightLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        rightLaneArgumentsMap.put(LOCATION, location);
        rightLaneArgumentsMap.put(GO_DURATION, goDuration);
        rightLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return rightLaneArgumentsMap;
    }

    private HashMap mapTopStraightVehiclesArgumentsLane(int straightNumberLightsTop, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var topLaneArgumentsMap = new HashMap();
        topLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsTop);
        topLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        topLaneArgumentsMap.put(LOCATION, location);
        topLaneArgumentsMap.put(GO_DURATION, goDuration);
        topLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return topLaneArgumentsMap;
    }

    private HashMap mapBottomStraightVehiclesArgumentsLane(int straightNumberLightsBottom, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var bottomLaneArgumentsMap = new HashMap();
        bottomLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsBottom);
        bottomLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        bottomLaneArgumentsMap.put(LOCATION, location);
        bottomLaneArgumentsMap.put(GO_DURATION, goDuration);
        bottomLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return bottomLaneArgumentsMap;
    }
}
