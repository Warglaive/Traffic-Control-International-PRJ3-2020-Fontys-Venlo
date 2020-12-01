package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;
import ui.UILight;
import ui.UIObserver;
import ui.UIOutput;
import ui.Ui;

public abstract class PedestrianLight extends Light{
    protected PedestrianLight(PedestrianLightBehaviour changeBehaviour, Location location) {
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

    /*public PedestrianLight(LightBehaviour changeBehaviour, UIOutput output, Location location) {
        super(changeBehaviour, output, location);
    }*/

}
