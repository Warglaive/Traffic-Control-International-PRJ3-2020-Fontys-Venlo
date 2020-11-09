package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviourStandard;
import ui.Ui;

public class PedestrianLightStandard extends PedestrianLight {
    public PedestrianLightStandard(Ui output, Location location) {
        super(PedestrianLightBehaviourStandard.RED, output, location);
    }

    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        try {
            PedestrianLightBehaviourStandard pedestrianLightBehaviourStandard = (PedestrianLightBehaviourStandard) changeBehaviour;
            super.setChangeBehaviour(pedestrianLightBehaviourStandard);
        } catch (Exception e) {
            throw new IllegalArgumentException("PedestrianLightStandard requires a parameter of type PedestrianLightBehaviourStandard");
        }

        super.setChangeBehaviour(changeBehaviour);
    }
}
