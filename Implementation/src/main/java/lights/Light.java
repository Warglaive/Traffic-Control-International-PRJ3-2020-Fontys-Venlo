package lights;

import lightBehaviours.LightBehaviour;
import locations.Location;
import ui.Ui;

import java.util.Observable;

public abstract class Light extends Observable {
    private LightBehaviour changeBehaviour;
    private Location location;

    protected Light(LightBehaviour changeBehaviour, Ui output, Location location) {
        this.changeBehaviour = changeBehaviour;
        this.addObserver(output);
        this.location = location;
    }

    /**
     * Changes behaviour and notifies observers
     */
    public void changeColor() {
        String newColor = changeBehaviour.changeColor(this);

        if (countObservers() > 0) {
            setChanged();
            notifyObservers(newColor);
        }
    }



    public void setChangeBehaviour(LightBehaviour changeBehaviour) {this.changeBehaviour = changeBehaviour;}

    public LightBehaviour getChangeBehaviour() {
        return changeBehaviour;
    }

    public Location getLocation() {
        return location;
    }
}
