package ui.UILight;

import javafx.scene.paint.Color;

import java.util.Map;

/*
The purpose of this class is to take a country string and return a definiton for the traffic light
 */
public class UICountryLightMapper {

    private Color[] greenLightRepresentation = {black, black, green};
    private Color[] yellowLightRepresentation = {black, yellow, black};
    private Color[] redLightRepresentation = {red, black, black};
    private Color[] redYellowLightRepresentation = {red, yellow, black};

    private static Color green = new Color(0, 255, 0, 255);
    private static Color red = new Color(255, 0, 0, 255);
    private static Color yellow = new Color(255, 255, 0, 255);
    //TODO use transparent instead of black
    private static Color black = new Color(0, 0, 0, 255);

    private Map<String, Color[]> germanMap;
    private Map<String, Color[]> dutchMap;

    /*
    Returns a Map with the different Color Arrays represent in Germany.
    The idea is that you can iterate through the map and retrieve a Color Array of the current state
     */
    public Map<String, Color[]> germanLightMap() {

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

        dutchMap.put("redLightRepresentation", redLightRepresentation);
        dutchMap.put("yellowLightRepresentation", yellowLightRepresentation);
        dutchMap.put("greenLightRepresentation", greenLightRepresentation);
        return dutchMap;
    }

    public Color[] getAllTransparent() {

        Color[] transparent = {black, black, black};
        return transparent;
    }
}
