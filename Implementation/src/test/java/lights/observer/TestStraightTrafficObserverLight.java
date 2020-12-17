package lights.observer;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import lights.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestStraightTrafficObserverLight {
    @Mock
    UIObserver mockedUi;
    Location mockedLocation;
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    StraightTrafficObserverLight straightTrafficLight;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        straightTrafficLightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        this.straightTrafficLight = mock(StraightTrafficObserverLight.class, Mockito.CALLS_REAL_METHODS);
    }


    @Test
    public void setChangeBehaviourCorrectCallNoException() {
        StraightTrafficLightBehaviour straightTrafficLightBehaviour = mock(StraightTrafficLightBehaviour.class);

        Assertions.assertDoesNotThrow(() -> straightTrafficLight.setChangeBehaviour(straightTrafficLightBehaviour));
    }

    @Test
    public void setChangeBehaviourIncorrectCallException() {
        LightBehaviour lightBehaviour = mock(LightBehaviour.class);

        Assertions.assertThrows(ClassCastException.class,
                () -> straightTrafficLight.setChangeBehaviour(lightBehaviour));
    }

    @Test
    public void setChangeBehaviourChangesBehaviour() {
        StraightTrafficLightBehaviour straightTrafficLightBehaviour = mock(StraightTrafficLightBehaviour.class);
        straightTrafficLight.setChangeBehaviour(straightTrafficLightBehaviour);

        assertEquals(straightTrafficLightBehaviour, straightTrafficLight.getChangeBehaviour());
    }

    @Test
    public void changeColorChangesColor() {
        StraightTrafficObserverLight straightTrafficLight = new StraightTrafficObserverLightStandard(straightTrafficLightBehaviour, mockedLocation);

        straightTrafficLight.changeColor();
        assertEquals(StraightTrafficLightBehaviourGermany.REDYELLOW,
                straightTrafficLight.getChangeBehaviour());
    }

    @Test
    public void changeColorNotifiesObservers() {
        StraightTrafficObserverLight straightTrafficLight = new StraightTrafficObserverLightStandard(straightTrafficLightBehaviour, mockedLocation);
        //trafficLight.setChangeBehaviour(behaviour);
        straightTrafficLight.addObserver(mockedUi);
        straightTrafficLight.changeColor();
        String color = straightTrafficLight.getChangeBehaviour().getColor();
        verify(mockedUi).update(straightTrafficLight, color);
    }

    @Test
    public void changeColorWithoutObserversDoesNotNotify() {
        StraightTrafficObserverLight straightTrafficLight = new StraightTrafficObserverLightStandard(straightTrafficLightBehaviour, mockedLocation);
        straightTrafficLight.deleteObserver(mockedUi);
        straightTrafficLight.changeColor();
        verify(mockedUi, times(0)).update(any(), any());
    }
}
