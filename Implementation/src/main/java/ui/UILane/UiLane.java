package ui.UILane;

import lane.Lane;
import lane.laneControllers.LaneController;
import lights.Light;
import lights.ObserverLight;
import ui.UILight.UIPedestrianLight;
import ui.UILight.UITrafficLight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UiLane {
/*
    private UITrafficLight trafficLight;
    private UIPedestrianLight pedestrianLightOne;
    private UIPedestrianLight pedestrianLightTwo;

    public UiLane(UITrafficLight tLight, UIPedestrianLight pLight){
        this.trafficLight = tLight;
        this.pedestrianLightOne = pLight;
        this.pedestrianLightTwo = pLight;
    }*/

    private Lane businessLogicLane;
    private HashMap<String, List<Light>> lights;

    public UiLane(Lane businessLogicLane) {
        this.businessLogicLane = businessLogicLane;
        this.lights = new HashMap<String, List<Light>>();

        this.fetchStraightLights(businessLogicLane);
    }

    private void fetchStraightLights(Lane lane) {
        var laneController = lane.getStraightLaneController();

        var tempList = new ArrayList();
        for(var businessLogicLightAsObject : laneController.getLights()) {
            try {
                var businessLogicLight = (Light) businessLogicLightAsObject;
                var uiTrafficLight = new UITrafficLight(businessLogicLight);
                tempList.add(uiTrafficLight);

            } catch (ClassCastException cce) {
                //TODO: Proper exception handling
            }
        }

        lights.put("straightLights", tempList);
    }

    public List<Light> getStraightLights() {
        return lights.get("straightLights");
    }
}
