package lightBehaviours;

import lights.Light;
import lights.StraightTrafficLight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestStraightStraightTrafficLightBehaviour {

    @Test
    public void testChangeColorCorrectCallNoException() {
        LightBehaviour lightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        StraightTrafficLight straightTrafficLight = mock(StraightTrafficLight.class);

        Assertions.assertDoesNotThrow(() -> lightBehaviour.changeColor(straightTrafficLight));
    }

    @Test
    public void testChangeColorIncorrectCallException() {
        LightBehaviour lightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        Light light = mock(Light.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lightBehaviour.changeColor(light));
    }
}
