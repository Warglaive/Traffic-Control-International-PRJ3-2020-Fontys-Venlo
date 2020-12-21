
package crossings.factories;

import crossings.TestUtils;
import crossings.crossingControllers.fourWay.FourWayCrossingControllerEntranceStandard;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static crossings.parameterEnums.LaneParameterKey.*;
import static crossings.parameterEnums.LaneType.*;
import static crossings.parameterEnums.LaneType.BOTTOM_LANE;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class FourWayCrossingControllerEntranceStandardFactoryTest {
    //hardcoded values
    final int numberOfLightsForVehicles = 3;
    final int numberOfLightsForPedestrians = 2;
    //all number of lights is for straight crossings
    //Vehicles number of lights per lane
    int straightNumberLightsLeftVehicles;
    int straightNumberLightsRightVehicles;
    int straightNumberLightsTopVehicles;
    int straightNumberLightsBottomVehicles;
    //Pedestrians number of lights per lane
    int straightNumberLightsLeftPedestrians;
    int straightNumberLightsRightPedestrians;
    int straightNumberLightsTopPedestrians;
    int straightNumberLightsBottomPedestrians;
    //Vehicles traffic light behaviour
    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;
    //Pedestrian traffic light behaviour
    @Mock
    PedestrianLightBehaviour pedestrianLightBehaviour;
    //GoDuration Vehicles HARDCODED VALUES
    final int goDurationVehiclesLight = 5;
    final int goDurationPedestriansLight = 5;
    //CycleTimeVehicles HARDCODED VALUES
    final int cycleTimeVehiclesLight = 2;
    final int cycleTimePedestrianLight = 2;
    //Location
    @Mock
    Location location;
    final int secondsBetweenLaneSwitch = 2;
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
    //Parameter Map
    Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterMap = new HashMap<>();


    @BeforeEach
    @Test
    public void setUp() {
        //Initialize Behaviour and location
        this.straightTrafficLightBehaviour = Mockito.mock(StraightTrafficLightBehaviour.class);
        this.pedestrianLightBehaviour = Mockito.mock(PedestrianLightBehaviour.class);
        this.location = Mockito.mock(Location.class);


        //Initialize number of lights for Vehicles
        this.straightNumberLightsLeftVehicles = this.numberOfLightsForVehicles;
        this.straightNumberLightsRightVehicles = this.numberOfLightsForVehicles;
        this.straightNumberLightsTopVehicles = this.numberOfLightsForVehicles;
        this.straightNumberLightsBottomVehicles = this.numberOfLightsForVehicles;
        //Initialize number of lights for Pedestrians
        this.straightNumberLightsLeftPedestrians = this.numberOfLightsForPedestrians;
        this.straightNumberLightsRightPedestrians = this.numberOfLightsForPedestrians;
        this.straightNumberLightsTopPedestrians = this.numberOfLightsForPedestrians;
        this.straightNumberLightsBottomPedestrians = this.numberOfLightsForPedestrians;
        //left LaneArgumentsMap
        Map<LaneParameterKey, Object> leftLaneVehiclesArgumentsMap = new HashMap<>();
        leftLaneVehiclesArgumentsMap.put(NUMBER_LIGHTS, this.straightNumberLightsLeftVehicles);
        leftLaneVehiclesArgumentsMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        leftLaneVehiclesArgumentsMap.put(LOCATION, this.location);
        leftLaneVehiclesArgumentsMap.put(GO_DURATION, this.goDurationVehiclesLight);
        leftLaneVehiclesArgumentsMap.put(CYCLE_TIME, this.cycleTimeVehiclesLight);
        //leftLaneArgumentsMap added to leftStraightVehiclesMap
        this.leftStraightVehiclesMap.put(STRAIGHT, leftLaneVehiclesArgumentsMap);
        //Right LaneArgumentsMAp
        Map<LaneParameterKey, Object> rightLaneVehiclesArgumentsMap = new HashMap<>();
        rightLaneVehiclesArgumentsMap.put(NUMBER_LIGHTS, this.straightNumberLightsRightVehicles);
        rightLaneVehiclesArgumentsMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        rightLaneVehiclesArgumentsMap.put(LOCATION, this.location);
        rightLaneVehiclesArgumentsMap.put(GO_DURATION, this.goDurationVehiclesLight);
        rightLaneVehiclesArgumentsMap.put(CYCLE_TIME, this.cycleTimeVehiclesLight);
        //RightLaneArgumentsMap added to rightStraightVehiclesMap
        this.rightStraightVehiclesMap.put(STRAIGHT, rightLaneVehiclesArgumentsMap);
        //TopLaneArgumentsMap
        Map<LaneParameterKey, Object> topLaneVehiclesArgumentsMap = new HashMap<>();
        topLaneVehiclesArgumentsMap.put(NUMBER_LIGHTS, this.straightNumberLightsTopVehicles);
        topLaneVehiclesArgumentsMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        topLaneVehiclesArgumentsMap.put(LOCATION, this.location);
        topLaneVehiclesArgumentsMap.put(GO_DURATION, this.goDurationVehiclesLight);
        topLaneVehiclesArgumentsMap.put(CYCLE_TIME, this.cycleTimeVehiclesLight);
        //TopLaneArgumentsMap added to topStraightVehiclesMap
        this.topStraightVehiclesMap.put(STRAIGHT, topLaneVehiclesArgumentsMap);
        //BottomLaneArgumentsMap
        Map<LaneParameterKey, Object> bottomLaneVehiclesArgumentsMap = new HashMap<>();
        bottomLaneVehiclesArgumentsMap.put(NUMBER_LIGHTS, this.straightNumberLightsTopVehicles);
        bottomLaneVehiclesArgumentsMap.put(LIGHT_BEHAVIOUR, this.straightTrafficLightBehaviour);
        bottomLaneVehiclesArgumentsMap.put(LOCATION, this.location);
        bottomLaneVehiclesArgumentsMap.put(GO_DURATION, this.goDurationVehiclesLight);
        bottomLaneVehiclesArgumentsMap.put(CYCLE_TIME, this.cycleTimeVehiclesLight);
        //BottomLaneArgumentsMap added to bottomStraightVehiclesMap
        this.bottomStraightVehiclesMap.put(STRAIGHT, bottomLaneVehiclesArgumentsMap);
        //leftStraightPedestriansArgumentsMap
        Map<LaneParameterKey, Object> leftStraightPedestriansArgumentsMap = new HashMap<>();
        leftStraightPedestriansArgumentsMap.put(NUMBER_LIGHTS, this.straightNumberLightsLeftPedestrians);
        leftStraightPedestriansArgumentsMap.put(LIGHT_BEHAVIOUR, this.pedestrianLightBehaviour);
        leftStraightPedestriansArgumentsMap.put(LOCATION, this.location);
        leftStraightPedestriansArgumentsMap.put(GO_DURATION, this.goDurationPedestriansLight);
        leftStraightPedestriansArgumentsMap.put(CYCLE_TIME, this.cycleTimePedestrianLight);
        //leftStraightPedestriansArgumentsMap added to leftStraightPedestrianMap
        this.leftStraightPedestriansMap.put(PEDESTRIAN, leftLaneVehiclesArgumentsMap);
        //RightStraightPedestriansArgumentsMap
        Map<LaneParameterKey, Object> rightStraightPedestriansArgumentsMap = new HashMap<>();
        rightStraightPedestriansArgumentsMap.put(NUMBER_LIGHTS, this.straightNumberLightsRightPedestrians);
        rightStraightPedestriansArgumentsMap.put(LIGHT_BEHAVIOUR, this.pedestrianLightBehaviour);
        rightStraightPedestriansArgumentsMap.put(LOCATION, this.location);
        rightStraightPedestriansArgumentsMap.put(GO_DURATION, this.goDurationPedestriansLight);
        rightStraightPedestriansArgumentsMap.put(CYCLE_TIME, this.cycleTimePedestrianLight);
        //RightStraightPedestriansArgumentsMap added to rightStraightPedestriansMap
        this.rightStraightPedestriansMap.put(PEDESTRIAN, rightStraightPedestriansArgumentsMap);
        //TopStraightPedestriansArgumentMap
        Map<LaneParameterKey, Object> topStraightPedestriansArgumentsMap = new HashMap<>();
        topStraightPedestriansArgumentsMap.put(NUMBER_LIGHTS, this.straightNumberLightsTopPedestrians);
        topStraightPedestriansArgumentsMap.put(LIGHT_BEHAVIOUR, this.pedestrianLightBehaviour);
        topStraightPedestriansArgumentsMap.put(LOCATION, this.location);
        topStraightPedestriansArgumentsMap.put(GO_DURATION, this.goDurationPedestriansLight);
        topStraightPedestriansArgumentsMap.put(CYCLE_TIME, this.cycleTimePedestrianLight);
        //TopStraightPedestriansArgumentsMap added to topStraightPedestriansMap
        this.topStraightPedestriansMap.put(PEDESTRIAN, topStraightPedestriansArgumentsMap);

        //BottomStraightPedestriansArgumentMap
        Map<LaneParameterKey, Object> bottomStraightPedestriansArgumentsMap = new HashMap<>();
        bottomStraightPedestriansArgumentsMap.put(NUMBER_LIGHTS, this.straightNumberLightsBottomPedestrians);
        bottomStraightPedestriansArgumentsMap.put(LIGHT_BEHAVIOUR, this.pedestrianLightBehaviour);
        bottomStraightPedestriansArgumentsMap.put(LOCATION, this.location);
        bottomStraightPedestriansArgumentsMap.put(GO_DURATION, this.goDurationPedestriansLight);
        bottomStraightPedestriansArgumentsMap.put(CYCLE_TIME, this.cycleTimePedestrianLight);
        //BottomStraightPedestriansArgumentsMap added to bottomStraightPedestriansMap
        this.bottomStraightPedestriansMap.put(PEDESTRIAN, bottomStraightPedestriansArgumentsMap);

        //Parameter Map Initialize
        //add laneVehiclesMaps to ParameterMap
        this.parameterMap.put(LEFT_LANE, this.leftStraightVehiclesMap);
        this.parameterMap.put(RIGHT_LANE, this.rightStraightVehiclesMap);
        this.parameterMap.put(TOP_LANE, this.topStraightVehiclesMap);
        this.parameterMap.put(BOTTOM_LANE, this.bottomStraightVehiclesMap);
        //add laneVehiclesMaps to ParameterMap
        this.parameterMap.put(LEFT_LANE, this.leftStraightPedestriansMap);
        this.parameterMap.put(RIGHT_LANE, this.rightStraightPedestriansMap);
        this.parameterMap.put(TOP_LANE, this.topStraightPedestriansMap);
        this.parameterMap.put(BOTTOM_LANE, this.bottomStraightPedestriansMap);

    }

    @Test
    public void getFourWayCrossingControllerEntranceStandard() {
        FourWayCrossingControllerEntranceStandardFactory factory = new FourWayCrossingControllerEntranceStandardFactory();

        FourWayCrossingControllerEntranceStandard factoryObject = factory.getFourWayCrossingControllerEntranceStandard(
                //Vehicles number of lights per lane
                straightNumberLightsLeftVehicles,
                straightNumberLightsRightVehicles,
                straightNumberLightsTopVehicles,
                straightNumberLightsBottomVehicles,
                //Pedestrians number of lights per lane
                straightNumberLightsLeftPedestrians,
                straightNumberLightsRightPedestrians,
                straightNumberLightsTopPedestrians,
                straightNumberLightsBottomPedestrians,
                //Vehicles traffic light behaviour
                straightTrafficLightBehaviour,
                //Pedestrian traffic light behaviour
                pedestrianLightBehaviour,
                //GoDuration Vehicles
                goDurationVehiclesLight,
                goDurationPedestriansLight,
                //CycleTimeVehicles
                cycleTimeVehiclesLight,
                cycleTimePedestrianLight,
                //Location
                location,
                secondsBetweenLaneSwitch
        );

        //expected result = create object with 'new'.
        FourWayCrossingControllerEntranceStandard expectedResult = new FourWayCrossingControllerEntranceStandard(this.parameterMap, this.secondsBetweenLaneSwitch);


        //Actual result = create object from factoryObject.
        FourWayCrossingControllerEntranceStandard actualResult = factoryObject;
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}
