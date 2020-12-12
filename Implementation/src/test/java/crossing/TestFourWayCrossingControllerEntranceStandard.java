package crossing;

import crossings.*;
import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFourWayCrossingControllerEntranceStandard {
    @Mock
    Location location;

    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

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
                straightGoDuration, straightCycleTime, straightTrafficLightBehaviour, location
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
                TestUtils.getFourLaneParamMap(straightGoDuration, straightCycleTime, StraightTrafficLightBehaviourGermany.RED, location),
                2);
        dependentCrossingController.cycleLanes();
    }
*/
}
