package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TestPedestrianLight {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    PedestrianLight pedestrianLight;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.pedestrianLight = mock(PedestrianLight.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void setChangeBehaviourCorrectCallNoException() {
        PedestrianLightBehaviour pedestrianLightBehaviour = mock(PedestrianLightBehaviour.class);

        Assertions.assertDoesNotThrow(() -> pedestrianLight.setChangeBehaviour(pedestrianLightBehaviour));
    }

    @Test
    public void setChangeBehaviourIncorrectCallException() {
        LightBehaviour lightBehaviour = mock(LightBehaviour.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> pedestrianLight.setChangeBehaviour(lightBehaviour));
    }

    @Test
    public void setChangeBehaviourChangesBehaviour() {
        PedestrianLightBehaviour pedestrianLightBehaviour = mock(PedestrianLightBehaviour.class);
        pedestrianLight.setChangeBehaviour(pedestrianLightBehaviour);

        assertEquals(pedestrianLightBehaviour, pedestrianLight.getChangeBehaviour());
    }
}
