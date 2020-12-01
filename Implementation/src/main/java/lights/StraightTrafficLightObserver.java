package lights;

import javafx.beans.Observable;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIObserver;

public abstract class StraightTrafficLightObserver extends StraightTrafficLight {
    public StraightTrafficLightObserver(StraightTrafficLightBehaviour changeBehaviour, Location location) {
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
