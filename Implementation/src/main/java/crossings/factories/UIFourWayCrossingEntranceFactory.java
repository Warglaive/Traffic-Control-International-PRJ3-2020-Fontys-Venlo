package crossings.factories;

import lane.Lane;
import ui.UICrossing.UIFourWayCrossingEntrance;

public class UIFourWayCrossingEntranceFactory {

    //Getter
    public UIFourWayCrossingEntrance getUIFourWayCrossingEntrance(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane) {
        return new UIFourWayCrossingEntrance(leftLane, rightLane, topLane, bottomLane);
    }
}
