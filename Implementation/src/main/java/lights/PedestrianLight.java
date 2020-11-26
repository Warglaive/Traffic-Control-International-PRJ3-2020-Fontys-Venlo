package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;
import ui.UILight;
import ui.UIObserver;
import ui.Ui;

public abstract class PedestrianLight extends ObserverLight{
    public PedestrianLight(LightBehaviour changeBehaviour, UIObserver output, Location location) {
        super(changeBehaviour, output, location);
    }

    /**
     * Ensures that changeBehaviour is of acceptable type for the specified light
     * @param changeBehaviour The new LightBehaviour
     */
    @Override
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {
        sample {
            PedestrianLightBehaviour pedestrianLightBehaviour = (PedestrianLightBehaviour) changeBehaviour;
            super.setChangeBehaviour(pedestrianLightBehaviour);
        } catch (Exception e) {
            throw new IllegalArgumentException("Pedestrian Light requires a parameter of type PedestrianLightBehaviour");
        }
    }
}
