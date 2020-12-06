package lights;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

public class StraightTrafficObserverLightStandard extends StraightTrafficObserverLight {
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    public StraightTrafficObserverLightStandard(StraightTrafficLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);
    }
}
