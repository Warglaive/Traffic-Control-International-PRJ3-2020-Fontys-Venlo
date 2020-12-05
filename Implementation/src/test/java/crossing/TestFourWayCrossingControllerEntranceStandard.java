package crossing;

import crossings.FourWayCrossingControllerEntrance;
import crossings.FourWayCrossingControllerEntranceStandard;
import lane.Lane;
import lane.LaneStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.UIOutput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mock;

public class TestFourWayCrossingControllerEntranceStandard {
    @Mock
    Location location;

    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    int straightGoDuration;
    int straightCycleTime;
    FourWayCrossingControllerEntrance crossing;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        straightGoDuration = 25;
        straightCycleTime = 2;
        crossing = new FourWayCrossingControllerEntranceStandard(
                2,
                straightTrafficLightBehaviour,
                location,
                straightGoDuration,
                straightCycleTime
        );
    }

    @Test
    public void changeLeftLaneCorrect() {
        Lane expected = new LaneStandard(
                2,
                straightTrafficLightBehaviour,
                location,
                straightGoDuration,
                straightCycleTime
        );

        assertThat(crossing.getLeftLane()).isNotNull();
    }

}
