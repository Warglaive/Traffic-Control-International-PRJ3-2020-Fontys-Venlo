package ui.UILight.TrafficLights;

import javafx.beans.Observable;
import javafx.scene.paint.Color;
import lights.ObserverLight;
import ui.Controller.ThreeLightRepresentation;
import ui.UILight.Country;
import ui.UILight.UICountryLightMapper;
import ui.UILight.UILight;

import java.util.*;

/*
This class takes the FXML Traffic Light and the traffic light from the buisness logic and connects both.
the UILight connects via the lane and the BuisnessLogic Light connects via the StraightTrafficLightObserver
Therefore this cass needs to implement the observable class.
 */

public abstract class UITrafficLight implements UILight, Observable {

    private Map<String, Color[]> countrySpecificLightRepresentationMap;
    private ObserverLight businessLight;
    private Country country;
    private UICountryLightMapper uiCountryLightMapper;
    private ThreeLightRepresentation threeLightRepresentation;


    public UITrafficLight(ObserverLight businessLight, Country country, ThreeLightRepresentation threeLightRepresentation) {

        this.country = country;
        businessLight.addObserver((Observer) this);
        this.businessLight = businessLight;
        this.threeLightRepresentation = threeLightRepresentation;

        switch (this.country) {
            case Germany:
                countrySpecificLightRepresentationMap = uiCountryLightMapper.germanLightMap();

            case Netherlands:
                countrySpecificLightRepresentationMap = uiCountryLightMapper.dutchLightMap();
        }
    }

    /*
    Returns a color array which the GUI(Class that connects fxml to logic) class can
    use to display a light
     */
    @Override
    public Color[] getColorArray(String color) {

        Color[] toReturn;

        switch (color.toLowerCase()) {
            case "red":
                toReturn = countrySpecificLightRepresentationMap.get("redLightRepresentation");
            case "yellow":
                toReturn = countrySpecificLightRepresentationMap.get("yellowLightRepresentation");
            case "green":
                toReturn = countrySpecificLightRepresentationMap.get("greenLightRepresentation");
            case "redYellow":
                toReturn = countrySpecificLightRepresentationMap.get("redYellowLightRepresentation");
            default:
                toReturn = uiCountryLightMapper.getAllTransparent();
        }

        return toReturn;
    }

    @Override
    public void changeColor(Color[] colors) {
        threeLightRepresentation.setColor(colors);
    }
}
