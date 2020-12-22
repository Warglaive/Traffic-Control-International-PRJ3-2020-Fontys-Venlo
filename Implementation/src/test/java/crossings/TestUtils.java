package crossings;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lane.Lane;
import lane.LaneStandard;
import lane.laneControllers.LaneController;
import lane.laneControllers.standard.PedestrianLaneControllerStandard;
import lane.laneControllers.standard.StraightLaneControllerStandard;
import lightBehaviours.LightBehaviour;
import lights.Location;
import lights.observer.ObserverLight;
import lights.observer.PedestrianObserverLightStandard;
import lights.observer.StraightTrafficObserverLight;
import lights.observer.StraightTrafficObserverLightStandard;
import ui.UILight.PedestrianLights.UIPedestrianLightObserverStandard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static crossings.parameterEnums.LaneParameterKey.*;
import static crossings.parameterEnums.LaneType.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestUtils {
    public static Map<LaneControllerType, Map<LaneParameterKey, Object>> getLaneParamMap(
            int goDuration, int cycleTime, LightBehaviour straightLightBehaviour, LightBehaviour pedestrianLightBehaviour, Location location) {
        var laneStraightParams = getControllerParamMap(
                goDuration, cycleTime, straightLightBehaviour, location
        );

        var lane = new HashMap();
        lane.put(STRAIGHT, laneStraightParams);

        var lanePedestrianParams = getControllerParamMap(
                goDuration, cycleTime, pedestrianLightBehaviour, location
        );

        lane.put(PEDESTRIAN, lanePedestrianParams);

        return lane;
    }

    public static Map<LaneParameterKey, Object> getControllerParamMap(int goDuration, int cycleTime, LightBehaviour lightBehaviour, Location location) {
        var laneStraightParams = new HashMap();
        laneStraightParams.put(NUMBER_LIGHTS, 2);
        laneStraightParams.put(LIGHT_BEHAVIOUR, lightBehaviour);
        laneStraightParams.put(LOCATION, location);
        laneStraightParams.put(GO_DURATION, goDuration);
        laneStraightParams.put(CYCLE_TIME, cycleTime);

        return laneStraightParams;
    }

    public static Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> getFourLaneParamMap(
            int goDuration, int cycleTime, LightBehaviour straightLightBehaviour, LightBehaviour pedestrianLightBehaviour, Location location) {

        var fourLanes = new HashMap();

        fourLanes.put(LEFT_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(RIGHT_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(TOP_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(BOTTOM_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));

        return fourLanes;
    }

    public static Map<LaneType, Map<String, Object>> getFullyMockedLanes(
            int goDuration, int cycleTime, LightBehaviour straightLightBehaviour, LightBehaviour pedestrianLightBehaviour, Location location
    ) {
            var leftLane = mock(LaneStandard.class);
            var rightLane = mock(LaneStandard.class);
            var topLane = mock(LaneStandard.class);
            var bottomLane = mock(LaneStandard.class);

            var straightLaneController = mock(StraightLaneControllerStandard.class);
            var pedestrianLaneController = mock(PedestrianLaneControllerStandard.class);

            var straightLightList = new ArrayList();
            var pedestrianLightList = new ArrayList();

            straightLightList.add(mock(StraightTrafficObserverLightStandard.class));
            pedestrianLightList.add(mock(PedestrianObserverLightStandard.class));

            TestUtils.setControllerBehaviour(
                    straightLaneController, pedestrianLaneController,
                    straightLightList, pedestrianLightList
            );

            setLaneBehaviour(leftLane, straightLaneController, pedestrianLaneController);
            setLaneBehaviour(rightLane,straightLaneController, pedestrianLaneController);
            setLaneBehaviour(topLane, straightLaneController, pedestrianLaneController);
            setLaneBehaviour(bottomLane, straightLaneController, pedestrianLaneController);


            var returnMap = new HashMap();

            addToMap(returnMap, leftLane, "Lane", LEFT_LANE);
            addToMap(returnMap, rightLane, "Lane", RIGHT_LANE);
            addToMap(returnMap, topLane, "Lane", TOP_LANE);
            addToMap(returnMap, bottomLane, "Lane", BOTTOM_LANE);

            return returnMap;
        }

        private static void addToMap(Map<LaneType, Map<String, Object>> map, Object item, String key, LaneType laneType) {
            if (map.containsKey(laneType)) {
                var innerMap = map.get(laneType);
                if (innerMap.containsKey(key)) {
                    innerMap.replace(key, item);
                }
            } else {
                var newInnerMap = new HashMap();
                newInnerMap.put(key, item);
                map.put(laneType, newInnerMap);
            }
        }

    private static void setLaneBehaviour(Lane lane, LaneController straightLaneController, LaneController pedestrianLaneController) {
        when(lane.getStraightLaneController()).thenReturn(straightLaneController);
        when(lane.getPedestrianLaneController()).thenReturn(pedestrianLaneController);
    }

     private static void setControllerBehaviour(
            LaneController straightLaneController, LaneController pedestrianLaneController,
            List<ObserverLight> straightLightList, List<ObserverLight> pedestrianLightList) {

        when(straightLaneController.getLights()).thenReturn(straightLightList);
        when(pedestrianLaneController.getLights()).thenReturn(pedestrianLightList);
    }

}
