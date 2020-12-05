package lane;

import lane.laneControllers.StraightLaneController;
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

    LaneStandard laneStandard;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        laneStandard = new LaneStandard(
                2,
                straightTrafficLightBehaviour,
                uiObserver,
                location
        );
    }

    @Test
    public void changeStraightLaneController() {
        StraightLaneController straightLaneController = laneStandard.getStraightLaneController();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(straightLaneController.getLights().size()).isEqualTo(2);
        });
    }
}
