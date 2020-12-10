package ui.UILane;

import lane.Lane;
import lights.Light;
import ui.UILight.UiLightType;
import ui.UILight.UITrafficLight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UiLane {
    private Lane businessLogicLane;
    private HashMap<UiLightType, List<Light>> lights;

    public UiLane(Lane businessLogicLane) {
        this.businessLogicLane = businessLogicLane;
        this.lights = new HashMap<UiLightType, List<Light>>();

        this.fetchStraightLights(businessLogicLane);
    }

    private void fetchStraightLights(Lane businessLogicLane) {
        var laneController = businessLogicLane.getStraightLaneController();
        var tempList = new ArrayList();

        for(var businessLogicLightAsObject : laneController.getLights()) {
            try {
                var businessLogicLight = (Light) businessLogicLightAsObject;
                //TODO: Extendible structure / create correct traffic light
               // var uiTrafficLight = new UITrafficLight(businessLogicLight);
               // tempList.add(uiTrafficLight);

            } catch (ClassCastException cce) {
                //TODO: Proper exception handling
            }
        }

        lights.put(UiLightType.STRAIGHTLIGHTS, tempList);
    }

    public List<Light> getStraightLights() {
        return lights.get(UiLightType.STRAIGHTLIGHTS);
    }
}
