package lights.observer;

import annotations.Generated;
import lightBehaviours.LightBehaviour;
import lights.Light;
import lights.Location;

import java.util.Observable;

/**
 * The type Observer light.
 */
public abstract class ObserverLight extends Observable implements lights.Light {
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

    /**
     * Set a given change behaviour.
     * @param changeBehaviour the change behaviour.
     */
    public void setChangeBehaviour(LightBehaviour changeBehaviour) {this.changeBehaviour = changeBehaviour;}

    /**
     * Get saved change behaviour.
     * @return A LightBehaviour.
     */
    public LightBehaviour getChangeBehaviour() {
        return changeBehaviour;
    }

    /**
     * Get saved location.
     * @return Location.
     */
    @Generated
    public Location getLocation() {
        return location;
    }


}
