package ui.UICrossing;

import lane.Lane;
import ui.UILane.UiLane;

public class UIThreeWayCrossingEntrance {
    private UiLane leftLane;
    private UiLane rightLane;
    private UiLane bottomLane;

    public UIThreeWayCrossingEntrance(Lane leftLane, Lane rightLane, Lane bottomLane) {
        this.leftLane = new UiLane(leftLane);
        this.rightLane = new UiLane(rightLane);
        this.bottomLane = new UiLane(bottomLane);
    }
}