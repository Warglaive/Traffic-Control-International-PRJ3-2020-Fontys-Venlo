package lane.laneControllers;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

public abstract class StraightLaneController extends LaneControllerObserver {
    public StraightLaneController(int numberLights, StraightTrafficLightBehaviour lightsBehaviour, Location location) {
        super(numberLights, lightsBehaviour, location);
    }
}
