package lights.observer;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import lights.Location;

/**
 * The type Pedestrian observer light.
 */
public abstract class PedestrianObserverLight extends ObserverLight {
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     *
     * @param changeBehaviour The new LightBehaviour
     * @param location        the location
     */
    protected PedestrianObserverLight(PedestrianLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);

    }

    /**
     * Set a given change behaviour.
     * @param changeBehaviour the change behaviour.
     */
    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        try {
            PedestrianLightBehaviour pedestrianLightBehaviour = (PedestrianLightBehaviour) changeBehaviour;
        } catch (ClassCastException e) {
            throw new ClassCastException("PedestrianLight needs a behaviour of type PedestrianLightBehaviour");
        }
        super.setChangeBehaviour(changeBehaviour);
    }
}
