package scrapped;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourNetherlands;
import locations.Location;
import lights.StraightTrafficLight;
import ui.Ui;

public class StraightTrafficLightNetherlands extends StraightTrafficLight {

    public StraightTrafficLightNetherlands(Ui output, Location location) {
        super(StraightTrafficLightBehaviourNetherlands.RED, output, location);
    }

    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        try {
            StraightTrafficLightBehaviourNetherlands trafficLightBehaviourNetherlands = (StraightTrafficLightBehaviourNetherlands) changeBehaviour;
            super.setChangeBehaviour(trafficLightBehaviourNetherlands);
        } catch (Exception e) {
            throw new IllegalArgumentException("TrafficLightNetherlands requires a parameter of type TrafficLightBehaviourGermany");
        }

        super.setChangeBehaviour(changeBehaviour);
    }
}
