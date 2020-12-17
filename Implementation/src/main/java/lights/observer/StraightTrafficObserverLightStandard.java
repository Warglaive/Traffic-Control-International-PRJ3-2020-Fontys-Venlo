package lights.observer;

import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;

/**
 * The type Straight traffic observer light standard.
 */
public class StraightTrafficObserverLightStandard extends StraightTrafficObserverLight {
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     *
     * @param changeBehaviour The new LightBehaviour
     * @param location        the location
     */
    public StraightTrafficObserverLightStandard(StraightTrafficLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);
    }
}
