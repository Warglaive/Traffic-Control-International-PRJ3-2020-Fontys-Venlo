package lights.observer;

import lightBehaviours.PedestrianLightBehaviour;
import lights.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TestPedestrianObserverLightStandard {
    @Mock
    UIObserver mockedUi;
    Location mockedLocation;

    PedestrianObserverLight pedestrianLight;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.pedestrianLight = new PedestrianObserverLightStandard(
                mock(PedestrianLightBehaviour.class),
      //          mockedUi,
                mockedLocation);
    }

    @Test
    public void testConstructorCreates() {
        assertThat(this.pedestrianLight).isExactlyInstanceOf(PedestrianObserverLightStandard.class);
    }
}
