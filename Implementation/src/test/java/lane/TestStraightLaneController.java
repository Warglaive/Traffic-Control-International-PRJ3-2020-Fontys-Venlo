package lane;

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
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class TestStraightLaneController {
    @Mock
    Location location;
    @Mock
    Ui userInterface;

    StraightLaneController straightLaneController;

    @BeforeEach
    public void setUp() {
        location = mock(Location.class);
        userInterface = mock(Ui.class);
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0"
    })
    public void testConstructorThrowsException(int numberLights) {
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                straightLaneController = new StraightLaneController(
                numberLights,
                StraightTrafficLightBehaviourGermany.RED,
                userInterface,
                location
        );
        Assertions.assertThatCode(exceptionCode)
                .hasMessage("The number of lights has to be greater than 0")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testConstructorNoException() {
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                straightLaneController = new StraightLaneController(
                        1,
                        StraightTrafficLightBehaviourGermany.RED,
                        userInterface,
                        location
                );
        Assertions.assertThatCode(exceptionCode)
                .doesNotThrowAnyException();
    }
}
