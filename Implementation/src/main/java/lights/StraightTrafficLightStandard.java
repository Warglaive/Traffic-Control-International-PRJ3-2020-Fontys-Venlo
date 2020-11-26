package lights;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIObserver;
import ui.Ui;

public class StraightTrafficLightStandard extends StraightTrafficLight{
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    public StraightTrafficLightStandard(StraightTrafficLightBehaviour changeBehaviour, UIObserver output, Location location) {
        super(changeBehaviour, output, location);
    }
}
