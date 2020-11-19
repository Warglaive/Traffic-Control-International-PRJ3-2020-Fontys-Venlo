package lights;

import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import scrapped.StraightTrafficLightGermany;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestLights {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    Light light;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.light = mock(Light.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void changeColorChangesColor() {
        StraightTrafficLight straightTrafficLight = new StraightTrafficLightGermany(mockedUi, mockedLocation);

        straightTrafficLight.changeColor();
        assertEquals(StraightTrafficLightBehaviourGermany.REDYELLOW,
                straightTrafficLight.getChangeBehaviour());
    }

    /*@ParameterizedTest
    @CsvSource({
            //color to receive
            "RED, red and yellow",
            "REDYELLOW, green",
            "GREEN, yellow",
            "YELLOW, red"
    })
    public void changeColorNotifiesObservers(TrafficLightBehaviourGermany behaviour, String color) {*/
    @Test
    public void changeColorNotifiesObservers() {
        StraightTrafficLight straightTrafficLight = new StraightTrafficLightGermany(mockedUi, mockedLocation);
        //trafficLight.setChangeBehaviour(behaviour);
        straightTrafficLight.changeColor();
        String color = straightTrafficLight.getChangeBehaviour().getColor();
        verify(mockedUi).update(straightTrafficLight, color);
    }

    @Test
    public void changeColorWithoutObserversDoesNotNotify() {
        StraightTrafficLight straightTrafficLight = new StraightTrafficLightGermany(mockedUi, mockedLocation);
        straightTrafficLight.deleteObserver(mockedUi);
        straightTrafficLight.changeColor();
        verify(mockedUi, times(0)).update(any(), any());
    }


    @Test
    public void setChangeBehaviour() {
        StraightTrafficLightBehaviour expected = mock(StraightTrafficLightBehaviour.class);
        light.setChangeBehaviour(expected);

        assertEquals(expected, light.getChangeBehaviour());
    }
}
