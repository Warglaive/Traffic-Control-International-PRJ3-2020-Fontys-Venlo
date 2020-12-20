package ui.UICrossing;

import crossings.parameterEnums.LaneControllerType;
import javafx.scene.shape.Circle;
import lane.Lane;
import ui.UILane.UiLane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;

public class UIFourWayCrossingEntrance extends UIFourWayCrossing {
    private UiLane leftLane;
    private UiLane rightLane;
    private UiLane topLane;
    private UiLane bottomLane;

    /**
     * Create the UiLanes required for the UiCrossing.
     * @param leftLane BusinessLane for left lane.
     * @param rightLane BusinessLane for right lane.
     * @param topLane BusinessLane for top lane.
     * @param bottomLane BusinessLane for bottom lane.
     * @param namespace A map with all JavaFx components mapped to Strings as keys.
     */
    public UIFourWayCrossingEntrance(Lane leftLane, Lane rightLane, Lane topLane, Lane bottomLane, Map<String, Object> namespace) {

        this.leftLane = new UiLane(leftLane, mapTrafficCircles(namespace, "LL", "LT,LB" ));
        this.rightLane = new UiLane(rightLane, mapTrafficCircles(namespace, "RL", "RT,RB"));
        this.topLane = new UiLane(topLane, mapTrafficCircles(namespace, "TL", "TL,TR"));
        this.bottomLane = new UiLane(bottomLane, mapTrafficCircles(namespace, "BL", "BL,BR"));
    }

    /**
     * Create a map containing the javafx representation of trafficLights.
     * @param namespace A map with all JavaFx components mapped to Strings as keys.
     * @param trafficLightIdentifier The unique identifying String part in the circles ID for traffic lights. (Circles represent light bulbs).
     * @param pedestrianLightIdentifier The unique identifying String parts in the circles ID for pedestrian lights. (Circles represent light bulbs).
     * @return A Map with Circles mapped to corresponding lightType.
     */
    private Map<LaneControllerType, List<Map<String, Circle>>> mapTrafficCircles(Map<String, Object> namespace, String trafficLightIdentifier, String pedestrianLightIdentifier) {
        var laneMap = new HashMap();
        laneMap.put(STRAIGHT, mapStraightCircles(namespace, trafficLightIdentifier));
        laneMap.put(PEDESTRIAN, mapPedestrianCircles(namespace, pedestrianLightIdentifier));

        return laneMap;
    }

    /**
     * Prepare the fetching of pedestrianCircles with the given identifiers.
     * @param namespace A map with all JavaFx components mapped to Strings as keys.
     * @param pedestrianLightIdentifier The unique identifying String parts in the circles ID for pedestrian lights. (Circles represent light bulbs).
     * @return A map with circles representing pedestrian lights.
     */
    private List<Map<String, Circle>> mapPedestrianCircles(Map<String, Object> namespace, String pedestrianLightIdentifier) {
        // Separate the identifier String into the single identifiers
        var separatedIdentifier = pedestrianLightIdentifier.split(",");
        // Save the positions pedestrian lights have
        String[] position = {"top", "bottom"};
        // The amount of circles per pedestrian lights
        int[] identifierForCircles = {1, 2};
        // Create the String that represents the full id besides the circle number
        var baseIdentifier = "FourW_PL" + separatedIdentifier[0] + "_Circle";

        // Map pedestrian lights on one side of the road
        var pedestrianCircleList = new ArrayList();
        pedestrianCircleList.add(mapCirclesStringX(namespace, baseIdentifier, position, identifierForCircles));

        // Create the String that represents the full id besides the circle number
        baseIdentifier = "FourW_PL" + separatedIdentifier[1] + "_Circle";
        // Map pedestrianLights on the other side of the road
        pedestrianCircleList.add(mapCirclesStringX(namespace, baseIdentifier, position, identifierForCircles));


        return pedestrianCircleList;
    }

    /**
     * Prepare the fetching of straightCircles with the given identifier.
     * @param namespace A map with all JavaFx components mapped to Strings as keys.
     * @param straightLightIdentifier The unique identifying String part in the circles ID for straight lights. (Circles represent light bulbs).
     * @return A map with circles representing straight lights.
     */
    private List<Map<String, Circle>> mapStraightCircles(Map<String, Object> namespace, String straightLightIdentifier) {
        // For extensive commenting see mapPedestrianCircles()
        String[] position = {"top", "middle", "bottom"};
        int[] identifierForCircle = {1, 2, 3};
        String baseIdentifier = "FourW_TL" + straightLightIdentifier + "_Circle";
        var returnList = new ArrayList();

        returnList.add(mapCirclesStringX(namespace, baseIdentifier, position, identifierForCircle));
        return returnList;

    }

    /**
     * Use the information given to fetch and return javafx Circles from namespace.
     * @param namespace A map with all JavaFx components mapped to Strings as keys.
     * @param baseIdentifier The javafx base id for the circle (Without circle number).
     * @param position The position (top / middle) where the circle is in reference to the light.
     * @param identifierForCircle The circle number.
     * @return A map containing a Circle and its position.
     */
    private Map<String, Circle> mapCirclesStringX(
            Map<String, Object> namespace, String baseIdentifier, String[] position, int[] identifierForCircle) {
        var circleMap = new HashMap();

        for(int i = 0; i < position.length; i++) {
            circleMap.put(position[i], namespace.get(baseIdentifier + identifierForCircle[i]));
        }

        return circleMap;
    }
}
