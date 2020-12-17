package crossings.factories;

import crossings.crossingControllers.fourWay.FourWayCrossingControllerEntranceStandard;
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
            //
            StraightTrafficLightBehaviour straightTrafficLightBehaviour,
            int goDuration, int cycleTime, Location location,
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
        //Vehicles take Arguments from Methods
        var leftLaneVehiclesArgumentsMap = mapLeftStraightVehiclesArgumentsLane(straightNumberLightsLeftVehicles, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var rightLaneVehiclesArgumentsMap = mapRightStraightVehiclesArgumentsLane(straightNumberLightsRightVehicles, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var topLaneVehiclesArgumentsMap = mapTopStraightVehiclesArgumentsLane(straightNumberLightsTopVehicles, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        var bottomLaneVehiclesArgumentsMap = mapBottomStraightVehiclesArgumentsLane(straightNumberLightsBottomVehicles, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        //Pedestrians take Arguments from Methods
        HashMap leftLanePedestriansArgumentsMap = mapLeftStraightPedestrianArgumentsLane(straightNumberLightsLeftPedestrians, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        HashMap rightLanePedestrianArgumentsMap = mapRightStraightPedestrianArgumentsLane(straightNumberLightsRightPedestrians, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        HashMap topLanePedestrianArgumentsMap = mapTopStraightPedestrianArgumentsLane(straightNumberLightsTopPedestrians, goDuration, cycleTime, location, straightTrafficLightBehaviour);
        HashMap bottomLanePedestrianArgumentsMap = mapBottomStraightPedestrianArgumentsLane(straightNumberLightsBottomPedestrians, goDuration, cycleTime, location, straightTrafficLightBehaviour);
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

    private HashMap mapBottomStraightPedestrianArgumentsLane(int straightNumberLightsBottomPedestrians, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
    }

    private HashMap mapTopStraightPedestrianArgumentsLane(int straightNumberLightsTopPedestrians, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
    }


    private HashMap mapRightStraightPedestrianArgumentsLane(int straightNumberLightsRightPedestrians, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
    }

    private HashMap mapLeftStraightPedestrianArgumentsLane(int straightNumberLightsLeftPedestrians, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
    }


    public HashMap mapLeftStraightVehiclesArgumentsLane(int straightNumberLightsLeft, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var leftLaneArgumentsMap = new HashMap();
        leftLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsLeft);
        leftLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneArgumentsMap.put(LOCATION, location);
        leftLaneArgumentsMap.put(GO_DURATION, goDuration);
        leftLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return leftLaneArgumentsMap;
    }

    public HashMap mapRightStraightVehiclesArgumentsLane(int straightNumberLightsRight, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var rightLaneArgumentsMap = new HashMap();
        rightLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsRight);
        rightLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        rightLaneArgumentsMap.put(LOCATION, location);
        rightLaneArgumentsMap.put(GO_DURATION, goDuration);
        rightLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return rightLaneArgumentsMap;
    }

    public HashMap mapTopStraightVehiclesArgumentsLane(int straightNumberLightsTop, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var topLaneArgumentsMap = new HashMap();
        topLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsTop);
        topLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        topLaneArgumentsMap.put(LOCATION, location);
        topLaneArgumentsMap.put(GO_DURATION, goDuration);
        topLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return topLaneArgumentsMap;
    }

    public HashMap mapBottomStraightVehiclesArgumentsLane(int straightNumberLightsBottom, int goDuration, int cycleTime, Location location, StraightTrafficLightBehaviour straightTrafficLightBehaviour) {
        var bottomLaneArgumentsMap = new HashMap();
        bottomLaneArgumentsMap.put(NUMBER_LIGHTS, straightNumberLightsBottom);
        bottomLaneArgumentsMap.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        bottomLaneArgumentsMap.put(LOCATION, location);
        bottomLaneArgumentsMap.put(GO_DURATION, goDuration);
        bottomLaneArgumentsMap.put(CYCLE_TIME, cycleTime);
        return bottomLaneArgumentsMap;
    }
}
