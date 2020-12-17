package lightBehaviours;

import lights.observer.ObserverLight;
import lights.observer.PedestrianObserverLight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestPedestrianLightBehaviour {
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
