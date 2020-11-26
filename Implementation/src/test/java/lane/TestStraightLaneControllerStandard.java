package lane;

import lightBehaviours.PedestrianLightBehaviourStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import lights.StraightTrafficLight;
import locations.Location;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;
import ui.UIOutput;
import ui.Ui;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class TestStraightLaneControllerStandard {
    @Mock
    Location location;
    @Mock
    UIObserver userInterface;

    StraightLaneController straightLaneController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0"
    })
    public void testAddLightsThrowsExceptionNumberLights(int numberLights) {
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                straightLaneController = new StraightLaneControllerStandard(
                        numberLights,
                        StraightTrafficLightBehaviourGermany.RED,
                        userInterface,
                        location
                );
        assertThatCode(exceptionCode)
                .hasMessage("The number of lights has to be greater than 0")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testAddLightsNoException() {
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                straightLaneController = new StraightLaneControllerStandard(
                        1,
                        StraightTrafficLightBehaviourGermany.RED,
                        userInterface,
                        location
                );
        assertThatCode(exceptionCode)
                .doesNotThrowAnyException();
    }

    @Test
    public void testAddLightsThrowsExceptionBehaviour() {
        straightLaneController = new StraightLaneControllerStandard(
                2,
                StraightTrafficLightBehaviourGermany.RED,
                userInterface,
                location
        );

        ThrowableAssert.ThrowingCallable exceptionCode = () -> {
            straightLaneController.addLights(2,
                    PedestrianLightBehaviourStandard.RED,
                    userInterface,
                    location);
        };

        assertThatCode(exceptionCode)
                .hasMessage("The light behaviour has to be of type StraightTrafficLightBehaviour")
                .isExactlyInstanceOf(ClassCastException.class);
    }

    @Test
    public void testAddLightsThrowsExceptionUi() {
        UIOutput falseUserInterface = mock(UIOutput.class);

        straightLaneController = new StraightLaneControllerStandard(
                2,
                StraightTrafficLightBehaviourGermany.RED,
                userInterface,
                location
        );

        ThrowableAssert.ThrowingCallable exceptionCode = () -> {
            straightLaneController.addLights(
                    2,
                    StraightTrafficLightBehaviourGermany.RED,
                    falseUserInterface,
                    location
            );
        };
        assertThatCode(exceptionCode)
                .isExactlyInstanceOf(ClassCastException.class)
                .hasMessage("The userInterface has to be of type UIObserver");
    }
}
