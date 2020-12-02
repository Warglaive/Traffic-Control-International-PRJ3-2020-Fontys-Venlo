package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UILight;
import ui.UIObserver;
import ui.Ui;

public abstract class StraightTrafficLight extends Light {
    protected StraightTrafficLight(StraightTrafficLightBehaviour changeBehaviour, Location location) {
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
    /*public StraightTrafficLight(StraightTrafficLightBehaviour changeBehaviour, UIOutput output, Location location) {
        super(changeBehaviour, output, location);
    }*/

}
