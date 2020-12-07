package lane;

import lane.laneControllers.StraightLaneControllerStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

/**
 * The type Lane standard.
 */
public class LaneStandard implements Lane {
    private StraightLaneControllerStandard straightLaneControllerStandard;

    /**
     * Instantiates a new Lane standard.
     *
     * @param numberStraightLights   the number straight lights
     * @param straightLightBehaviour the straight light behaviour
     * @param location               the location
     * @param straightGoDurationLeft the straight go duration left
     * @param straightCycleTimeLeft  the straight cycle time left
     */
    public LaneStandard(int numberStraightLights,
                        StraightTrafficLightBehaviour straightLightBehaviour,
                        Location location,
                        int straightGoDurationLeft,
                        int straightCycleTimeLeft) {

        this.changeStraightLaneController(
                numberStraightLights,
                straightLightBehaviour,
                location,
                straightGoDurationLeft,
                straightCycleTimeLeft
        );
    }

    /**
     * Change straight lane controller.
     *
     * @param numberLights   the number lights
     * @param lightBehaviour the light behaviour
     * @param location       the location
     * @param goDuration     the go duration
     * @param cycleTime      the cycle time
     */
    public void changeStraightLaneController(int numberLights,
                                             StraightTrafficLightBehaviour lightBehaviour,
                                             Location location,
                                             int goDuration,
                                             int cycleTime) {
        this.straightLaneControllerStandard = new StraightLaneControllerStandard(
                numberLights,
                lightBehaviour,
                location,
                goDuration,
                cycleTime);
    }

    public StraightLaneControllerStandard getStraightLaneController() {
        return straightLaneControllerStandard;
    }

    @Override
    public void cycleStraightLights() throws InterruptedException {
        this.straightLaneControllerStandard.cycleLights();
    }


}
