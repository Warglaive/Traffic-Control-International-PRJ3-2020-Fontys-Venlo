package lane;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIObserver;

public class LaneStandard implements Lane {
    private StraightLaneController straightLaneController;

    public LaneStandard(int numberStraightLights,
                        StraightTrafficLightBehaviour straightLightBehaviour,
                        UIObserver userInterfaceStraight,
                        Location locationStraight) {

        this.changeStraightLaneController(
                numberStraightLights,
                straightLightBehaviour,
                locationStraight
        );
    }

    public void changeStraightLaneController(int numberLights,
                                             StraightTrafficLightBehaviour lightBehaviour,
                                             Location location) {
        this.straightLaneController = new StraightLaneControllerStandard(
                numberLights,
                lightBehaviour,
                location);
    }

    public StraightLaneController getStraightLaneController() {
        return straightLaneController;
    }


}
