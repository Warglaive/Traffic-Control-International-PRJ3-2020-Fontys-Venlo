package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

public abstract class StraightTrafficObserverLight extends ObserverLight {
    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    protected StraightTrafficObserverLight(StraightTrafficLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);
    }

    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        try {
            StraightTrafficLightBehaviour straightLightBehaviour = (StraightTrafficLightBehaviour) changeBehaviour;
        } catch (ClassCastException e) {
            throw new ClassCastException("StraightTrafficLight needs a behaviour of type StraightTrafficLightBehaviour");
        }
        super.setChangeBehaviour(changeBehaviour);
    }

}
