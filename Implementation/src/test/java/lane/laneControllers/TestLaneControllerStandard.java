package lane.laneControllers;

import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class TestLaneControllerStandard {
    @Mock
    Location location;

    LaneControllerStandard laneControllerStandard;
    StraightTrafficLightBehaviour lightBehaviour;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.openMocks(this);
        location = mock(Location.class);
        lightBehaviour = StraightTrafficLightBehaviourGermany.RED;

        laneControllerStandard = new StraightLaneControllerStandard(
                10,
                lightBehaviour,
                location,
                25,
                2
        );
    }

    @Test
    public void proceedOneStateProceedsAllLights() {
        laneControllerStandard.proceedOneState();
        var lights = laneControllerStandard.getLights();

        SoftAssertions.assertSoftly(softly -> {
            for(var light : lights) {
                softly.assertThat(light.getChangeBehaviour())
                        .isEqualTo(StraightTrafficLightBehaviourGermany.REDYELLOW);
            }
        });
    }

    @Test
    public void cycleLightsCallsCorrectSleep() throws InterruptedException {
        Sleeper sleeper = mock(Sleeper.class);

        this.laneControllerStandard = new StraightLaneControllerStandard(
                1,
                lightBehaviour,
                location,
                25,
                2
        );

        laneControllerStandard.cycleLights(sleeper);

        verify(sleeper, times(3)).sleep(2);
        verify(sleeper, times(1)).sleep(25);
    }

    @Test
    public void cycleLightsEndsRed() throws InterruptedException {
        this.laneControllerStandard.cycleLights(mock(Sleeper.class));
        assertThat(this.laneControllerStandard.lights.get(0).getChangeBehaviour())
                .isEqualTo(StraightTrafficLightBehaviourGermany.RED);
    }
}
