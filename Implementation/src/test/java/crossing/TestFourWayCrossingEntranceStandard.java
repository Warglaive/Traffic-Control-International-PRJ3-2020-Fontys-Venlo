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

        parameterCollection = TestUtils.getFourLaneParamMap(
                straightGoDuration, straightCycleTime, straightTrafficLightBehaviour, location
        );

        crossing = new FourWayCrossingEntranceStandard(
                parameterCollection, 2
        );
    }

    @Test
    public void changeControllerCorrect() {
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
