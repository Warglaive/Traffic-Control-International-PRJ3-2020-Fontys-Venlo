package lane;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.StraightTrafficLight;
import locations.Location;
import ui.Ui;

import java.util.ArrayList;

public class StraightLaneController implements LaneController {
    private ArrayList<StraightTrafficLight> lights;

    public StraightLaneController(int numberLights,
                                  StraightTrafficLightBehaviour lightsBehaviour,
                                  Ui userInterface,
                                  Location location) {
        if (numberLights <= 0) {
            throw new IllegalArgumentException("The number of lights has to be greater than 0");
        }

        addLights(numberLights,
                lightsBehaviour,
                userInterface,
                location);
    }

    public void addLights(int numberLights,
                          StraightTrafficLightBehaviour lightsBehaviour,
                          Ui userInterface,
                          Location location) {
        for (int i = 0; i < numberLights; i++) {
            lights.add(new StraightTrafficLight(lightsBehaviour, userInterface, location));
        }
    }
}
