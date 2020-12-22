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

public abstract class UiLane {
    private Lane businessLogicLane;
    protected Map<UiLightType, List<lights.Light>> lights;

    /**
     * Create UILane instance.
     * @param businessLogicLane A lane that is used to fetch business logic lights.
     * @param circles The circles the UILights need.
     */
    public UiLane(Lane businessLogicLane, Map<LaneControllerType, List<Map<String, Circle>>> circles) {
        this.businessLogicLane = businessLogicLane;
        this.lights = new HashMap<UiLightType, List<lights.Light>>();

        this.fetchStraightLights(businessLogicLane, circles.get(LaneControllerType.STRAIGHT));
        this.fetchPedestrianLights(businessLogicLane, circles.get(LaneControllerType.PEDESTRIAN));
    }

    /**
     * Create UITrafficLights refering to businessLights.
     * @param businessLogicLane Lane that contains businessLights.
     * @param circles The circles the UILight requires.
     */
    abstract void fetchStraightLights(Lane businessLogicLane, List<Map<String, Circle>> circles);

    /**
     * Create UIPedestrianLights refering to businessLights.
     * @param businessLogicLane Lane that contains businessLights.
     * @param circles The circles the UILight requires.
     */
    abstract void fetchPedestrianLights(Lane businessLogicLane, List<Map<String, Circle>> circles);

    /**
     * Add given Lights to the lights list
     * @param businessLight A singular business light that is to be mapped to a UILight
     */
    abstract void addLightToList(ObserverLight businessLight, UiLightType lightType);

    /**
     * Return saved straight business lights
     * @return A List of business lights
     */
    public List<lights.Light> getStraightLights() {
        return lights.get(UiLightType.STRAIGHTLIGHTS);
    }

    /**
     * Return saved pedestrian business lights
     * @return A List of business lights
     */
    public List<Light> getPedestrianLights() { return lights.get(UiLightType.PEDESTRIANLIGHTS); }
}
