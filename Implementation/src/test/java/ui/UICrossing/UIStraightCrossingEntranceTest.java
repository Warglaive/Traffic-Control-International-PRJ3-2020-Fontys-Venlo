package ui.UICrossing;

import crossings.TestUtils;
import javafx.scene.shape.Circle;
import lane.Lane;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static crossings.parameterEnums.LaneType.*;
import static crossings.parameterEnums.LaneType.BOTTOM_LANE;
import static org.mockito.Mockito.mock;

public class UIStraightCrossingEntranceTest {
    private Map<String, Object> namespace;
    String leftStraightIdentifier, leftPedestrianIdentifier,
            rightStraightIdentifier, rightPedestrianIdentifier;

    Lane leftLane, rightLane, topLane, bottomLane;
    @Mock
    Circle mockedCircle;

    @BeforeEach
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        namespace = new HashMap();

        this.setIdentifiers();
        this.createCircles();
        this.createLanes();
    }
    private void setIdentifiers() {
        leftStraightIdentifier = "LL";
        rightStraightIdentifier = "RL";

        leftPedestrianIdentifier = "LT,LB";
        rightPedestrianIdentifier = "RT,RB";
    }

    private void createCircles() {
        createStraightCircles(leftStraightIdentifier);
        createStraightCircles(rightStraightIdentifier);

        createPedestrianCircles(leftPedestrianIdentifier);
        createPedestrianCircles(rightPedestrianIdentifier);
    }


    private void createStraightCircles(String identifier) {
        for(int i = 1; i <= 3; i++) {
            namespace.put("FourW_TL" + identifier + "_Circle" + i, mockedCircle);
        }
    }

    private void createPedestrianCircles(String identifier) {
        var identifierArray = identifier.split(",");
        for(int i = 1; i <= 2; i++) {
            namespace.put("FourW_PL" + identifierArray[0] + "_Circle" + i, mockedCircle);
            namespace.put("FourW_PL" + identifierArray[1] + "_Circle" + i, mockedCircle);
        }
    }

    private void createLanes() {
        var laneMap = TestUtils.getFullyMockedLanes(
                2, 5, mock(StraightTrafficLightBehaviour.class), mock(PedestrianLightBehaviour.class), mock(Location.class)
        );

        leftLane = (Lane) laneMap.get(LEFT_LANE).get("Lane");
        rightLane = (Lane) laneMap.get(RIGHT_LANE).get("Lane");
        topLane = (Lane) laneMap.get(TOP_LANE).get("Lane");
        bottomLane = (Lane) laneMap.get(BOTTOM_LANE).get("Lane");
    }

    @Test
    public void testMapCirclesToStringX() {
        //Straight here
        UIStraightCrossingEntrance crossing = new UIStraightCrossingEntranceObserver(
                leftLane,
                rightLane,
                namespace
        );
        var returnMap = crossing.mapTrafficCircles(leftStraightIdentifier, leftPedestrianIdentifier);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(returnMap.get(STRAIGHT).size()).isEqualTo(1);
            softly.assertThat(returnMap.get(PEDESTRIAN).size()).isEqualTo(2);

            softly.assertThat(returnMap.get(STRAIGHT).get(0).size()).isEqualTo(3);
            softly.assertThat(returnMap.get(PEDESTRIAN).get(0).size()).isEqualTo(2);
            softly.assertThat(returnMap.get(PEDESTRIAN).get(1).size()).isEqualTo(2);

            for(var circle : returnMap.get(STRAIGHT).get(0).values()) {
                softly.assertThat(circle).isEqualTo(mockedCircle);
            }
            for(var circle : returnMap.get(PEDESTRIAN).get(0).values()) {
                softly.assertThat(circle).isEqualTo(mockedCircle);
            }
            for(var circle : returnMap.get(PEDESTRIAN).get(1).values()) {
                softly.assertThat(circle).isEqualTo(mockedCircle);
            }
        });
    }
}
