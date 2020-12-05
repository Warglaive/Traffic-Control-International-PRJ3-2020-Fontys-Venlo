package lane.laneControllers;

import lightBehaviours.PedestrianLightBehaviourStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class TestStraightLaneControllerStandard {
    @Mock
    Location location;

    StraightLaneControllerStandard straightLaneControllerStandard;
    StraightTrafficLightBehaviour lightBehaviour;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        lightBehaviour = StraightTrafficLightBehaviourGermany.RED;

        straightLaneControllerStandard = new StraightLaneControllerStandard(
                2,
                lightBehaviour,
                location,
                25,
                2
        );
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0"
    })
    public void testAddLightsThrowsExceptionNumberLights(int numberLights) {
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                straightLaneControllerStandard = new StraightLaneControllerStandard(
                        numberLights,
                        StraightTrafficLightBehaviourGermany.RED,
                        location,
                        25,
                        2
                );
        assertThatCode(exceptionCode)
                .hasMessage("The number of lights has to be greater than 0")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testAddLightsNoException() {
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                straightLaneControllerStandard = new StraightLaneControllerStandard(
                        1,
                        StraightTrafficLightBehaviourGermany.RED,
                        location,
                        25,
                        2
                );
        assertThatCode(exceptionCode)
                .doesNotThrowAnyException();
    }

    @Test
    public void testAddLightsThrowsExceptionBehaviour() {
        ThrowableAssert.ThrowingCallable exceptionCode = () -> {
            straightLaneControllerStandard.addLights(2,
                    PedestrianLightBehaviourStandard.RED,
                    //userInterface,
                    location);
        };

        assertThatCode(exceptionCode)
                .hasMessage("The light behaviour has to be of type StraightTrafficLightBehaviour")
                .isExactlyInstanceOf(ClassCastException.class);
    }



    /*@Test
    public void testAddLightsThrowsExceptionUi() {
        UIOutput falseUserInterface = mock(UIOutput.class);

        straightLaneController = new StraightLaneControllerStandard(
                2,
                StraightTrafficLightBehaviourGermany.RED,
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
    }*/
}
