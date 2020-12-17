package lightBehaviours;

import lights.observer.ObserverLight;
import lights.observer.StraightTrafficObserverLight;

/**
 * The interface Straight traffic light behaviour.
 */
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

    /**
     * Change color string.
     *
     * @param straightTrafficLight the straight traffic light
     * @return the string
     */
    String changeColor(StraightTrafficObserverLight straightTrafficLight);
}
