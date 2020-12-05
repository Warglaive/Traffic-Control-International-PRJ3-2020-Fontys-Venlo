package lightBehaviours;

import lights.StraightTrafficObserverLight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestStraightLightBehaviourGermany {
    StraightTrafficObserverLight mockedStraightTrafficLight;

    @BeforeEach
    public void init() {
        mockedStraightTrafficLight = mock(StraightTrafficObserverLight.class, Mockito.CALLS_REAL_METHODS);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, REDYELLOW",
            "REDYELLOW, GREEN",
            "GREEN, YELLOW",
            "YELLOW, RED"
    })
    public void testStateMachineChange(StraightTrafficLightBehaviourGermany startBehaviour,
                                       StraightTrafficLightBehaviourGermany expectedBehaviour) {
        startBehaviour.changeColor(mockedStraightTrafficLight);
        verify(mockedStraightTrafficLight).setChangeBehaviour(expectedBehaviour);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, redYellow",
            "REDYELLOW, green",
            "GREEN, yellow",
            "YELLOW, red"
    })
    public void testStateMachineChangeReturnsColor(StraightTrafficLightBehaviourGermany startBehaviour,
                                                   String expected) {
        String actual = startBehaviour.changeColor(mockedStraightTrafficLight);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            //behaviour, expectedColor
            "RED, red",
            "REDYELLOW, redYellow",
            "YELLOW, yellow",
            "GREEN, green"
    })
    public void testGetColor(StraightTrafficLightBehaviourGermany behaviour, String expected) {
        String color = behaviour.getColor();
        assertEquals(expected, color);
    }

    @Test
    public void testGoStateCorrect() {
        assertThat(StraightTrafficLightBehaviourGermany.RED.getGoState())
                .isEqualTo(StraightTrafficLightBehaviourGermany.GREEN);
    }

    @Test
    public void testStopStateCorrect() {
        assertThat(StraightTrafficLightBehaviourGermany.RED.getStopState())
                .isEqualTo(StraightTrafficLightBehaviourGermany.RED);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, REDYELLOW",
            "REDYELLOW, GREEN",
            "GREEN, YELLOW",
            "YELLOW, RED"
    })
    public void testNextStateCorrect(StraightTrafficLightBehaviourGermany startBehaviour,
                                     StraightTrafficLightBehaviourGermany expected) {
        assertThat(startBehaviour.getNextState()).isEqualTo(expected);
    }
}
