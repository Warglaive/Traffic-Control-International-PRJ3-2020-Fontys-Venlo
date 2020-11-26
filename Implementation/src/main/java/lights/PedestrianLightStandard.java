package lights;

import lightBehaviours.LightBehaviour;
import locations.Location;
import ui.UIObserver;
import ui.Ui;

public class PedestrianLightStandard extends PedestrianLight{
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    public PedestrianLightStandard(LightBehaviour changeBehaviour, UIObserver output, Location location) {
        super(changeBehaviour, output, location);
    }
}
