package ui.UICrossing;

import javafx.scene.shape.Circle;
import lane.Lane;
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
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TestUIFourWayCrossingEntrance {
    /*
    this.leftLane = new UILaneObserver(leftLane, mapTrafficCircles("LL", "LT,LB" ));
        this.rightLane = new UILaneObserver(rightLane, mapTrafficCircles("RL", "RT,RB"));
        this.topLane = new UILaneObserver(topLane, mapTrafficCircles("TL", "TL,TR"));
        this.bottomLane = new UILaneObserver(bottomLane, mapTrafficCircles("BL", "BL,BR"));
        FourW_PLLT_Circle1
        FourW_TLBL_Circle1
     */

    private Map<String, Object> namespace;
    String leftStraightIdentifier, leftPedestrianIdentifier,
            rightStraightIdentifier, rightPedestrianIdentifier,
            topStraightIdentifier, topPedestrianIdentifier,
            bottomStraightIdentifier, bottomPedestrianIdentifier;

    @Mock
    Lane leftLane, rightLane, topLane, bottomLane;
    @Mock
    Circle mockedCircle;

    @BeforeEach
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        namespace = new HashMap();
        leftStraightIdentifier = "LL";
        rightStraightIdentifier = "RL";
        topStraightIdentifier = "TL";
        bottomStraightIdentifier = "BL";
        leftPedestrianIdentifier = "LT,LB";
        rightPedestrianIdentifier = "RT,RB";
        topPedestrianIdentifier = "TL,LR";
        bottomPedestrianIdentifier = "BL,BR";

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

    /*@Test
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

            softly.assertThat(returnMap.get(STRAIGHT).size()).isEqualTo(3);
            for(var circle : returnMap.get(STRAIGHT).get(0).values()) {
                softly.assertThat(circle).isEqualTo(mockedCircle);
            }
            for(var circle : returnMap.get(PEDESTRIAN).get(0).values()) {
                softly.assertThat(circle).isEqualTo(mockedCircle);
            }
            for(var circle : returnMap.get(STRAIGHT).get(1).values()) {
                softly.assertThat(circle).isEqualTo(mockedCircle);
            }
        });
    }*/
}
