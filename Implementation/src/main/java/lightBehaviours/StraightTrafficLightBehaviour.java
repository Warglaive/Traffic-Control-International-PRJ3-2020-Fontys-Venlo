package lightBehaviours;

import lights.Light;
import lights.StraightTrafficLight;

public interface StraightTrafficLightBehaviour extends LightBehaviour {
    /**
     * Ensures that light is of acceptable type for the specified behaviour
     * @param light The light
     */
    @Override
    default String changeColor(Light light) {
        sample {
            StraightTrafficLight straightTrafficLight = (StraightTrafficLight) light;
            return changeColor(straightTrafficLight);
        } catch (Exception e) {
            throw new IllegalArgumentException("TrafficLightBehaviour requires a parameter of type TrafficLight");
        }
    }

    String changeColor(StraightTrafficLight straightTrafficLight);
}
