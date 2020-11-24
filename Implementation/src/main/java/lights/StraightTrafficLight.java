package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.Ui;

public abstract class StraightTrafficLight extends Light {
    public StraightTrafficLight(StraightTrafficLightBehaviour changeBehaviour, Ui output, Location location) {
        super(changeBehaviour, output, location);
    }

    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        try {
            StraightTrafficLightBehaviour straightTrafficLightBehaviour = (StraightTrafficLightBehaviour) changeBehaviour;
            super.setChangeBehaviour(straightTrafficLightBehaviour);
        } catch (Exception e) {
            throw new IllegalArgumentException("Traffic Light requires a parameter of type TrafficLightBehaviour");
        }
    }
}
