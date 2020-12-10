package crossing;

import crossings.*;
import lane.Lane;
import lane.LaneStandard;
import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Light;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;
import static crossings.LaneControllerType.*;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TestFourWayCrossingControllerEntranceStandard {
    @Mock
    Location location;

    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    int straightGoDuration;
    int straightCycleTime;
    FourWayCrossingControllerEntrance crossing;
    Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterCollection;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        straightGoDuration = 25;
        straightCycleTime = 2;

        var leftLaneStraightParams = new HashMap();
        leftLaneStraightParams.put(NUMBER_LIGHTS, 2);
        leftLaneStraightParams.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneStraightParams.put(LOCATION, location);
        leftLaneStraightParams.put(GO_DURATION, straightGoDuration);
        leftLaneStraightParams.put(CYCLE_TIME, straightCycleTime);

        var leftLane = new HashMap();

        leftLane.put(STRAIGHT, leftLaneStraightParams);
        parameterCollection.put(LEFT_LANE, leftLane);

        crossing = new FourWayCrossingControllerEntranceStandard(
                parameterCollection
        );
    }

    @Test
    public void changeLeftLaneCorrect() {
        Lane expected = new LaneStandard(
                parameterCollection.get(LEFT_LANE)
        );

        assertThat(crossing.getLeftLane()).isEqualTo(expected);
    }

}
