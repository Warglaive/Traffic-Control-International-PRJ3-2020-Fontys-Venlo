package ui.UILight.TrafficLights;

import lights.ObserverLight;
import ui.Controller.TrafficLightRepresentation;
import ui.UILight.Country;

public abstract class UITrafficLightStandard extends UITrafficLightObserver {

    public UITrafficLightStandard(ObserverLight businessLight, Country country, TrafficLightRepresentation trafficLightRepresentation) {

        super(businessLight, country, trafficLightRepresentation);
    }
}
