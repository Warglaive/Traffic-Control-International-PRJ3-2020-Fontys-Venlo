package crossings.factories;

import lane.Lane;
import ui.UICrossing.UIFourWayCrossingEntrance;
import ui.UICrossing.UIFourWayCrossingEntranceObserver;

import java.util.Map;

public class UIFourWayCrossingEntranceFactory {

    //Getter
    public UIFourWayCrossingEntrance getUIFourWayCrossingEntranceObserver(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane, Map<String, Object> namespace) {
        return new UIFourWayCrossingEntranceObserver(leftLane, rightLane, topLane, bottomLane, namespace);
    }
}
