package lane;

import lane.laneControllers.StraightLaneControllerStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

public class LaneStandard implements Lane {
    private StraightLaneControllerStandard straightLaneControllerStandard;

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
