package ui.UILight.TrafficLights;

import lights.observer.ObserverLight;
import ui.Controller.ThreeLightsRepresentation;
import ui.UILight.Country;

public class UITrafficLightObserverStandard extends UITrafficLightObserver{
    public UITrafficLightObserverStandard(ObserverLight businessLight, Country country, ThreeLightsRepresentation threeLightsRepresentation) {
        super(businessLight, country, threeLightsRepresentation);
    }
}
