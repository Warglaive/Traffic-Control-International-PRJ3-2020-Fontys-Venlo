package scrapped;

import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.PedestrianLightBehaviourStandard;
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

public class TestPedestrianLightStandard {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    Light pedestrianLightStandard;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.pedestrianLightStandard = new PedestrianLightStandard(mockedUi, mockedLocation);
    }

    @Test
    public void correctConstructorValues() {
        SoftAssertions.assertSoftly(softly -> {
                    softly.assertThat(pedestrianLightStandard.getChangeBehaviour())
                            .isEqualTo(PedestrianLightBehaviourStandard.RED);
                    softly.assertThat(pedestrianLightStandard.getLocation())
                            .isEqualTo(mockedLocation);
                    softly.assertThat(pedestrianLightStandard.countObservers()).isEqualTo(1);
                }
        );
    }

    @Test
    public void setChangeBehaviourCorrectCallNoException() {
        PedestrianLightBehaviourStandard pedestrianLightBehaviourStandard = mock(PedestrianLightBehaviourStandard.class);

        Assertions.assertDoesNotThrow(() -> pedestrianLightStandard.setChangeBehaviour(pedestrianLightBehaviourStandard));
    }

    @Test
    public void setChangeBehaviourIncorrectCallException() {
        PedestrianLightBehaviour pedestrianLightBehaviour = mock(PedestrianLightBehaviour.class);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> pedestrianLightStandard.setChangeBehaviour(pedestrianLightBehaviour));
    }

    @Test
    public void setChangeBehaviourChangesBehaviour() {
        PedestrianLightBehaviourStandard pedestrianLightBehaviour = mock(PedestrianLightBehaviourStandard.class);
        pedestrianLightStandard.setChangeBehaviour(pedestrianLightBehaviour);

        assertEquals(pedestrianLightBehaviour, pedestrianLightStandard.getChangeBehaviour());
    }
}
