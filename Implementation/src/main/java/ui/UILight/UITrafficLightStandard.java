package ui.UILight;

import lights.ObserverLight;

public abstract class UITrafficLightStandard extends UITrafficLightObserver {

    public UITrafficLightStandard(ObserverLight businessLight, Country country) {
        super(businessLight, country);
    }
}
