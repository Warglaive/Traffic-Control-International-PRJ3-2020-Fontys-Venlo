package lane;

import lightBehaviours.LightBehaviour;
import locations.Location;
import ui.UIOutput;
import ui.Ui;

public interface LightControlling {
    /**
     * Adds lights to controller. Checks for correct typage in subclasses.
     * @param numberLights The number of lights to be added.
     * @param lightsBehaviour Behaviour the light is getting
     * @param location The location of the light.
     */
    void addLights(int numberLights,
                   LightBehaviour lightsBehaviour,
                   Location location);

    void proceedOneState();
}
