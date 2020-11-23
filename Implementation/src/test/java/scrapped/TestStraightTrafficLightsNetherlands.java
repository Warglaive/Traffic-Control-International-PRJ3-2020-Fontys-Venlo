package scrapped;

import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourNetherlands;
import lights.Light;
import locations.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TestStraightTrafficLightsNetherlands {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    Light trafficLightNetherlands;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.trafficLightNetherlands = new StraightTrafficLightNetherlands(mockedUi, mockedLocation);
    }
    @Test
    public void correctConstructorValues() {
        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(trafficLightNetherlands.getChangeBehaviour())
                            .isEqualTo(StraightTrafficLightBehaviourNetherlands.RED);
                    softly.assertThat(trafficLightNetherlands.getLocation())
                            .isEqualTo(mockedLocation);
                }
        );
    }

    @Test
    public void setChangeBehaviourCorrectCallNoException() {
        StraightTrafficLightBehaviourNetherlands trafficLightBehaviour = mock(StraightTrafficLightBehaviourNetherlands.class);

        Assertions.assertDoesNotThrow(() -> trafficLightNetherlands.setChangeBehaviour(trafficLightBehaviour));
    }

    @Test
    public void setChangeBehaviourIncorrectCallException() {
        StraightTrafficLightBehaviour straightTrafficLightBehaviour = mock(StraightTrafficLightBehaviour.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> trafficLightNetherlands.setChangeBehaviour(straightTrafficLightBehaviour));
    }

    @Test
    public void setChangeBehaviourChangesBehaviour() {
        StraightTrafficLightBehaviourNetherlands trafficLightBehaviour = mock(StraightTrafficLightBehaviourNetherlands.class);
        trafficLightNetherlands.setChangeBehaviour(trafficLightBehaviour);

        assertEquals(trafficLightBehaviour, trafficLightNetherlands.getChangeBehaviour());
    }
}
