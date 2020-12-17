package crossings.crossingControllers.fourWay;

import crossings.TestUtils;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFourWayCrossingControllerEntranceStandard {
    @Mock
    Location location;

    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    @Mock
    PedestrianLightBehaviour pedestrianLightBehaviour;

    int straightGoDuration;
    int straightCycleTime;
    FourWayCrossingControllerEntrance crossingController;
    Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterCollection;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        straightGoDuration = 25;
        straightCycleTime = 2;

        /*parameterCollection = new HashMap();

        var leftLaneStraightParams = new HashMap();
        leftLaneStraightParams.put(NUMBER_LIGHTS, 2);
        leftLaneStraightParams.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneStraightParams.put(LOCATION, location);
        leftLaneStraightParams.put(GO_DURATION, straightGoDuration);
        leftLaneStraightParams.put(CYCLE_TIME, straightCycleTime);

        var leftLane = new HashMap();

        leftLane.put(STRAIGHT, leftLaneStraightParams);
        parameterCollection.put(LEFT_LANE, leftLane);*/

        parameterCollection = TestUtils.getFourLaneParamMap(
                straightGoDuration, straightCycleTime, straightTrafficLightBehaviour, pedestrianLightBehaviour, location
        );

        crossingController = new FourWayCrossingControllerEntranceStandard(
                parameterCollection, 2
        );
    }

    @Test
    public void changeLeftLaneCorrect() {
        assertThat(crossingController.getLeftLane()).isNotNull();
    }
/*
    @Test
    public void cycleLanesCyclesLanes() {
        var dependentCrossingController = new FourWayCrossingControllerEntranceStandard(
                crossings.TestUtils.getFourLaneParamMap(straightGoDuration, straightCycleTime, StraightTrafficLightBehaviourGermany.RED, location),
                2);
        dependentCrossingController.cycleLanes();
    }
*/
}
