package lane;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.StraightTrafficLight;
import locations.Location;
import ui.UIObserver;
import ui.Ui;

import java.util.ArrayList;

public abstract class StraightLaneController extends LaneControllerObserver {
    private ArrayList<StraightTrafficLight> lights;

    public StraightLaneController(int numberLights,
                                  StraightTrafficLightBehaviour lightsBehaviour,
                                  UIObserver userInterface,
                                  Location location) {
        lights = new ArrayList<StraightTrafficLight>();

        addLights(numberLights,
                lightsBehaviour,
                userInterface,
                location);
    }

    public ArrayList<StraightTrafficLight> getLights() {
        return lights;
    }

}
