package ui.UILane;

import crossings.LaneControllerType;
import javafx.scene.shape.Circle;
import lane.Lane;
import lane.laneControllers.LaneController;
import lights.Light;
import lights.ObserverLight;
import ui.Controller.LightRepresentation;
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

    public UiLane(Lane businessLogicLane, Map<LaneControllerType, Map<String, Circle>> circles) {
        this.businessLogicLane = businessLogicLane;
        this.lights = new HashMap<UiLightType, List<Light>>();

        this.fetchStraightLights(businessLogicLane, circles.get(LaneControllerType.STRAIGHT));
        this.fetchPedestrianLights(businessLogicLane, circles.get(LaneControllerType.PEDESTRIAN));
    }

    private void fetchStraightLights(Lane businessLogicLane, Map<String, Circle> circles) {
        var laneController = businessLogicLane.getStraightLaneController();
        var businessLight = (ObserverLight) laneController.getLights().get(0);
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

        addLightToList(businessLight);
    }
    private void fetchPedestrianLights(Lane businessLogicLane, Map<String, Circle> circles) {
        var laneController = businessLogicLane.getPedestrianLaneController();
        var businessLight = (ObserverLight) laneController.getLights().get(0);
        var lightRepresentation = new TwoLightsRepresentation(
                circles.get("top"),
                circles.get("bottom")
        );

        //TODO: Actual country translation
        new UIPedestrianLightObserverStandard(
                businessLight,
                Country.GERMANY,
                lightRepresentation
        );

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
