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
    private Color[] redyellowLightrepresentation = {red, yellow, black};

    private static Color green = new Color(0,255,0,255);
    private static Color red = new Color(255, 0, 0, 255);
    private static Color yellow = new Color(255, 255, 0, 255);
    //TODO use transparent instead of black
    private static Color black = new Color(0,0,0,255);

    private Map<Integer, Color[]> germanMap;
    private Map<Integer, Color[]> dutchMap;

    /*
    Returns a Map with the different Color Arrays represent in Germany.
    The idea is that you can iterate through the map and retrieve a Color Array of the current state
     */
    public Map<Integer,Color[]> germanLight(){

        germanMap.put(1,redLightRepresentation);
        germanMap.put(2,redyellowLightrepresentation);
        germanMap.put(3,yellowLightRepresentation);
        germanMap.put(4, greenLightRepresentation);
        return germanMap;
    }
}
