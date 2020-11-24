package lights;

import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ui.Ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TestPedestrianLightStandard {
    @Mock
    Ui mockedUi;
    Location mockedLocation;

    PedestrianLight pedestrianLight;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.pedestrianLight = new PedestrianLightStandard(
                mock(PedestrianLightBehaviour.class),
                mockedUi,
                mockedLocation);
    }

    @Test
    public void testConstructorCreates() {
        assertThat(this.pedestrianLight).isExactlyInstanceOf(PedestrianLightStandard.class);
    }
}
