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
import ui.UIObserver;
import ui.UIOutput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mock;

public class TestFourWayCrossingControllerEntranceStandard {
    @Mock
    Location location;
    @Mock
    UIObserver uiObserver;
    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    FourWayCrossingControllerEntrance crossing;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        crossing = new FourWayCrossingControllerEntranceStandard(
                2,
                straightTrafficLightBehaviour,
                uiObserver,
                location
        );
    }

    @Test
    public void changeLeftLaneCorrect() {
        Lane expected = new LaneStandard(
                2,
                straightTrafficLightBehaviour,
                uiObserver,
                location
        );

        assertThat(crossing.getLeftLane()).isNotNull();
    }

    @Test
    public void changeLeftLaneFalseUi() {
        ThrowableAssert.ThrowingCallable exceptionCode = () -> {
            crossing.changeLeftLane(
                    2,
                    straightTrafficLightBehaviour,
                    mock(UIOutput.class),
                    location
            );
        };

        assertThatCode(exceptionCode)
                .isExactlyInstanceOf(ClassCastException.class)
                .hasMessage("The userInterface has to be of type UIObserver");
    }
}
