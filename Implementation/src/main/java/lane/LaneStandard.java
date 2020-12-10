package lane;

import crossings.LaneParameterKey;
import lane.laneControllers.StraightLaneControllerStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;

/**
 * The type Lane standard.
 */
public class LaneStandard implements Lane {
    private StraightLaneControllerStandard straightLaneControllerStandard;

    /**
     * Instantiates a new Lane standard.
     *
     */
    public LaneStandard(HashMap<LaneParameterKey, Object> parameterList) {

        this.changeStraightLaneController(
                parameterList
        );
    }

    /**
     * Change straight lane controller.
     */
    public void changeStraightLaneController(HashMap<LaneParameterKey, Object> parameterList) {
        this.straightLaneControllerStandard = new StraightLaneControllerStandard(
                parameterList
        );
    }

    public StraightLaneControllerStandard getStraightLaneController() {
        return straightLaneControllerStandard;
    }

    @Override
    public void cycleStraightLights() throws InterruptedException {
        this.straightLaneControllerStandard.cycleLights();
    }


}
