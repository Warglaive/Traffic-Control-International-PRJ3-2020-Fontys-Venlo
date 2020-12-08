package ui.UICrossing;

import lane.Lane;
import ui.UILane.UiLane;

public abstract class UIFourWayCrossing {
    private UiLane leftLane;
    private UiLane rightLane;
    private UiLane topLane;
    private UiLane bottomLane;

    public UIFourWayCrossing(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane) {
        this.leftLane = new UiLane(leftLane);
    }
}
