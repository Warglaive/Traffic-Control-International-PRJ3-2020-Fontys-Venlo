package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;
import ui.Ui;

public abstract class PedestrianLight extends Light{
    public PedestrianLight(LightBehaviour changeBehaviour, Ui output, Location location) {
        super(changeBehaviour, output, location);
    }

    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        try {
            PedestrianLightBehaviour pedestrianLightBehaviour = (PedestrianLightBehaviour) changeBehaviour;
            super.setChangeBehaviour(pedestrianLightBehaviour);
        } catch (Exception e) {
            throw new IllegalArgumentException("Pedestrian Light requires a parameter of type PedestrianLightBehaviour");
        }
    }
}
