package lane;

import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.StraightTrafficLightStandard;
import locations.Location;
import ui.UIObserver;
import ui.UIOutput;
import ui.Ui;

public class StraightLaneControllerStandard extends StraightLaneController{

    public StraightLaneControllerStandard(int numberLights,
                                          StraightTrafficLightBehaviour lightsBehaviour,
                                          UIObserver userInterface,
                                          Location location) {
        super(numberLights, lightsBehaviour, userInterface, location);
    }

    /**
     * Adds lights to controller. Checks for correct typage in subclasses.
     *
     * @param numberLights    The number of lights to be added.
     * @param lightsBehaviour Behaviour the light is getting
     * @param userInterface   The user interface the lights are connected to.
     * @param location        The location of the light.
     */
    public void addLights(int numberLights,
                          LightBehaviour lightsBehaviour,
                          UIOutput userInterface,
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

        UIObserver uiObserver;

        try {
            uiObserver = (UIObserver) userInterface;
        } catch (ClassCastException e) {
            throw new ClassCastException("The userInterface has to be of type UIObserver");
        }

        for (int i = 0; i < numberLights; i++) {
            super.getLights().add(new StraightTrafficLightStandard(straightLightsBehaviour, uiObserver, location));
        }
    }
}
