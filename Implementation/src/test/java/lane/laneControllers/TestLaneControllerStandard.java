package lane.laneControllers;

import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.PedestrianLightBehaviourStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.PEDESTRIAN;
import static crossings.LaneControllerType.STRAIGHT;
import static crossings.LaneParameterKey.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class TestLaneControllerStandard {
    @Mock
    Location location;

    LaneControllerStandard laneControllerStandard;
    PedestrianLightBehaviour lightBehaviour;
    Map<LaneControllerType, Map<LaneParameterKey, Object>> leftLaneParams;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.openMocks(this);
        location = mock(Location.class);
        lightBehaviour = PedestrianLightBehaviourStandard.RED;
        leftLaneParams = new HashMap();

        HashMap leftLaneStraightParams = new HashMap();
        leftLaneStraightParams.put(NUMBER_LIGHTS, 2);
        leftLaneStraightParams.put(LIGHT_BEHAVIOUR, lightBehaviour);
        leftLaneStraightParams.put(LOCATION, location);
        leftLaneStraightParams.put(GO_DURATION, 25);
        leftLaneStraightParams.put(CYCLE_TIME, 2);

        leftLaneParams = new HashMap();
        leftLaneParams.put(PEDESTRIAN, leftLaneStraightParams);

        laneControllerStandard = new PedestrianLaneControllerStandard(
                leftLaneStraightParams
        );
    }

    @Test
    public void proceedOneStateProceedsAllLights() {
        laneControllerStandard.proceedOneState();
        var lights = laneControllerStandard.getLights();

        SoftAssertions.assertSoftly(softly -> {
            for(var light : lights) {
                softly.assertThat(light.getChangeBehaviour())
                        .isEqualTo(PedestrianLightBehaviourStandard.GREEN);
            }
        });
    }

    @Test
    public void cycleLightsCallsCorrectSleep() throws InterruptedException {
        Sleeper sleeper = mock(Sleeper.class);

        this.laneControllerStandard = new PedestrianLaneControllerStandard(
                leftLaneParams.get(PEDESTRIAN)

        );

        laneControllerStandard.cycleLights(sleeper);

        verify(sleeper, times(1)).sleep(2);
        verify(sleeper, times(1)).sleep(25);
    }

    @Test
    public void cycleLightsEndsRed() throws InterruptedException {
        this.laneControllerStandard.cycleLights(mock(Sleeper.class));
        assertThat(this.laneControllerStandard.lights.get(0).getChangeBehaviour())
                .isEqualTo(PedestrianLightBehaviourStandard.RED);
    }
}
