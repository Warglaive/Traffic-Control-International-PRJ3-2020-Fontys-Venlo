package lightBehaviours;

import lights.observerLights.PedestrianObserverLight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestPedestrianLightBehaviourStandard {
    PedestrianObserverLight mockedPedestrianLight;

    @BeforeEach
    public void init() {
        mockedPedestrianLight = mock(PedestrianObserverLight.class, Mockito.CALLS_REAL_METHODS);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, GREEN",
            "GREEN, RED"
    })
    public void testStateMachineChange(PedestrianLightBehaviourStandard startBehaviour,
                                       PedestrianLightBehaviourStandard expectedBehaviour) {

        startBehaviour.changeColor(mockedPedestrianLight);
        verify(mockedPedestrianLight).setChangeBehaviour(expectedBehaviour);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, green",
            "GREEN, red"
    })
    public void testStateMachineChangeReturnsColor(PedestrianLightBehaviourStandard startBehaviour,
                                                   String expected) {
        String actual = startBehaviour.changeColor(mockedPedestrianLight);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            //behaviour, expectedColor
            "RED, red",
            "GREEN, green"
    })
    public void testGetColor(PedestrianLightBehaviourStandard behaviour, String expected) {
        String color = behaviour.getColor();
        assertEquals(expected, color);
    }

    @Test
    public void testGoStateCorrect() {
        assertThat(PedestrianLightBehaviourStandard.RED.getGoState())
                .isEqualTo(PedestrianLightBehaviourStandard.GREEN);
    }
    @Test
    public void testStopStateCorrect() {
        assertThat(PedestrianLightBehaviourStandard.RED.getStopState())
                .isEqualTo(PedestrianLightBehaviourStandard.RED);
    }

    @ParameterizedTest
    @CsvSource({
            //startBehaviour, expectedBehaviour
            "RED, GREEN",
            "GREEN, RED"
    })
    public void testNextStateCorrect(PedestrianLightBehaviourStandard startBehaviour,
                                     PedestrianLightBehaviourStandard expected) {
        assertThat(startBehaviour.getNextState()).isEqualTo(expected);
    }
}
