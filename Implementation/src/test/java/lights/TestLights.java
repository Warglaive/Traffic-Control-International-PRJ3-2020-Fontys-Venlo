package lights;

import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestLights {
    @Mock
    UIObserver mockedUi;
    Location mockedLocation;

    ObserverLight observerLight;
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.observerLight = mock(ObserverLight.class, Mockito.CALLS_REAL_METHODS);
        straightTrafficLightBehaviour = StraightTrafficLightBehaviourGermany.RED;
    }

    @Test
    public void setChangeBehaviour() {
        StraightTrafficLightBehaviour expected = mock(StraightTrafficLightBehaviour.class);
        observerLight.setChangeBehaviour(expected);

        assertEquals(expected, observerLight.getChangeBehaviour());
    }
}
