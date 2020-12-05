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
            Location location,
            int straightGoDuration,
            int straightCycleTime) {

        this.changeLeftLane(numberStraightLightsLeft,
                straightLightBehaviour,
                location,
                straightGoDuration,
                straightCycleTime);

    }

    public abstract void changeLeftLane(
            int numberStraightLights,
            StraightTrafficLightBehaviour straightLightBehaviour,
            Location location,
            int straightGoDuration,
            int straightCycleTime
    );


    public void setLeftLane(Lane leftLane) {
        this.leftLane = leftLane;
    }

    public Lane getLeftLane() {
        return leftLane;
    }
}
