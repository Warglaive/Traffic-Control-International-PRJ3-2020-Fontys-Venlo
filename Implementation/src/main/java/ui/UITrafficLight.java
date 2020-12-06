package ui;

import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.*;

public class UITrafficLight implements UILight, Observer {

    //contains the desired color as a value and connects it to the representation
    private HashMap<String, Color[]> state;

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
    public Color[] getColorArray(String color) {

        Color[] returnValue = null;

        Set set = state.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {

            Map.Entry mentry = (Map.Entry)iterator.next();
            if(mentry.getKey() == color){
                returnValue = (Color[]) mentry.getValue();
            }
        }
        return  returnValue;
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            Map<CirclePosition, Map<UILightBehaviour, Color>> mappedColorsWithPosition = this.mapColorsToCountry((String) arg);

            for(var circlePosition : mappedColorsWithPosition.keySet()) {
                var mappedColors = mappedColorsWithPosition.get(circlePosition);

                switch(circlePosition){
                    case TOP:
                        this.setCircleTop(mappedColors);
                    case MIDDLE:
                        this.setCircleMiddle(mappedColors);
                    case BOTTOM:
                        this.setCircleBottom(mappedColors);
                }
            }

        } catch (ColorNotFoundException e) {
            //TODO: Proper exception handling
        }
    }
}
