package ui.UILane;

import crossings.TestUtils;
import crossings.parameterEnums.LaneControllerType;
import javafx.scene.shape.Circle;
import lane.Lane;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crossings.parameterEnums.LaneType.*;
import static crossings.parameterEnums.LaneControllerType.*;
import static org.mockito.Mockito.mock;

public class TestUILaneObserver {
    Lane businessLane;
    Map<LaneControllerType, List<Map<String, Circle>>> circleMap;
    UiLane uiLane;

    @BeforeEach
    @Before
    public void setUp() {
        var laneMap = TestUtils.getFullyMockedLanes(
                2, 5, mock(StraightTrafficLightBehaviour.class), mock(PedestrianLightBehaviour.class), mock(Location.class)
        );
       //Map<LaneControllerType, List<Map<String, Circle >>>
        this.businessLane = (Lane) laneMap.get(LEFT_LANE).get("Lane");
        this.circleMap = new HashMap();
        var straightCircleList = new ArrayList();
        var pedestrianCircleList = new ArrayList();
        var straightCircleMap = new HashMap();
        var pedestrianCircleMap = new HashMap();

        var circle = new Circle();

        straightCircleMap.put("top", circle);
        straightCircleMap.put("middle", circle);
        straightCircleMap.put("bottom", circle);

        pedestrianCircleMap.put("top", circle);
        pedestrianCircleMap.put("bottom", circle);

        straightCircleList.add(straightCircleMap);
        pedestrianCircleList.add(pedestrianCircleMap);

        circleMap.put(STRAIGHT, straightCircleList);
        circleMap.put(PEDESTRIAN, pedestrianCircleList);

        uiLane = new UILaneObserver(
                businessLane, circleMap
        );
    }

    @Test
    public void testFetchLights() {
        //Map<UiLightType, List<lights.Light>>
        var actualTrafficLights = businessLane.getStraightLaneController().getLights();
        var actualPedestrianLights = businessLane.getPedestrianLaneController().getLights();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(uiLane.getStraightLights()).isEqualTo(actualTrafficLights);
            softly.assertThat(uiLane.getPedestrianLights()).isEqualTo(actualPedestrianLights);
        });
    }
}
