package lights;

import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import locations.Location;
import ui.UIObserver;
import ui.UIOutput;

import java.util.Observable;
import java.util.Observer;

public abstract class PedestrianLightObserver extends PedestrianLight {
    public PedestrianLightObserver(PedestrianLightBehaviour changeBehaviour, Location location) {
        super(changeBehaviour, location);
    }

    /**
     * Changes behaviour and notifies observers
     */
    @Override
    public void changeColor() {
        String newColor = super.getChangeBehaviour().changeColor(this);

        if (countObservers() > 0) {
            setChanged();
            notifyObservers(newColor);
        }
    }
}
