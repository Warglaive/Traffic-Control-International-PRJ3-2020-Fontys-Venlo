package lane;

import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import lane.laneControllers.StraightLaneControllerStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.STRAIGHT;
import static crossings.LaneParameterKey.*;
import static org.mockito.Mockito.mock;

public class TestLaneStandard {
    @Mock
    Location location;
    @Mock
    UIObserver uiObserver;
    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    int straightGoDuration;
    int straightCycleTime;
    LaneStandard laneStandard;
    Map<LaneControllerType, Map<LaneParameterKey, Object>> leftLaneParams;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        location = mock(Location.class);
        straightTrafficLightBehaviour = StraightTrafficLightBehaviourGermany.RED;

        var leftLaneStraightParams = new HashMap();
        leftLaneStraightParams.put(NUMBER_LIGHTS, 2);
        leftLaneStraightParams.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneStraightParams.put(LOCATION, location);
        leftLaneStraightParams.put(GO_DURATION, 25);
        leftLaneStraightParams.put(CYCLE_TIME, 2);

        leftLaneParams = new HashMap();
        leftLaneParams.put(STRAIGHT, leftLaneStraightParams);

        straightGoDuration = 25;
        straightCycleTime = 2;

        laneStandard = new LaneStandard(
                leftLaneParams
        );
    }

    @Test
    public void changeStraightLaneController() {
        StraightLaneControllerStandard straightLaneControllerStandard = laneStandard.getStraightLaneController();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(straightLaneControllerStandard.getLights().size()).isEqualTo(2);
        });
    }
}
