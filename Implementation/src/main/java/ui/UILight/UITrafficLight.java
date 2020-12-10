package ui.UILight;

import javafx.scene.paint.Color;
import lights.Light;
import lights.ObserverLight;
import lights.StraightTrafficObserverLight;
import ui.UILane.UiLane;

import java.lang.reflect.Array;
import java.util.*;

/*
This class takes the FXML Traffic Light and the traffic light from the buisness logic and connects both.
the UILight connects via the lane and the BuisnessLogic Light connects via the StraightTrafficLightObserver
Therefore this cass needs to implement the observable class.
 */

public class UITrafficLight implements UILight, Observer {

    private Map<String, Color[]> countrySpecificLightRepresentationMap;
    private StraightTrafficObserverLight buisnessLight;
    private String country;

    public UITrafficLight(StraightTrafficObserverLight businessLight, String country){

        this.country = country;
        businessLight.addObserver(this);
        this.buisnessLight = businessLight;
    }

    /*
    Returns a color array which the GUI(Class that connects fxml to logic) class can
    use to display a light
     */
    @Override
    public Color[] getColorArray(String color) {

        return null;
    }

    /*
        Takes the empty country Color[] method and fills it with the colors of the current state.
     */


    //When the notifyObserver Method from the observed object gets called this class gets executet
    @Override
    public void update(Observable o, Object arg) {
        //Here the color string comes from
            var color = (String) arg;
            this.mapColorStringToArray(color);


    }

    private Color[] mapColorStringToArray(String color) {
        switch(color) {
            case "red":
                return null;
            case "yellow":
                return null;
        }

        return null;
    }


    //TODO Implement Country mapper
    /*
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

    */
}
