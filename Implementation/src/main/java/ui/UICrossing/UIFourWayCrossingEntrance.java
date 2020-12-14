package ui.UICrossing;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lane.Lane;
import ui.UILane.UiLane;

import java.util.HashMap;
import java.util.Map;

public class UIFourWayCrossingEntrance extends UIFourWayCrossing {
    private UiLane leftLane;
    private UiLane rightLane;
    private UiLane topLane;
    private UiLane bottomLane;

    public UIFourWayCrossingEntrance(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane, Map<String, Object> namespace) {

        this.leftLane = new UiLane(leftLane, mapTrafficCircles(namespace, "LL"));
        this.rightLane = new UiLane(rightLane, mapTrafficCircles(namespace, "RL"));
        this.topLane = new UiLane(topLane, mapTrafficCircles(namespace, "TL"));
        this.bottomLane = new UiLane(bottomLane, mapTrafficCircles(namespace, "BL"));
    }

    private HashMap<String, Circle> mapTrafficCircles(Map<String, Object> namespace, String trafficLightIdentfier) {
        var circleMap = new HashMap();
        circleMap.put("top", namespace.get("FourW_TL" + trafficLightIdentfier + "_Circle1"));
        circleMap.put("middle", namespace.get("FourW_TL" + trafficLightIdentfier + "_Circle2"));
        circleMap.put("bottom", namespace.get("FourW_TL" + trafficLightIdentfier + "_Circle3"));

        return circleMap;
    }
}
