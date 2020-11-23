package scrapped;

import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.PedestrianLightBehaviourExtended;
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

public class TestPedestrianLightExtended {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    Light pedestrianLightExtended;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.pedestrianLightExtended = new PedestrianLightExtended(mockedUi, mockedLocation);
    }

    @Test
    public void correctConstructorValues() {
        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(pedestrianLightExtended.getChangeBehaviour())
                            .isEqualTo(PedestrianLightBehaviourExtended.RED);
                    softly.assertThat(pedestrianLightExtended.getLocation())
                            .isEqualTo(mockedLocation);
                    softly.assertThat(pedestrianLightExtended.countObservers()).isEqualTo(1);
                }
        );
    }

    @Test
    public void setChangeBehaviourCorrectCallNoException() {
        PedestrianLightBehaviourExtended pedestrianLightBehaviourExtended = mock(PedestrianLightBehaviourExtended.class);

        Assertions.assertDoesNotThrow(() -> pedestrianLightExtended.setChangeBehaviour(pedestrianLightBehaviourExtended));
    }

    @Test
    public void setChangeBehaviourIncorrectCallException() {
        PedestrianLightBehaviour pedestrianLightBehaviour = mock(PedestrianLightBehaviour.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> pedestrianLightExtended.setChangeBehaviour(pedestrianLightBehaviour));
    }

    @Test
    public void setChangeBehaviourChangesBehaviour() {
        PedestrianLightBehaviourExtended pedestrianLightBehaviour = mock(PedestrianLightBehaviourExtended.class);
        pedestrianLightExtended.setChangeBehaviour(pedestrianLightBehaviour);

        assertEquals(pedestrianLightBehaviour, pedestrianLightExtended.getChangeBehaviour());
    }
}
