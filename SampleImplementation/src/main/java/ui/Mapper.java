package ui;


import Exceptions.ColorNotFoundException;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static ui.UILightBehaviour.BLINKING;
import static ui.UILightBehaviour.CONSTANT;
import static ui.CirclePosition.*;

public class Mapper {
    /**
     * This mapper translate the given String to Colors and its behaviour. Behaviour means a constant / blinking light etc.
     * @param colorString The raw String.
     * @return A map with String and behaviour.
     * @throws ColorNotFoundException When the String contains unmatched colors.
     */
    public static Map<UILightBehaviour, Color> mapToSingleColor(String colorString) throws ColorNotFoundException {
        var singleColorList = new HashMap();

        //Splits String at uppercase letter
        var colorsSplit = colorString.split("\"(?=\\p{Upper})\"");

        //Maps split up String to colors and behaviour.
        for(var currentColorString : colorsSplit) {
            switch (currentColorString.toLowerCase()) {
                case "red":
                    singleColorList.put(CONSTANT, Color.RED);
                    break;
                case "yellow":
                    singleColorList.put(CONSTANT, Color.YELLOW);
                    break;
                case "green":
                    singleColorList.put(CONSTANT, Color.GREEN);
                    break;
                case "greenblinking":
                    singleColorList.put(BLINKING, Color.GREEN);
                    break;
                default:
                    throw new ColorNotFoundException("The String contains unspecified states / colors");
            }
        }

        return singleColorList;
    }

    public static Map<CirclePosition, Map<UILightBehaviour, Color>> mapToGermanTrafficBehaviour(String colorString) throws ColorNotFoundException {
        return mapToGermanTrafficBehaviour(mapToSingleColor(colorString));
    }

    /**
     * Maps colors to traffic light positions using the german traffic light system.
     * @param colorMap A Map containing the behaviour of the traffic light and its shown colors.
     * @return colorMap, but mapped towards a traffic light position.
     */
    private static Map<CirclePosition, Map<UILightBehaviour, Color>> mapToGermanTrafficBehaviour(Map<UILightBehaviour, Color> colorMap) {
        var circleColorMap = new HashMap();

        Color currentColor;

        for(var uiLightBehaviour : colorMap.keySet()) {
            currentColor = colorMap.get(uiLightBehaviour);
            var tempMap = new HashMap();
            tempMap.put(uiLightBehaviour, currentColor);

            if (currentColor.equals(Color.RED)) {
                circleColorMap.put(TOP, tempMap);
            } else if (currentColor.equals(Color.YELLOW)) {
                circleColorMap.put(MIDDLE, tempMap);
            } else {
                circleColorMap.put(BOTTOM, tempMap);
            }
        }

        return circleColorMap;
    }


}
