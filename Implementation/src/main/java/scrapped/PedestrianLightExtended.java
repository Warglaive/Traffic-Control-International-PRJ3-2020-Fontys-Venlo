package scrapped;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviourExtended;
import lights.Location;
import lights.PedestrianLight;
import ui.Ui;

public class PedestrianLightExtended extends PedestrianLight {
    public PedestrianLightExtended(Ui output, Location location) {
        super(PedestrianLightBehaviourExtended.RED, output, location);
    }

    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        try {
            PedestrianLightBehaviourExtended pedestrianLightBehaviourExtended = (PedestrianLightBehaviourExtended) changeBehaviour;
            super.setChangeBehaviour(pedestrianLightBehaviourExtended);
        } catch (Exception e) {
            throw new IllegalArgumentException("PedestrianLightStandard requires a parameter of type PedestrianLightBehaviourStandard");
        }

        super.setChangeBehaviour(changeBehaviour);
    }
}
