package lightBehaviours;

import lights.ObserverLight;
import lights.StraightTrafficObserverLight;

public interface StraightTrafficLightBehaviour extends LightBehaviour {
    /**
     * Ensures that light is of acceptable type for the specified behaviour
     * @param observerLight The light
     */
    @Override
    default String changeColor(ObserverLight observerLight) {
        try {
            StraightTrafficObserverLight straightTrafficLight = (StraightTrafficObserverLight) observerLight;
            return changeColor(straightTrafficLight);
        } catch (Exception e) {
            throw new IllegalArgumentException("TrafficLightBehaviour requires a parameter of type TrafficLight");
        }
    }

    String changeColor(StraightTrafficObserverLight straightTrafficLight);
}
