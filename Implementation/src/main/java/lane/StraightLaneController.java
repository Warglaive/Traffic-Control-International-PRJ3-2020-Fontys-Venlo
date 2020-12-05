package lane;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.StraightTrafficLight;
import locations.Location;
import ui.UIObserver;
import ui.Ui;

import java.util.ArrayList;
import java.util.List;

public abstract class StraightLaneController extends LaneControllerObserver {
    private List<StraightTrafficLight> lights;

    public StraightLaneController(int numberLights,
                                  StraightTrafficLightBehaviour lightsBehaviour,
                                  Location location) {
        lights = new ArrayList<StraightTrafficLight>();

        addLights(numberLights,
                lightsBehaviour,
                location);
    }

    public List<StraightTrafficLight> getLights() {
        return lights;
    }

    @Override
    public void proceedOneState() {
        for(var currentLight : lights) {
            currentLight.changeColor();
        }
    }
}
