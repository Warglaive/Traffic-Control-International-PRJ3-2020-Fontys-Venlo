package lightBehaviours;

import lights.observer.ObserverLight;
import lights.observer.PedestrianObserverLight;

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

