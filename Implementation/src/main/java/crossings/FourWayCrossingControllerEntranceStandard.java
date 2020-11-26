package crossings;

import crossings.FourWayCrossingControllerEntrance;
import lane.Lane;
import lane.LaneStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIObserver;
import ui.UIOutput;

public class FourWayCrossingControllerEntranceStandard extends FourWayCrossingControllerEntrance {
    public FourWayCrossingControllerEntranceStandard(int numberStraightLightsLeft, StraightTrafficLightBehaviour straightLightBehaviour, UIObserver userInterface, Location location) {
        super(numberStraightLightsLeft, straightLightBehaviour, userInterface, location);
    }

    @Override
    public void changeLeftLane(int numberStraightLights, StraightTrafficLightBehaviour straightLightBehaviour, UIOutput userInterface, Location location) {
        UIObserver uiObserver;
        try {
            uiObserver = (UIObserver) userInterface;
        } catch (ClassCastException e) {
            throw new ClassCastException("The userInterface has to be of type UIObserver");
        }

        Lane newLane = new LaneStandard(
                numberStraightLights,
                straightLightBehaviour,
                uiObserver,
                location
        );

        super.setLeftLane(newLane);
    }
}
