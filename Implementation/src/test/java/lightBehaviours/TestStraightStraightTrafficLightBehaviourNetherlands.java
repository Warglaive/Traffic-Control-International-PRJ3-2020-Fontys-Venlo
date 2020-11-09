package lightBehaviours;

import lights.StraightTrafficLight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestStraightStraightTrafficLightBehaviourNetherlands {
    StraightTrafficLight mockedStraightTrafficLight;

    @BeforeEach
    public void init() {
        mockedStraightTrafficLight = mock(StraightTrafficLight.class, Mockito.CALLS_REAL_METHODS);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, GREEN",
            "GREEN, YELLOW",
            "YELLOW, RED"
    })
    public void testStateMachineChange(StraightTrafficLightBehaviourNetherlands startBehaviour,
                                       StraightTrafficLightBehaviourNetherlands expectedBehaviour) {
        startBehaviour.changeColor(mockedStraightTrafficLight);
        verify(mockedStraightTrafficLight).setChangeBehaviour(expectedBehaviour);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, green",
            "GREEN, yellow",
            "YELLOW, red"
    })
    public void testStateMachineChangeReturnsColor(StraightTrafficLightBehaviourNetherlands startBehaviour,
                                                   String expected) {
        String actual = startBehaviour.changeColor(mockedStraightTrafficLight);
        assertEquals(expected, actual);
    }
}
