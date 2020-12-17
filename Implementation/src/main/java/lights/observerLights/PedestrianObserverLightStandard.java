package lights.observerLights;

import lightBehaviours.PedestrianLightBehaviour;
import lights.Location;

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
