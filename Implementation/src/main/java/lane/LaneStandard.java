package lane;

import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import crossings.LaneType;
import lane.laneControllers.PedestrianLaneControllerStandard;
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
    private PedestrianLaneControllerStandard pedestrianLaneControllerStandard;

    /**
     * Instantiates a new Lane standard.
     *
     */
    public LaneStandard(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList) {

        this.changeStraightLaneController(
                parameterList.get(STRAIGHT)
        );

        this.changePedestrianLaneController(parameterList.get(PEDESTRIAN));
    }

    /**
     * Change straight lane controller.
     */
    public void changeStraightLaneController(Map<LaneParameterKey, Object> parameterList) {
        this.straightLaneControllerStandard = new StraightLaneControllerStandard(
                parameterList
        );
    }

    /**
     * Change pedestrian lane controller.
     */
    public void changePedestrianLaneController(Map<LaneParameterKey, Object> parameterList) {
        this.pedestrianLaneControllerStandard = new PedestrianLaneControllerStandard(
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
            //TODO: Proper exception handling
        }
    }
}
