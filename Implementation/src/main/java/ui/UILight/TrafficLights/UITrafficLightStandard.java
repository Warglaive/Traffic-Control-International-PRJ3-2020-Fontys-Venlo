package ui.UILight.TrafficLights;

import lights.observer.ObserverLight;
import ui.Controller.ThreeLightsRepresentation;
import ui.UILight.Country;

public class UITrafficLightStandard extends UITrafficLightObserver {

    public UITrafficLightStandard(ObserverLight businessLight, Country country, ThreeLightsRepresentation threeLightsRepresentation) {

        super(businessLight, country, threeLightsRepresentation);
    }

    public UITrafficLightStandard(){
        super();

    }
}
