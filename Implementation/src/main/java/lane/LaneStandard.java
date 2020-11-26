package lane;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UILight;
import ui.UIObserver;
import ui.Ui;

public class LaneStandard implements Lane {
    private StraightLaneController straightLaneController;

    public LaneStandard(int numberStraightLights,
                        StraightTrafficLightBehaviour straightLightBehaviour,
                        UIObserver userInterfaceStraight,
                        Location locationStraight) {

        this.changeStraightLaneController(
                numberStraightLights,
                straightLightBehaviour,
                userInterfaceStraight,
                locationStraight
        );
    }

    public void changeStraightLaneController(int numberLights,
                                             StraightTrafficLightBehaviour lightBehaviour,
                                             UIObserver userInterface,
                                             Location location) {
        this.straightLaneController = new StraightLaneControllerStandard(
                numberLights,
                lightBehaviour,
                userInterface,
                location);
    }

    public StraightLaneController getStraightLaneController() {
        return straightLaneController;
    }


}
