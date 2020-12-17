package lightBehaviours;

import lights.observerLights.ObserverLight;
import lights.observerLights.PedestrianObserverLight;

public interface PedestrianLightBehaviour extends LightBehaviour{
    /**
     * Ensures that light is of acceptable type for the specified behaviour
     * @param observerLight The light
     */
    @Override
    default String changeColor(ObserverLight observerLight) {
        try {
            PedestrianObserverLight pedestrianLight = (PedestrianObserverLight) observerLight;
            return changeColor(pedestrianLight);
        } catch (Exception e) {
            throw new IllegalArgumentException("PedestrianLightBehaviour requires a parameter of type PedestrianLight");
        }
    }

    String changeColor(PedestrianObserverLight pedestrianLight);
}

