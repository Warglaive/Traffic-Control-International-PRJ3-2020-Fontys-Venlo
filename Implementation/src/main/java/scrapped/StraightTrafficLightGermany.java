package scrapped;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import lights.StraightTrafficLight;
import locations.Location;
import ui.Ui;

public class StraightTrafficLightGermany extends StraightTrafficLight {

    public StraightTrafficLightGermany(Ui output, Location location) {
        super(StraightTrafficLightBehaviourGermany.RED, output, location);
    }

    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        try {
            StraightTrafficLightBehaviourGermany trafficLightBehaviourGermany = (StraightTrafficLightBehaviourGermany) changeBehaviour;
            super.setChangeBehaviour(trafficLightBehaviourGermany);
        } catch (Exception e) {
            throw new IllegalArgumentException("TrafficLightGermany requires a parameter of type TrafficLightBehaviourGermany");
        }

        super.setChangeBehaviour(changeBehaviour);
    }
}
