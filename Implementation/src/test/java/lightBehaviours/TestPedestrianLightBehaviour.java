package lightBehaviours;

import lights.Light;
import lights.PedestrianLight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestPedestrianLightBehaviour {
    @Test
    public void testChangeColorCorrectCallNoException() {
        LightBehaviour lightBehaviour = PedestrianLightBehaviourStandard.RED;
        PedestrianLight pedestrianLight = mock(PedestrianLight.class);

        Assertions.assertDoesNotThrow(() -> lightBehaviour.changeColor(pedestrianLight));
    }

    @Test
    public void testChangeColorIncorrectCallException() {
        LightBehaviour lightBehaviour = PedestrianLightBehaviourStandard.RED;
        Light light = mock(Light.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lightBehaviour.changeColor(light));
    }
}
