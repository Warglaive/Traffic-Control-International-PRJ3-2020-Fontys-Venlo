package crossings;

import crossings.FourWayCrossingControllerEntrance;
import lane.Lane;
import lane.LaneStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIObserver;
import ui.UIOutput;

public class FourWayCrossingControllerEntranceStandard extends FourWayCrossingControllerEntrance {
    public FourWayCrossingControllerEntranceStandard(int numberStraightLightsLeft,
                                                     StraightTrafficLightBehaviour straightLightBehaviour,
                                                     Location location,
                                                     int straightGoDurationLeft,
                                                     int straightCycleTimeLeft) {
        super(numberStraightLightsLeft, straightLightBehaviour, location, straightGoDurationLeft, straightCycleTimeLeft);
    }

    @Override
    public void changeLeftLane(int numberStraightLights,
                               StraightTrafficLightBehaviour straightLightBehaviour,
                               Location location,
                               int straightGoDurationLeft,
                               int straightCycleTimeLeft) {
        Lane newLane = new LaneStandard(
                numberStraightLights,
                straightLightBehaviour,
                location,
                straightGoDurationLeft,
                straightCycleTimeLeft
        );

        super.setLeftLane(newLane);
    }
}
