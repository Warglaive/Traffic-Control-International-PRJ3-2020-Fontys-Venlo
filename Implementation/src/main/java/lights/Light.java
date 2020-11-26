package lights;

import lightBehaviours.LightBehaviour;
import locations.Location;

import java.util.Observable;

public abstract class Light extends Observable {
    private LightBehaviour changeBehaviour;
    private Location location;

    protected Light(LightBehaviour changeBehaviour,Location location) {
        this.changeBehaviour = changeBehaviour;
        this.location = location;
    }

    public abstract void changeColor();

    public void setChangeBehaviour(LightBehaviour changeBehaviour) {this.changeBehaviour = changeBehaviour;}

    public LightBehaviour getChangeBehaviour() {
        return changeBehaviour;
    }

    public Location getLocation() {
        return location;
    }


}
