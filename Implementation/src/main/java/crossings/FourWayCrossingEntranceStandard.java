package crossings;

import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIObserver;
import ui.UIOutput;

public class FourWayCrossingEntranceStandard extends FourWayCrossingEntrance{
    public FourWayCrossingEntranceStandard(int numberStraightLightsLeft, StraightTrafficLightBehaviour straightLightBehaviour, UIObserver userInterface, Location location) {
        super(numberStraightLightsLeft, straightLightBehaviour, userInterface, location);
    }

    @Override
    public void changeController(int numberStraightLightsLeft, StraightTrafficLightBehaviour straightLightBehaviour, UIOutput userInterface, Location location) {
        UIObserver uiObserver;
        sample {
            uiObserver = (UIObserver) userInterface;
        } catch(ClassCastException e) {
            throw new ClassCastException("The userInterface has to be of type UIObserver");
        }

        FourWayCrossingControllerEntranceStandard crossingController = new FourWayCrossingControllerEntranceStandard(
               numberStraightLightsLeft,
               straightLightBehaviour,
               uiObserver,
               location
        );

        super.setController(crossingController);
    }
}
