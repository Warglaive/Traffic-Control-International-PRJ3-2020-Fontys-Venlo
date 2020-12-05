package lane.laneControllers;

import lightBehaviours.LightBehaviour;
import lights.StraightTrafficObserverLight;
import locations.Location;

import java.util.ArrayList;
import java.util.List;

public abstract class LaneControllerObserver implements LaneController{
    protected List<StraightTrafficObserverLight> lights;

    public LaneControllerObserver(int numberLights, LightBehaviour lightsBehaviour, Location location) {
        lights = new ArrayList<StraightTrafficObserverLight>();


        addLights(numberLights,
                lightsBehaviour,
                location);
    }

    public List<StraightTrafficObserverLight> getLights() {
        return lights;
    }

    @Override
    public void proceedOneState() {
        for(var currentLight : lights) {
            currentLight.changeColor();
        }
    }
}
