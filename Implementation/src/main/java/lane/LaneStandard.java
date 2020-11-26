package lane;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UILight;
import ui.Ui;

public class LaneStandard implements Lane {
    private StraightLaneController straightLaneController;

    public LaneStandard(int numberStraightLights,
                        StraightTrafficLightBehaviour straightLightBehaviour,
                        UILight userInterface,
                        Location location) {

    }
}
