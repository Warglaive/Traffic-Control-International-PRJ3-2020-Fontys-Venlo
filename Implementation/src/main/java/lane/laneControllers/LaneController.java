package lane.laneControllers;

import lightBehaviours.LightBehaviour;
import locations.Location;

public interface LaneController {
    /**
     * Adds lights to controller. Checks for correct typage in subclasses.
     * @param numberLights The number of lights to be added.
     * @param lightsBehaviour Behaviour the light is getting
     * @param location The location of the light.
     */
    void addLights(int numberLights,
                   LightBehaviour lightsBehaviour,
                   Location location);

    /**
     * Proceeds all traffic lights one state ahead
     */
    void proceedOneState();


}

