package ui.UILight.TrafficLights;

import lights.observerLights.ObserverLight;
import ui.Controller.ThreeLightsRepresentation;
import ui.UILight.Country;

public abstract class UITrafficLightStandard extends UITrafficLightObserver {

    public UITrafficLightStandard(ObserverLight businessLight, Country country, ThreeLightsRepresentation threeLightsRepresentation) {

        super(businessLight, country, threeLightsRepresentation);
    }
}
