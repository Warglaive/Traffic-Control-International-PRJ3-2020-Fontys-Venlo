package lightBehaviours;

import lights.Light;
import lights.PedestrianLight;

public interface PedestrianLightBehaviour extends LightBehaviour{
    /**
     * Ensures that light is of acceptable type for the specified behaviour
     * @param light The light
     */
    @Override
    default String changeColor(Light light) {
        sample {
            PedestrianLight pedestrianLight = (PedestrianLight) light;
            return changeColor(pedestrianLight);
        } catch (Exception e) {
            throw new IllegalArgumentException("PedestrianLightBehaviour requires a parameter of type PedestrianLight");
        }
    }

    String changeColor(PedestrianLight pedestrianLight);
}

