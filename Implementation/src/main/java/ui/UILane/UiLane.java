package ui.UILane;

import crossings.parameterEnums.LaneControllerType;
import javafx.scene.shape.Circle;
import lane.Lane;
import lights.Light;
import lights.observer.ObserverLight;
import ui.Controller.ThreeLightsRepresentation;
import ui.Controller.TwoLightsRepresentation;
import ui.UILight.Country;
import ui.UILight.PedestrianLights.UIPedestrianLightObserverStandard;
import ui.UILight.TrafficLights.UITrafficLightObserverStandard;
import ui.UILight.UiLightType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UiLane {
    private Lane businessLogicLane;
    private HashMap<UiLightType, List<Light>> lights;

    public UiLane(Lane businessLogicLane, Map<LaneControllerType, List<Map<String, Circle>>> circles) {
        this.businessLogicLane = businessLogicLane;
        this.lights = new HashMap<UiLightType, List<Light>>();

        this.fetchStraightLights(businessLogicLane, circles.get(LaneControllerType.STRAIGHT));
        this.fetchPedestrianLights(businessLogicLane, circles.get(LaneControllerType.PEDESTRIAN));
    }

    private void fetchStraightLights(Lane businessLogicLane, List<Map<String, Circle>> circles) {
        var laneController = businessLogicLane.getStraightLaneController();
        var businessLight = (ObserverLight) laneController.getLights().get(0);

        for(var circleMap : circles) {
            var lightRepresentation = new ThreeLightsRepresentation(
                    circleMap.get("top"),
                    circleMap.get("middle"),
                    circleMap.get("bottom")
            );

            //TODO: Actual country translation
            new UITrafficLightObserverStandard(
                    businessLight,
                    Country.GERMANY,
                    lightRepresentation
            );
        }
        addLightToList(businessLight);
    }
    private void fetchPedestrianLights(Lane businessLogicLane, List<Map<String, Circle>> circles) {
        var laneController = businessLogicLane.getPedestrianLaneController();
        var businessLight = (ObserverLight) laneController.getLights().get(0);
        for(var circleMap : circles) {
            var lightRepresentation = new TwoLightsRepresentation(
                    circleMap.get("top"),
                    circleMap.get("bottom")
            );

            //TODO: Actual country translation
            new UIPedestrianLightObserverStandard(
                    businessLight,
                    Country.GERMANY,
                    lightRepresentation
            );
        }
        addLightToList(businessLight);
    }

    private void addLightToList(ObserverLight businessLight) {
        var tempList = new ArrayList();
        tempList.add(businessLight);

        lights.put(UiLightType.STRAIGHTLIGHTS, tempList);
    }

    public List<Light> getStraightLights() {
        return lights.get(UiLightType.STRAIGHTLIGHTS);
    }
}
