package lights;

import lightBehaviours.LightBehaviour;
import locations.Location;
import ui.UIObserver;

public abstract class ObserverLight extends Light {

    protected ObserverLight(LightBehaviour changeBehaviour, UIObserver output, Location location) {
        super(changeBehaviour, location);
        this.addObserver(output);
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
