package ui.UILight.TrafficLights;

import lights.ObserverLight;
import ui.Controller.ThreeLightRepresentation;
import ui.UILight.Country;

public abstract class UITrafficLightStandard extends UITrafficLightObserver {

    public UITrafficLightStandard(ObserverLight businessLight, Country country, ThreeLightRepresentation threeLightRepresentation) {

        super(businessLight, country, threeLightRepresentation);
    }
}
