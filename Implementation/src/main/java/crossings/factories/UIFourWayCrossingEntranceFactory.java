package crossings.factories;

import javafx.scene.Scene;
import lane.Lane;
import ui.UICrossing.UIFourWayCrossingEntrance;

import java.util.Map;

public class UIFourWayCrossingEntranceFactory {

    //Getter
    public UIFourWayCrossingEntrance getUIFourWayCrossingEntrance(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane, Map<String, Object> namespace) {
        return new UIFourWayCrossingEntrance(leftLane, rightLane, topLane, bottomLane, namespace);
    }
}
