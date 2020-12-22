package ui.UICrossing;

import lane.Lane;
import ui.UILane.UILaneObserver;
import ui.UILane.UiLane;

import java.util.Map;

public class UIFourWayCrossingEntranceObserver extends UIFourWayCrossingEntrance{
    /**
     * Create the UiLanes required for the UiCrossing.
     *
     * @param leftLane BusinessLane for left lane.
     * @param rightLane BusinessLane for right lane.
     * @param topLane BusinessLane for top lane.
     * @param bottomLane BusinessLane for bottom lane.
     * @param namespace  A map with all JavaFx components mapped to Strings as keys.
     */
    public UIFourWayCrossingEntranceObserver(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane, Map<String, Object> namespace) {
        super(namespace);
        this.leftLane = new UILaneObserver(leftLane, mapTrafficCircles("LL", "LT,LB" ));
        this.rightLane = new UILaneObserver(rightLane, mapTrafficCircles("RL", "RT,RB"));
        this.topLane = new UILaneObserver(topLane, mapTrafficCircles("TL", "TL,TR"));
        this.bottomLane = new UILaneObserver(bottomLane, mapTrafficCircles("BL", "BL,BR"));
    }
}
