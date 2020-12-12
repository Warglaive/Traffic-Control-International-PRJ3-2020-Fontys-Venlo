package ui.UILight.PedestrianLights;

import lights.ObserverLight;
import ui.UILight.Country;

public class UIPedestrianLightObserverStandard extends UIPedestrianLightObserver {

    public UIPedestrianLightObserverStandard(ObserverLight businessLight, Country country, PedestrianLightRepresentation pedestrianLightRepresentation) {
        super(businessLight, country, pedestrianLightRepresentation);
    }
}
