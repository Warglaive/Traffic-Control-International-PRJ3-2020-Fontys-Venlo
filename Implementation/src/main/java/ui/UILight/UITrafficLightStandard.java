package ui.UILight;

import lights.ObserverLight;
import ui.Controller.TrafficLightRepresentation;

public abstract class UITrafficLightStandard extends UITrafficLightObserver {

    public UITrafficLightStandard(ObserverLight businessLight, Country country, TrafficLightRepresentation trafficLightRepresentation) {

        super(businessLight, country, trafficLightRepresentation);
    }
}
