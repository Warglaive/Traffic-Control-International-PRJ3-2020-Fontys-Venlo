package ui.UILight.PedestrianLights;

import lights.ObserverLight;
import ui.Controller.TwoLightsRepresentation;
import ui.UILight.Country;

public class UIPedestrianLightObserverStandard extends UIPedestrianLightObserver {

    public UIPedestrianLightObserverStandard(ObserverLight businessLight, Country country, TwoLightsRepresentation pedestrianLightRepresentation) {
        super(businessLight, country, pedestrianLightRepresentation);
    }
}
