package ui.UICrossing;

import lane.Lane;
import ui.UILane.UiLane;

public class UIFourWayCrossingEntrance extends UIFourWayCrossing {
    private UiLane leftLane;
    private UiLane rightLane;
    private UiLane topLane;
    private UiLane bottomLane;

    public UIFourWayCrossingEntrance(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane) {
        this.leftLane = new UiLane(leftLane);
        this.rightLane = new UiLane(rightLane);
        this.topLane = new UiLane(topLane);
        this.bottomLane = new UiLane(bottomLane);
    }
}
