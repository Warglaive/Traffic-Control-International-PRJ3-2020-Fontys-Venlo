package ui.UICrossing;

import lane.Lane;
import ui.UILane.UILaneObserver;

import java.util.Map;

public class UIStraightCrossingEntranceObserver extends UIStraightCrossingEntrance {
    public UIStraightCrossingEntranceObserver(Lane leftLane, Lane rightLane, Map<String, Object> namespace) {
        super(namespace);
        this.leftLane = new UILaneObserver(leftLane, mapTrafficCircles("LL", "LT,LB" ));
        this.rightLane = new UILaneObserver(rightLane, mapTrafficCircles("RL", "RT,RB"));
    }
}
