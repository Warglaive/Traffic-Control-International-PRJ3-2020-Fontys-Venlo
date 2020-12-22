package ui.UICrossing;

import crossings.TestUtils;
import javafx.scene.shape.Circle;
import lane.Lane;
import lane.LaneStandard;
import lane.laneControllers.standard.PedestrianLaneControllerStandard;
import lane.laneControllers.standard.StraightLaneControllerStandard;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;
import lights.observer.ObserverLight;
import lights.observer.PedestrianObserverLightStandard;
import lights.observer.StraightTrafficObserverLightStandard;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static org.mockito.Mockito.mock;
import static crossings.parameterEnums.LaneType.*;
import static org.mockito.Mockito.when;

public class TestUIFourWayCrossingEntrance {
    private Map<String, Object> namespace;
    String leftStraightIdentifier, leftPedestrianIdentifier,
            rightStraightIdentifier, rightPedestrianIdentifier,
            topStraightIdentifier, topPedestrianIdentifier,
            bottomStraightIdentifier, bottomPedestrianIdentifier;

    Lane leftLane, rightLane, topLane, bottomLane;
    @Mock
    Circle mockedCircle;
    @Mock
    StraightLaneControllerStandard straightLaneController;
    @Mock
    PedestrianLaneControllerStandard pedestrianLaneController;
    @Mock
    StraightTrafficObserverLightStandard straightLight;
    @Mock
    PedestrianObserverLightStandard pedestrianLight;

    private List<ObserverLight> straightLightList;
    private List<ObserverLight> pedestrianLightList;


    @BeforeEach
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        namespace = new HashMap();

        this.straightLightList = new ArrayList<>();
        straightLightList.add(straightLight);

        this.pedestrianLightList = new ArrayList<>();
        pedestrianLightList.add(pedestrianLight);

        this.setIdentifiers();
        this.createCircles();
        //this.setControllerBehaviour();
        this.createLanes();


    }

    private void createLanes() {
        var laneMap = TestUtils.getFullyMockedLanes(
                2, 5, mock(StraightTrafficLightBehaviour.class), mock(PedestrianLightBehaviour.class), mock(Location.class)
        );

        leftLane = laneMap.get(LEFT_LANE);
        rightLane = laneMap.get(RIGHT_LANE);
        topLane = laneMap.get(TOP_LANE);
        bottomLane = laneMap.get(BOTTOM_LANE);
/*
        leftLane = mock(LaneStandard.class);
        rightLane = mock(LaneStandard.class);
        topLane = mock(LaneStandard.class);
        bottomLane = mock(LaneStandard.class);
*/
        /*
        this.setLaneBehaviour(leftLane);
        this.setLaneBehaviour(rightLane);
        this.setLaneBehaviour(topLane);
        this.setLaneBehaviour(bottomLane);*/
    }
/*
    private void setLaneBehaviour(Lane lane) {
        when(lane.getStraightLaneController()).thenReturn(straightLaneController);
        when(lane.getPedestrianLaneController()).thenReturn(pedestrianLaneController);
    }

    private void setControllerBehaviour() {
        when(straightLaneController.getLights()).thenReturn(straightLightList);
        when(pedestrianLaneController.getLights()).thenReturn(pedestrianLightList);
    }*/

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
