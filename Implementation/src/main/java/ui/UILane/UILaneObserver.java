package ui.UILane;

import crossings.parameterEnums.LaneControllerType;
import javafx.scene.shape.Circle;
import lane.Lane;
import lights.observer.ObserverLight;
import ui.Controller.ThreeLightsRepresentation;
import ui.Controller.TwoLightsRepresentation;
import ui.UILight.Country;
import ui.UILight.PedestrianLights.UIPedestrianLightObserverStandard;
import ui.UILight.TrafficLights.UITrafficLightObserverStandard;
import ui.UILight.UiLightType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UILaneObserver extends UiLane{

    /**
     * Create UILaneObserver instance.
     * @param businessLogicLane A lane that is used to fetch business logic lights.
     * @param circles The circles the UILights need.
     */
    public UILaneObserver(Lane businessLogicLane, Map<LaneControllerType, List<Map<String, Circle>>> circles) {
        super(businessLogicLane, circles);
    }

    /**
     * Create UITrafficLights refering to businessLights.
     * @param businessLogicLane Lane that contains businessLights.
     * @param circles The circles the UILight requires.
     */
    @Override
     void fetchStraightLights(Lane businessLogicLane, List<Map<String, Circle>> circles) {
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
        addLightToList(businessLight, UiLightType.STRAIGHTLIGHTS);
    }

    /**
     * Create UIPedestrianLights refering to businessLights.
     * @param businessLogicLane Lane that contains businessLights.
     * @param circles The circles the UILight requires.
     */
    @Override
     void fetchPedestrianLights(Lane businessLogicLane, List<Map<String, Circle>> circles) {
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
        addLightToList(businessLight, UiLightType.PEDESTRIANLIGHTS);
    }

    /**
     * Add given Lights to the lights list
     * @param businessLight A singular business light that is to be mapped to a UILight
     */
    @Override
     void addLightToList(ObserverLight businessLight, UiLightType lightType) {
        var tempList = new ArrayList();
        tempList.add(businessLight);

        lights.put(lightType, tempList);
    }
}
