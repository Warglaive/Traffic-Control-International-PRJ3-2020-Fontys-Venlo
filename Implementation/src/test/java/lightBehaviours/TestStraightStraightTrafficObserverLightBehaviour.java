package lightBehaviours;

import lights.ObserverLight;
import lights.StraightTrafficObserverLight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestStraightStraightTrafficObserverLightBehaviour {

    @Test
    public void testChangeColorCorrectCallNoException() {
        LightBehaviour lightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        StraightTrafficObserverLight straightTrafficLight = mock(StraightTrafficObserverLight.class);

        Assertions.assertDoesNotThrow(() -> lightBehaviour.changeColor(straightTrafficLight));
    }

    @Test
    public void testChangeColorIncorrectCallException() {
        LightBehaviour lightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        ObserverLight observerLight = mock(ObserverLight.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lightBehaviour.changeColor(observerLight));
    }
}
