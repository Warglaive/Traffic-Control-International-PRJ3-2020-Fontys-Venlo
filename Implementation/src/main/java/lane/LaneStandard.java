package lane;

import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import crossings.LaneType;
import lane.laneControllers.StraightLaneControllerStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.*;

/**
 * The type Lane standard.
 */
public class LaneStandard implements Lane {
    private StraightLaneControllerStandard straightLaneControllerStandard;

    /**
     * Instantiates a new Lane standard.
     *
     */
    public LaneStandard(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {

        this.changeStraightLaneController(
                parameterList.get(STRAIGHT)
        );
    }

    /**
     * Change straight lane controller.
     */
    public void changeStraightLaneController(Map<LaneParameterKey, Object> parameterList) {
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


    @Override
    public void run() {
        try {
            this.straightLaneControllerStandard.cycleLights();
        } catch (InterruptedException e) {
            //TODO: Poper exception handling
        }
    }
}
