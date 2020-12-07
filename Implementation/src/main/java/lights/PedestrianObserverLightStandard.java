package lights;

import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;

/**
 * The type Pedestrian observer light standard.
 */
public class PedestrianObserverLightStandard extends PedestrianObserverLight {
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     *
     * @param changeBehaviour The new LightBehaviour
     * @param location        the location
     */
    public PedestrianObserverLightStandard(PedestrianLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);
    }
}
