package lane;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.StraightTrafficLight;
import locations.Location;
import ui.Ui;

import java.util.ArrayList;

public class StraightLaneController extends LaneController {
    private ArrayList<StraightTrafficLight> lights;

    public StraightLaneController(int numberLights,
                                  StraightTrafficLightBehaviour lightsBehaviour,
                                  Ui userInterface,
                                  Location location) {
        lights = new ArrayList<StraightTrafficLight>();

        addLights(numberLights,
                lightsBehaviour,
                userInterface,
                location);
    }

    /**
     * Adds lights to controller. Checks for correct typage in subclasses.
     *
     * @param numberLights    The number of lights to be added.
     * @param lightsBehaviour Behaviour the light is getting
     * @param userInterface   The user interface the lights are connected to.
     * @param location        The location of the light.
     */
    @Override
    public void addLights(int numberLights,
                          LightBehaviour lightsBehaviour,
                          Ui userInterface,
                          Location location) {

        if (numberLights <= 0) {
            throw new IllegalArgumentException("The number of lights has to be greater than 0");
        }

        StraightTrafficLightBehaviour straightLightsBehaviour;

        try {
            straightLightsBehaviour = (StraightTrafficLightBehaviour) lightsBehaviour;
        } catch (ClassCastException e) {
            throw new ClassCastException("The light behaviour has to be of type StraightTrafficLightBehaviour");
        }

        for (int i = 0; i < numberLights; i++) {
            lights.add(new StraightTrafficLight(straightLightsBehaviour, userInterface, location));
        }
    }
}
