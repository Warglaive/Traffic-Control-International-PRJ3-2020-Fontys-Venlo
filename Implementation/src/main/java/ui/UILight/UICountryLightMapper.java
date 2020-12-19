package ui.UILight;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

/*
The purpose of this class is to take a country string and return a definiton for the traffic light
 */
public class UICountryLightMapper {


    private static Color green = Color.GREEN;
    private static Color red = Color.RED;
    private static Color yellow = Color.YELLOW;
    //TODO use transparent instead of black
    private static Color black = Color.BLACK;

    private Color[] greenLightRepresentation = {black, black, green};
    private Color[] yellowLightRepresentation = {black, yellow, black};
    private Color[] redLightRepresentation = {red, black, black};
    private Color[] redYellowLightRepresentation = {red, yellow, black};

    private Color[] pedestrianRedLightRepresentation = {red, black};
    private Color[] pedestrianGreenLightRepresentation = {black, green};

    private Map<String, Color[]> germanMap;
    private Map<String, Color[]> dutchMap;

    /*
    Returns a Map with the different Color Arrays represent in Germany.
    The idea is that you can iterate through the map and retrieve a Color Array of the current state
     */
    public Map<String, Color[]> germanLightMap() {
        var germanMap = new HashMap();
        germanMap.put("redLightRepresentation", redLightRepresentation);
        germanMap.put("redYellowLightRepresentation", redYellowLightRepresentation);
        germanMap.put("yellowLightRepresentation", yellowLightRepresentation);
        germanMap.put("greenLightRepresentation", greenLightRepresentation);
        return germanMap;
    }

    /*
    Returns a Map with the different Color Arrays represent in the Netherlands.
    The idea is that you can iterate through the map and retrieve a Color Array of the current state
     */
    public Map<String, Color[]> dutchLightMap() {
        var dutchMap = new HashMap();
        dutchMap.put("redLightRepresentation", redLightRepresentation);
        dutchMap.put("yellowLightRepresentation", yellowLightRepresentation);
        dutchMap.put("greenLightRepresentation", greenLightRepresentation);
        return dutchMap;
    }

    /*
    Returns a Map with the different Color Arrays represent in Germany.
    The idea is that you can iterate through the map and retrieve a Color Array of the current state
     */
    public Map<String, Color[]> pedestrianStandardLightMap() {
        var pedestrianStandardMap = new HashMap();
        pedestrianStandardMap.put("pedestrianRedLightRepresentation", pedestrianRedLightRepresentation);
        pedestrianStandardMap.put("pedestrianGreenLightRepresentation", pedestrianGreenLightRepresentation);
        return pedestrianStandardMap;
    }

    public Color[] getAllTransparent() {

        Color[] transparent = {black, black, black};
        return transparent;
    }
}
