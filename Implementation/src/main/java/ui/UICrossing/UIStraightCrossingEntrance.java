package ui.UICrossing;

import crossings.parameterEnums.LaneControllerType;
import javafx.scene.shape.Circle;
import ui.UILane.UiLane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;

public class UIStraightCrossingEntrance extends UIStraightCrossing {
    protected UiLane leftLane, rightLane;
    private Map<String, Object> namespace;

    /**
     * Create the UiLanes required for the UiCrossing.
     * @param namespace A map with all JavaFx components mapped to Strings as keys.
     */
    public UIStraightCrossingEntrance(Map<String, Object> namespace) {
        this.namespace = namespace;
    }

    /**
     * Create a map containing the javafx representation of trafficLights.
     * @param trafficLightIdentifier The unique identifying String part in the circles ID for traffic lights. (Circles represent light bulbs).
     * @param pedestrianLightIdentifier The unique identifying String parts in the circles ID for pedestrian lights. (Circles represent light bulbs).
     * @return A Map with Circles mapped to corresponding lightType.
     */
    Map<LaneControllerType, List<Map<String, Circle>>> mapTrafficCircles(String trafficLightIdentifier, String pedestrianLightIdentifier) {
        var laneMap = new HashMap();
        laneMap.put(STRAIGHT, mapStraightCircles(trafficLightIdentifier));
        laneMap.put(PEDESTRIAN, mapPedestrianCircles(pedestrianLightIdentifier));

        return laneMap;
    }

    /**
     * Prepare the fetching of pedestrianCircles with the given identifiers.
     * @param pedestrianLightIdentifier The unique identifying String parts in the circles ID for pedestrian lights. (Circles represent light bulbs).
     * @return A map with circles representing pedestrian lights.
     */
    private List<Map<String, Circle>> mapPedestrianCircles(String pedestrianLightIdentifier) {

        var separatedIdentifier = pedestrianLightIdentifier.split(",");
        String[] position = {"top", "bottom"};
        int[] identifierForCircles = {1, 2};
        var baseIdentifier = "FourW_PL" + separatedIdentifier[0] + "_Circle";

        var pedestrianCircleList = new ArrayList();
        pedestrianCircleList.add(mapCirclesStringX(baseIdentifier, position, identifierForCircles));

        baseIdentifier = "FourW_PL" + separatedIdentifier[1] + "_Circle";
        pedestrianCircleList.add(mapCirclesStringX(baseIdentifier, position, identifierForCircles));
        return pedestrianCircleList;
    }

    /**
     * Prepare the fetching of straightCircles with the given identifier.
     * @param straightLightIdentifier The unique identifying String part in the circles ID for straight lights. (Circles represent light bulbs).
     * @return A map with circles representing straight lights.
     */
    private List<Map<String, Circle>> mapStraightCircles(String straightLightIdentifier) {
        String[] position = {"top", "middle", "bottom"};
        int[] identifierForCircle = {1, 2, 3};
        String baseIdentifier = "FourW_TL" + straightLightIdentifier + "_Circle";
        var returnList = new ArrayList();

        returnList.add(mapCirclesStringX(baseIdentifier, position, identifierForCircle));
        return returnList;
    }

    /**
     * Use the information given to fetch and return javafx Circles from namespace.
     * @param baseIdentifier The javafx base id for the circle (Without circle number).
     * @param position The position (top / middle) where the circle is in reference to the light.
     * @param identifierForCircle The circle number.
     * @return A map containing a Circle and its position.
     */
    private Map<String, Circle> mapCirclesStringX(
            String baseIdentifier, String[] position, int[] identifierForCircle) {
        var circleMap = new HashMap();

        for(int i = 0; i < position.length; i++) {
            circleMap.put(position[i], namespace.get(baseIdentifier + identifierForCircle[i]));
        }

        return circleMap;
    }
}
