package ui;

import Exceptions.ColorNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import lights.StraightTrafficObserverLight;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class SampleUi implements Observer {
    private Circle circleTop, circleMiddle, circleBottom;
    private Country country;

    public SampleUi(Circle circleTop, Circle circleMiddle, Circle circleBottom, Country country, StraightTrafficObserverLight businessLogicLight) {
        businessLogicLight.addObserver(this);

        this.circleTop = circleTop;
        this.circleMiddle = circleMiddle;
        this.circleBottom = circleBottom;
        this.country = country;
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

    /**
     * Map String to country specific color position and behaviour.
     * @param colorString String containing information about further behaviour.
     * @return A map with the String being translated into a usable form.
     * @throws ColorNotFoundException If the String contained colors that are not known.
     */
    private Map<CirclePosition, Map<UILightBehaviour, Color>> mapColorsToCountry(String colorString) throws ColorNotFoundException {
        Map returnMap;

        switch(country) {
            case GERMANY:
                returnMap = Mapper.mapToGermanTrafficBehaviour(colorString);
            default:
                returnMap = new HashMap();
        }

        return returnMap;
    }

    public void setCircleTop(Map<UILightBehaviour, Color> setSpecifications) {
    }

    public void setCircleMiddle(Map<UILightBehaviour, Color> setSpecifications) {
    }

    public void setCircleBottom(Map<UILightBehaviour, Color> setSpecifications) {
    }
}
