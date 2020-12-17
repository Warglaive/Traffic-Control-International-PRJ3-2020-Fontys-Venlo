package lane;

import annotations.Generated;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import lane.laneControllers.LaneController;
import lane.laneControllers.PedestrianLaneControllerStandard;
import lane.laneControllers.StraightLaneControllerStandard;

import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;

/**
 * The type Lane standard.
 */
public class LaneStandard implements Lane {
    private StraightLaneControllerStandard straightLaneControllerStandard;
    private PedestrianLaneControllerStandard pedestrianLaneControllerStandard;

    /**
     * Instantiates a new Lane standard.
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

    @Generated
    @Override
    public LaneController getPedestrianLaneController() {
        return this.pedestrianLaneControllerStandard;
    }

    @Override
    public void cycleStraightLights() throws InterruptedException {
        this.straightLaneControllerStandard.cycleLights();
    }

}
