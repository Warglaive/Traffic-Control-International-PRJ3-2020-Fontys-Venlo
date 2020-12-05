package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;

public abstract class PedestrianObserverLight extends ObserverLight {
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    protected PedestrianObserverLight(PedestrianLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);

    }

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
