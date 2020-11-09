package lightBehaviours;

import lights.PedestrianLight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestPedestrianLightBehaviourExtended {
    PedestrianLight mockedPedestrianLight;

    @BeforeEach
    public void init() {
        mockedPedestrianLight = mock(PedestrianLight.class, Mockito.CALLS_REAL_METHODS);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, GREEN",
            "GREEN, GREENBLINKING",
            "GREENBLINKING, RED"
    })
    public void testStateMachineChange(PedestrianLightBehaviourExtended startBehaviour,
                                       PedestrianLightBehaviourExtended expectedBehaviour) {

        startBehaviour.changeColor(mockedPedestrianLight);
        verify(mockedPedestrianLight).setChangeBehaviour(expectedBehaviour);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, green",
            "GREEN, greenblinking",
            "GREENBLINKING, red"
    })
    public void testStateMachineChangeReturnsColor(PedestrianLightBehaviourExtended startBehaviour,
                                                   String expected) {
        String actual = startBehaviour.changeColor(mockedPedestrianLight);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            //behaviour, expectedColor
            "RED, red",
            "GREEN, green",
            "GREENBLINKING, greenblinking"
    })
    public void testGetColor(PedestrianLightBehaviourExtended behaviour, String expected) {
        String color = behaviour.getColor();
        assertEquals(expected, color);
    }
}
