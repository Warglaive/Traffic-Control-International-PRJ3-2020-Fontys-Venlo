package crossing;

import crossings.*;
import lane.LaneStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ui.UIObserver;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.STRAIGHT;
import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TestFourWayCrossingEntranceStandard {
    @Mock
    Location location;
    @Mock
    UIObserver uiObserver;
    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;

    int straightGoDuration;
    int straightCycleTime;
    FourWayCrossingEntrance crossing;

    Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterCollection;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        straightGoDuration = 25;
        straightCycleTime = 2;

        parameterCollection = new HashMap();

        var leftLaneStraightParams = new HashMap();
        leftLaneStraightParams.put(NUMBER_LIGHTS, 2);
        leftLaneStraightParams.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneStraightParams.put(LOCATION, location);
        leftLaneStraightParams.put(GO_DURATION, straightGoDuration);
        leftLaneStraightParams.put(CYCLE_TIME, straightCycleTime);

        var rightLaneStraightParams = new HashMap();
        rightLaneStraightParams.put(NUMBER_LIGHTS, 2);
        rightLaneStraightParams.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        rightLaneStraightParams.put(LOCATION, location);
        rightLaneStraightParams.put(GO_DURATION, straightGoDuration);
        rightLaneStraightParams.put(CYCLE_TIME, straightCycleTime);

        var topLaneStraightParams = new HashMap();
        topLaneStraightParams.put(NUMBER_LIGHTS, 2);
        topLaneStraightParams.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        topLaneStraightParams.put(LOCATION, location);
        topLaneStraightParams.put(GO_DURATION, straightGoDuration);
        topLaneStraightParams.put(CYCLE_TIME, straightCycleTime);

        var bottomLaneStraightParams = new HashMap();
        bottomLaneStraightParams.put(NUMBER_LIGHTS, 2);
        bottomLaneStraightParams.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        bottomLaneStraightParams.put(LOCATION, location);
        bottomLaneStraightParams.put(GO_DURATION, straightGoDuration);
        bottomLaneStraightParams.put(CYCLE_TIME, straightCycleTime);

        var leftLane = new HashMap();
        var rightLane = new HashMap();
        var topLane = new HashMap();
        var bottomLane = new HashMap();

        leftLane.put(STRAIGHT, leftLaneStraightParams);
        rightLane.put(STRAIGHT, rightLaneStraightParams);
        bottomLane.put(STRAIGHT, topLaneStraightParams);
        topLane.put(STRAIGHT, bottomLaneStraightParams);

        parameterCollection.put(LEFT_LANE, leftLane);
        parameterCollection.put(RIGHT_LANE, rightLane);
        parameterCollection.put(TOP_LANE, topLane);
        parameterCollection.put(BOTTOM_LANE, bottomLane);

        crossing = new FourWayCrossingEntranceStandard(
                parameterCollection
        );
    }

    @Test
    public void changeControllerCorrect() {
        ;
        assertThat(crossing.getController()).isNotNull();
    }

    @Test
    public void constructorCreatesLanes() {
        SoftAssertions.assertSoftly(softly -> {
            assertThat(crossing.getController().getLeftLane()).isNotNull();
            assertThat(crossing.getController().getRightLane()).isNotNull();
            assertThat(crossing.getController().getTopLane()).isNotNull();
            assertThat(crossing.getController().getBottomLane()).isNotNull();
        });
    }

}
