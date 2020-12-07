package lights;

import annotations.Generated;
import lightBehaviours.LightBehaviour;
import locations.Location;

import java.util.Observable;

/**
 * The type Observer light.
 */
public abstract class ObserverLight extends Observable implements Light{
    private LightBehaviour changeBehaviour;
    private Location location;

    /**
     * Instantiates a new Observer light.
     *
     * @param changeBehaviour the change behaviour
     * @param location        the location
     */
    protected ObserverLight(LightBehaviour changeBehaviour, Location location) {
        this.changeBehaviour = changeBehaviour;
        this.location = location;
    }

    /**
     * Changes behaviour and notifies observers
     */
    @Override
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

    @Generated
    public Location getLocation() {
        return location;
    }


}
