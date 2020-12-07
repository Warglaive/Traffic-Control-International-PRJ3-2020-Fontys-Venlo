package ui.UICrossing;

import lane.Lane;

public class UIFourWayCrossingEntrance extends UIFourWayCrossing {
    private Lane leftLane;
    private Lane rightLane;
    private Lane topLane;
    private Lane bottomLane;

    private UIFourWayCrossingEntrance(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane) {
        this.leftLane = leftLane;
        this.rightLane = rightLane;
        this.topLane = topLane;
        this.bottomLane = bottomLane;
    }

    private void LeftCrossingLights() throws InterruptedException {
        this.leftLane.cycleStraightLights();
    }
}
