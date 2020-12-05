package lane;

import lane.laneControllers.StraightLaneControllerStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;

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
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        straightGoDuration = 25;
        straightCycleTime = 2;

        laneStandard = new LaneStandard(
                2,
                straightTrafficLightBehaviour,
                location,
                straightGoDuration,
                straightCycleTime
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
