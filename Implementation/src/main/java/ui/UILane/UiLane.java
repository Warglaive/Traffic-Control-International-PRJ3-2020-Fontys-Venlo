package ui.UILane;

import ui.UILight.UIPedestrianLight;
import ui.UILight.UITrafficLight;

public class UiLane {

    private UITrafficLight trafficLight;
    private UIPedestrianLight pedestrianLightOne;
    private UIPedestrianLight pedestrianLightTwo;

    public UiLane(UITrafficLight tLight, UIPedestrianLight pLight){
        this.trafficLight = tLight;
        this.pedestrianLightOne = pLight;
        this.pedestrianLightTwo = pLight;
    }

}