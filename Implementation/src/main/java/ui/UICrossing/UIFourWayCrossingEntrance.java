package ui.UICrossing;

import crossings.LaneControllerType;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lane.Lane;
import ui.UILane.UiLane;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.PEDESTRIAN;
import static crossings.LaneControllerType.STRAIGHT;

public class UIFourWayCrossingEntrance extends UIFourWayCrossing {
    private UiLane leftLane;
    private UiLane rightLane;
    private UiLane topLane;
    private UiLane bottomLane;

    public UIFourWayCrossingEntrance(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane, Map<String, Object> namespace) {

        this.leftLane = new UiLane(leftLane, mapTrafficCircles(namespace, "LL", "LT,LB" ));
        this.rightLane = new UiLane(rightLane, mapTrafficCircles(namespace, "RL", "RT,RB"));
        this.topLane = new UiLane(topLane, mapTrafficCircles(namespace, "TL", "TL, TR"));
        this.bottomLane = new UiLane(bottomLane, mapTrafficCircles(namespace, "BL", "BL, BR"));
    }

    private Map<LaneControllerType, Map<String, Circle>> mapTrafficCircles(Map<String, Object> namespace, String trafficLightIdentfier, String pedestrianLightIdentifier) {
        var laneMap = new HashMap();
        laneMap.put(STRAIGHT, mapStraightCircles(namespace, trafficLightIdentfier));
        laneMap.put(PEDESTRIAN, mapPedestrianCircles(namespace, pedestrianLightIdentifier));

        return laneMap;
    }

    private Map<String, Circle> mapPedestrianCircles(Map<String, Object> namespace, String pedestrianLightIdentifier) {
        var seperatedIdentifier = pedestrianLightIdentifier.split(",");
        String[] position = {"top", "bottom"};
        int[] identifierForCircles = {1, 2};
        var baseIdentifier = "FourW_PL" + seperatedIdentifier[0] + "_Circle";

        var tempPedestrianCircleMap = mapCirclesStringX(namespace, baseIdentifier, position, identifierForCircles);


    }

    private Map<String, Circle> mapStraightCircles(Map<String, Object> namespace, String straightLightIdentifier) {
        String[] position = {"top", "middle", "bottom"};
        int[] identifierForCircle = {1, 2, 3};
        String baseIdentifier = "FourW_TL" + straightLightIdentifier + "_Circle";
        return mapCirclesStringX(namespace, baseIdentifier, position, identifierForCircle);
    }

    private Map<String, Circle> mapCirclesStringX(
            Map<String, Object> namespace, String baseIdentifier, String[] position, int[] identifierForCircle) {
        var circleMap = new HashMap();

        for(int i = 0; i < position.length; i++) {
            circleMap.put(position[i], namespace.get(baseIdentifier + identifierForCircle[i]));
        }

        return circleMap;
    }
}
