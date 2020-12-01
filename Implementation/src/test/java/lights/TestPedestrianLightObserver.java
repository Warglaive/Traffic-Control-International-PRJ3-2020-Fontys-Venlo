package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.PedestrianLightBehaviourStandard;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestPedestrianLightObserver {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    PedestrianLightObserver pedestrianLight;
    PedestrianLightBehaviour pedestrianLightBehaviour;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        pedestrianLightBehaviour = PedestrianLightBehaviourStandard.RED;
        this.pedestrianLight = mock(PedestrianLightObserver.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void setChangeBehaviourCorrectCallNoException() {
        PedestrianLightBehaviour pedestrianLightBehaviour = mock(PedestrianLightBehaviour.class);

        Assertions.assertDoesNotThrow(() -> pedestrianLight.setChangeBehaviour(pedestrianLightBehaviour));
    }

    @Test
    public void setChangeBehaviourIncorrectCallException() {
        LightBehaviour lightBehaviour = mock(LightBehaviour.class);

        Assertions.assertThrows(ClassCastException.class,
                () -> pedestrianLight.setChangeBehaviour(lightBehaviour));
    }

    @Test
    public void setChangeBehaviourChangesBehaviour() {
        PedestrianLightBehaviour pedestrianLightBehaviour = mock(PedestrianLightBehaviour.class);
        pedestrianLight.setChangeBehaviour(pedestrianLightBehaviour);

        assertEquals(pedestrianLightBehaviour, pedestrianLight.getChangeBehaviour());
    }

    @Test
    public void changeColorChangesColor() {
        PedestrianLight PedestrianLight = new PedestrianLightObserverStandard(pedestrianLightBehaviour, mockedLocation);

        PedestrianLight.changeColor();
        assertEquals(PedestrianLightBehaviourStandard.GREEN,
                PedestrianLight.getChangeBehaviour());
    }

    @Test
    public void changeColorNotifiesObservers() {
        PedestrianLight PedestrianLight = new PedestrianLightObserverStandard(pedestrianLightBehaviour, mockedLocation);
        //trafficLight.setChangeBehaviour(behaviour);
        PedestrianLight.addObserver(mockedUi);
        PedestrianLight.changeColor();
        String color = PedestrianLight.getChangeBehaviour().getColor();
        verify(mockedUi).update(PedestrianLight, color);
    }

    @Test
    public void changeColorWithoutObserversDoesNotNotify() {
        PedestrianLight PedestrianLight = new PedestrianLightObserverStandard(pedestrianLightBehaviour, mockedLocation);
        PedestrianLight.deleteObserver(mockedUi);
        PedestrianLight.changeColor();
        verify(mockedUi, times(0)).update(any(), any());
    }
}
