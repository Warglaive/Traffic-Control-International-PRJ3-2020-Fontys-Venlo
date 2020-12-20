package lane.laneControllers;

import lightBehaviours.LightBehaviour;
import lights.Location;

import java.util.List;

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
     * Proceeds all lights one state ahead
     */
    void proceedOneState();

    /**
     * Cycle all saved lights.
     * @throws InterruptedException If Thread gets interrupted.
     */
    void cycleLights() throws InterruptedException;

    /**
     * Get list of saved lights.
     * @return List of lights.
     */
    List getLights();
}

