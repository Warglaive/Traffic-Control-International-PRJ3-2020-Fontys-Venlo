package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIObserver;
import ui.UIOutput;

public class FourWayCrossingEntranceStandard extends FourWayCrossingEntrance {
    public FourWayCrossingEntranceStandard(int numberStraightLightsLeft,
                                           StraightTrafficLightBehaviour straightLightBehaviour,
                                           Location location,
                                           int straightGoDurationLeft,
                                           int straightCycleTimeLeft) {
        super(numberStraightLightsLeft, straightLightBehaviour, location, straightGoDurationLeft, straightCycleTimeLeft);
    }

    @Override
    public void changeController(int numberStraightLightsLeft,
                                 StraightTrafficLightBehaviour straightLightBehaviour,
                                 Location location,
                                 int straightGoDurationLeft,
                                 int straightCycleTimeLeft) {

        FourWayCrossingControllerEntranceStandard crossingController = new FourWayCrossingControllerEntranceStandard(
                numberStraightLightsLeft,
                straightLightBehaviour,
                location,
                straightGoDurationLeft,
                straightCycleTimeLeft
        );

        super.setController(crossingController);
    }
}
