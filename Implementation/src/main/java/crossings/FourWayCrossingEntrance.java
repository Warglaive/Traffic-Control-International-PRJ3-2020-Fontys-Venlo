package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIOutput;

public abstract class FourWayCrossingEntrance implements FourWayCrossing {
    private FourWayCrossingControllerEntrance controller;

    public FourWayCrossingEntrance(int numberStraightLightsLeft,
                                   StraightTrafficLightBehaviour straightLightBehaviour,
                                   Location location,
                                   int straightGoDurationLeft,
                                   int straightCycleTimeLeft) {
        this.changeController(
                numberStraightLightsLeft,
                straightLightBehaviour,
                location,
                straightGoDurationLeft,
                straightCycleTimeLeft
        );
    }

    public abstract void changeController(int numberStraightLightsLeft,
                                          StraightTrafficLightBehaviour straightLightBehaviour,
                                          Location location,
                                          int straightGoDurationLeft,
                                          int straightCycleTimeLeft);

    public FourWayCrossingControllerEntrance getController() {
        return controller;
    }

    public void setController(FourWayCrossingControllerEntrance controller) {
        this.controller = controller;
    }
}
