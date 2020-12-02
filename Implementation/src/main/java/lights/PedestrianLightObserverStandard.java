package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;
import ui.UIObserver;
import ui.Ui;

public class PedestrianLightObserverStandard extends PedestrianLightObserver{
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    public PedestrianLightObserverStandard(PedestrianLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);
    }
}
