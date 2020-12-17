package lane;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lane.laneControllers.StraightLaneControllerStandard;
import lightBehaviours.*;
import lights.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;

import java.util.HashMap;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static crossings.parameterEnums.LaneParameterKey.*;
import static crossings.parameterEnums.LaneType.LEFT_LANE;
import static org.mockito.Mockito.mock;

public class TestLaneStandard {
    @Mock
    Location location;
    @Mock
    UIObserver uiObserver;

    StraightTrafficLightBehaviour straightTrafficLightBehaviour;
    PedestrianLightBehaviour pedestrianLightBehaviour;

    int straightGoDuration;
    int straightCycleTime;
    LaneStandard laneStandard;
    Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> laneParams;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        location = mock(Location.class);
        straightTrafficLightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        pedestrianLightBehaviour = PedestrianLightBehaviourStandard.RED;
        laneParams = new HashMap();

        HashMap laneParametersSingle = new HashMap();
        laneParametersSingle.put(STRAIGHT, parameterList(straightTrafficLightBehaviour));
        laneParametersSingle.put(PEDESTRIAN, parameterList(pedestrianLightBehaviour));
        laneParams.put(LEFT_LANE, laneParametersSingle);

        straightGoDuration = 25;
        straightCycleTime = 2;

        laneStandard = new LaneStandard(
                laneParams.get(LEFT_LANE)
        );
    }

    @Test
    public void changeStraightLaneController() {
        StraightLaneControllerStandard straightLaneControllerStandard = laneStandard.getStraightLaneController();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(straightLaneControllerStandard.getLights().size()).isEqualTo(2);
        });
    }

    private HashMap<LaneParameterKey, Object> parameterList(LightBehaviour lightBehaviour) {
        var laneMap = new HashMap();
        laneMap.put(NUMBER_LIGHTS, 2);
        laneMap.put(LIGHT_BEHAVIOUR, lightBehaviour);
        laneMap.put(LOCATION, location);
        laneMap.put(GO_DURATION, 25);
        laneMap.put(CYCLE_TIME, 2);

        return laneMap;
    }
}
