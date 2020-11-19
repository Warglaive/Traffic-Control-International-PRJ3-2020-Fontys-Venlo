package scrapped;

import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import lights.Light;
import lights.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import scrapped.StraightTrafficLightGermany;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestStraightTrafficLightGermany {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    Light trafficLightGermany;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.trafficLightGermany = new StraightTrafficLightGermany(mockedUi, mockedLocation);
    }

    @Test
    public void correctConstructorValues() {
        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(trafficLightGermany.getChangeBehaviour())
                            .isEqualTo(StraightTrafficLightBehaviourGermany.RED);
                    softly.assertThat(trafficLightGermany.getLocation())
                            .isEqualTo(mockedLocation);
                    softly.assertThat(trafficLightGermany.countObservers()).isEqualTo(1);
                }
        );
    }

    @Test
    public void setChangeBehaviourCorrectCallNoException() {
        StraightTrafficLightBehaviourGermany trafficLightBehaviour = mock(StraightTrafficLightBehaviourGermany.class);

        Assertions.assertDoesNotThrow(() -> trafficLightGermany.setChangeBehaviour(trafficLightBehaviour));
    }

    @Test
    public void setChangeBehaviourIncorrectCallException() {
        StraightTrafficLightBehaviour straightTrafficLightBehaviour = mock(StraightTrafficLightBehaviour.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> trafficLightGermany.setChangeBehaviour(straightTrafficLightBehaviour));
    }

    @Test
    public void setChangeBehaviourChangesBehaviour() {
        StraightTrafficLightBehaviourGermany trafficLightBehaviour = mock(StraightTrafficLightBehaviourGermany.class);
        trafficLightGermany.setChangeBehaviour(trafficLightBehaviour);

        assertEquals(trafficLightBehaviour, trafficLightGermany.getChangeBehaviour());
    }

}
