package crossing;

import crossings.FourWayCrossingControllerEntrance;
import crossings.FourWayCrossingControllerEntranceStandard;
import crossings.FourWayCrossingEntrance;
import crossings.FourWayCrossingEntranceStandard;
import lane.Lane;
import lane.LaneStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;
import ui.UIOutput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mock;

public class TestFourWayCrossingEntranceStandard {
    @Mock
    Location location;
    @Mock
    UIObserver uiObserver;
    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    int straightGoDuration;
    int straightCycleTime;
    FourWayCrossingEntrance crossing;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        straightGoDuration = 25;
        straightCycleTime = 2;
        crossing = new FourWayCrossingEntranceStandard(
                2,
                straightTrafficLightBehaviour,
                location,
                straightGoDuration,
                straightCycleTime
        );
    }

    @Test
    public void changeControllerCorrect() {
        FourWayCrossingControllerEntrance crossingController = new FourWayCrossingControllerEntranceStandard (
                2,
                straightTrafficLightBehaviour,
                location,
                straightGoDuration,
                straightCycleTime
        );

        assertThat(crossing.getController()).isNotNull();
    }

}
