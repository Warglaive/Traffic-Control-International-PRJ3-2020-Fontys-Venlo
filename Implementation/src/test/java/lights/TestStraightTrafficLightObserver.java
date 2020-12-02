package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
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

public class TestStraightTrafficLightObserver {
    @Mock
    Ui mockedUi;
    Location mockedLocation;
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    StraightTrafficLight straightTrafficLight;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        straightTrafficLightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        this.straightTrafficLight = mock(StraightTrafficLightObserver.class, Mockito.CALLS_REAL_METHODS);
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
        StraightTrafficLight straightTrafficLight = new StraightTrafficLightObserverStandard(straightTrafficLightBehaviour, mockedLocation);

        straightTrafficLight.changeColor();
        assertEquals(StraightTrafficLightBehaviourGermany.REDYELLOW,
                straightTrafficLight.getChangeBehaviour());
    }

    @Test
    public void changeColorNotifiesObservers() {
        StraightTrafficLight straightTrafficLight = new StraightTrafficLightObserverStandard(straightTrafficLightBehaviour, mockedLocation);
        //trafficLight.setChangeBehaviour(behaviour);
        straightTrafficLight.addObserver(mockedUi);
        straightTrafficLight.changeColor();
        String color = straightTrafficLight.getChangeBehaviour().getColor();
        verify(mockedUi).update(straightTrafficLight, color);
    }

    @Test
    public void changeColorWithoutObserversDoesNotNotify() {
        StraightTrafficLight straightTrafficLight = new StraightTrafficLightObserverStandard(straightTrafficLightBehaviour, mockedLocation);
        straightTrafficLight.deleteObserver(mockedUi);
        straightTrafficLight.changeColor();
        verify(mockedUi, times(0)).update(any(), any());
    }
}
