package lightBehaviours;

import lights.ObserverLight;
import lights.PedestrianObserverLight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestPedestrianObserverLightBehaviour {
    @Test
    public void testChangeColorCorrectCallNoException() {
        LightBehaviour lightBehaviour = PedestrianLightBehaviourStandard.RED;
        PedestrianObserverLight pedestrianLight = mock(PedestrianObserverLight.class);

        Assertions.assertDoesNotThrow(() -> lightBehaviour.changeColor(pedestrianLight));
    }

    @Test
    public void testChangeColorIncorrectCallException() {
        LightBehaviour lightBehaviour = PedestrianLightBehaviourStandard.RED;
        ObserverLight observerLight = mock(ObserverLight.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lightBehaviour.changeColor(observerLight));
    }
}
