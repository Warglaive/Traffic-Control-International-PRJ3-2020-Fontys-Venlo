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
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static org.mockito.Mockito.mock;
import static crossings.parameterEnums.LaneType.*;

public class TestUIFourWayCrossingEntrance {
    private Map<String, Object> namespace;
    String leftStraightIdentifier, leftPedestrianIdentifier,
            rightStraightIdentifier, rightPedestrianIdentifier,
            topStraightIdentifier, topPedestrianIdentifier,
            bottomStraightIdentifier, bottomPedestrianIdentifier;

    Lane leftLane, rightLane, topLane, bottomLane;

    Circle circle;


    @BeforeEach
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        namespace = new HashMap();
        circle = new Circle();


        this.setIdentifiers();
        this.createCircles();
        this.createLanes();

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

    private void setIdentifiers() {
        leftStraightIdentifier = "LL";
        rightStraightIdentifier = "RL";
        topStraightIdentifier = "TL";
        bottomStraightIdentifier = "BL";
        leftPedestrianIdentifier = "LT,LB";
        rightPedestrianIdentifier = "RT,RB";
        topPedestrianIdentifier = "TL,LR";
        bottomPedestrianIdentifier = "BL,BR";
    }

    private void createCircles() {
        createStraightCircles(leftStraightIdentifier);
        createStraightCircles(rightStraightIdentifier);
        createStraightCircles(topStraightIdentifier);
        createStraightCircles(bottomStraightIdentifier);

        createPedestrianCircles(leftPedestrianIdentifier);
        createPedestrianCircles(rightPedestrianIdentifier);
        createPedestrianCircles(topPedestrianIdentifier);
        createPedestrianCircles(bottomPedestrianIdentifier);
    }


    private void createStraightCircles(String identifier) {
        for(int i = 1; i <= 3; i++) {
            namespace.put("FourW_TL" + identifier + "_Circle" + i, circle);
        }
    }

    private void createPedestrianCircles(String identifier) {
        var identifierArray = identifier.split(",");
        for(int i = 1; i <= 2; i++) {
            namespace.put("FourW_PL" + identifierArray[0] + "_Circle" + i, circle);
            namespace.put("FourW_PL" + identifierArray[1] + "_Circle" + i, circle);
        }
    }


    @Test
    public void testMapCirclesToStringX() {
        UIFourWayCrossingEntrance crossing = new UIFourWayCrossingEntranceObserver(
                leftLane,
                rightLane,
                topLane,
                bottomLane,
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
                softly.assertThat(circle).isEqualTo(this.circle);
            }
            for(var circle : returnMap.get(PEDESTRIAN).get(0).values()) {
                softly.assertThat(circle).isEqualTo(this.circle);
            }
            for(var circle : returnMap.get(PEDESTRIAN).get(1).values()) {
                softly.assertThat(circle).isEqualTo(this.circle);
            }
        });
    }
}
