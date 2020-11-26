package crossings;

import lane.Lane;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;
import ui.UIOutput;

public abstract class FourWayCrossingControllerEntrance {
    private Lane leftLane;

    public FourWayCrossingControllerEntrance(
            int numberStraightLightsLeft,
            StraightTrafficLightBehaviour straightLightBehaviour,
            UIOutput userInterface,
            Location location) {

        this.changeLeftLane(numberStraightLightsLeft,
        straightLightBehaviour,
        userInterface,
        location);

    }

    public abstract void changeLeftLane(
            int numberStraightLights,
            StraightTrafficLightBehaviour straightLightBehaviour,
            UIOutput userInterface,
            Location location
    );


    public void setLeftLane(Lane leftLane) {
        this.leftLane = leftLane;
    }

    public Lane getLeftLane() {
        return leftLane;
    }
}
