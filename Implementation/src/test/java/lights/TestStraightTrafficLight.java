package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestStraightTrafficLight {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    StraightTrafficLight straightTrafficLight;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.straightTrafficLight = mock(StraightTrafficLight.class, Mockito.CALLS_REAL_METHODS);
    }


    @Test
    public void setChangeBehaviourCorrectCallNoException() {
        StraightTrafficLightBehaviour straightTrafficLightBehaviour = mock(StraightTrafficLightBehaviour.class);

        Assertions.assertDoesNotThrow(() -> straightTrafficLight.setChangeBehaviour(straightTrafficLightBehaviour));
    }

    @Test
    public void setChangeBehaviourIncorrectCallException() {
        LightBehaviour lightBehaviour = mock(LightBehaviour.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> straightTrafficLight.setChangeBehaviour(lightBehaviour));
    }

    @Test
    public void setChangeBehaviourChangesBehaviour() {
        StraightTrafficLightBehaviour straightTrafficLightBehaviour = mock(StraightTrafficLightBehaviour.class);
        straightTrafficLight.setChangeBehaviour(straightTrafficLightBehaviour);

        assertEquals(straightTrafficLightBehaviour, straightTrafficLight.getChangeBehaviour());
    }

}
