package ui;

import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.HashMap;

public class UITrafficLight implements UILight {

    //contains the desired color as a value and connects it to the representation
    private HashMap state;

    // The arrays represent the three lights and there state as colors from top to bottom.
    private Color[] greenLightRepresentation = {black, black, green};
    private Color[] yellowLightRepresentation = {black, yellow, black};
    private Color[] redLightRepresentation = {red, black, black};
    private Color[] redyellowLightrepresentation = {red, yellow, black};
    private static Color green = new Color(0,255,0,255);
    private static Color red = new Color(255, 0, 0, 255);
    private static Color yellow = new Color(255, 255, 0, 255);
    private static Color black = new Color(0,0,0,255);

    public UITrafficLight(){

        state.put("red", redLightRepresentation);
        state.put("yellow", yellowLightRepresentation);
        state.put("green", greenLightRepresentation);
        state.put("redyellow", redyellowLightrepresentation);
    }

    @Override
    public String changeColor(String color) {


        return null;
    }
}
