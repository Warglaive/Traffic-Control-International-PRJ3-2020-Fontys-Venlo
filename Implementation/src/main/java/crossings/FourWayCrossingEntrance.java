package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIOutput;

public abstract class FourWayCrossingEntrance implements FourWayCrossing {
    private FourWayCrossingControllerEntrance controller;

    public FourWayCrossingEntrance(int numberStraightLightsLeft,
                                   StraightTrafficLightBehaviour straightLightBehaviour,
                                   UIOutput userInterface,
                                   Location location) {
        this.changeController(
                numberStraightLightsLeft,
                straightLightBehaviour,
                userInterface,
                location
        );
    }

    public abstract void changeController(int numberStraightLightsLeft,
                                   StraightTrafficLightBehaviour straightLightBehaviour,
                                   UIOutput userInterface,
                                   Location location);

    public FourWayCrossingControllerEntrance getController() {
        return controller;
    }

    public void setController(FourWayCrossingControllerEntrance controller) {
        this.controller = controller;
    }
}
