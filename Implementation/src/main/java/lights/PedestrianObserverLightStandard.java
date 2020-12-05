package lights;

import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;

public class PedestrianObserverLightStandard extends PedestrianObserverLight {
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    public PedestrianObserverLightStandard(PedestrianLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);
    }
}
