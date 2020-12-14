package ui.UILane;

import javafx.scene.shape.Circle;
import lane.Lane;
import lights.Light;
import lights.ObserverLight;
import ui.Controller.ThreeLightsRepresentation;
import ui.UILight.Country;
import ui.UILight.TrafficLights.UITrafficLightObserverStandard;
import ui.UILight.UiLightType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UiLane {
    private Lane businessLogicLane;
    private HashMap<UiLightType, List<Light>> lights;

    public UiLane(Lane businessLogicLane, Map<String, Circle> circles) {
        this.businessLogicLane = businessLogicLane;
        this.lights = new HashMap<UiLightType, List<Light>>();

        this.fetchStraightLights(businessLogicLane, circles);
    }

    //TODO: only works for one UI representation light
    private void fetchStraightLights(Lane businessLogicLane, Map<String, Circle> circles) {
        var laneController = businessLogicLane.getStraightLaneController();
        var businessLight = (ObserverLight) laneController.getLights().get(0);

        var tempList = new ArrayList();
        tempList.add(businessLight);

        var lightRepresentation = new ThreeLightsRepresentation(
                circles.get("top"),
                circles.get("middle"),
                circles.get("bottom")
        );

        //TODO: Actual country translation
        new UITrafficLightObserverStandard(
                businessLight,
                Country.GERMANY,
                lightRepresentation
        );

        /*for(var businessLogicLightAsObject : laneController.getLights()) {
            try {
                var businessLogicLight = (Light) businessLogicLightAsObject;
                //TODO: Extendible structure / create correct traffic light
               // var uiTrafficLight = new UITrafficLight(businessLogicLight);
               // tempList.add(uiTrafficLight);

            } catch (ClassCastException cce) {
                //TODO: Proper exception handling
            }
        }*/

        lights.put(UiLightType.STRAIGHTLIGHTS, tempList);
    }

    public List<Light> getStraightLights() {
        return lights.get(UiLightType.STRAIGHTLIGHTS);
    }
}
