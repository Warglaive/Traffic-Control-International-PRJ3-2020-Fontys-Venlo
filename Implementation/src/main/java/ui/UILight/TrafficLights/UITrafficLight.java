package ui.UILight.TrafficLights;

import javafx.scene.paint.Color;
import lights.ObserverLight;
import ui.Controller.ThreeLightsRepresentation;
import ui.UILight.Country;
import ui.UILight.UICountryLightMapper;
import ui.UILight.UILight;

import java.util.*;

/*
This class takes the FXML Traffic Light and the traffic light from the buisness logic and connects both.
the UILight connects via the lane and the BuisnessLogic Light connects via the StraightTrafficLightObserver
Therefore this cass needs to implement the observable class.
 */

public abstract class UITrafficLight implements UILight {

    private Map<String, Color[]> countrySpecificLightRepresentationMap;
    private ObserverLight businessLight;
    private Country country;
    private UICountryLightMapper uiCountryLightMapper;
    private ThreeLightsRepresentation threeLightsRepresentation;


    public UITrafficLight(ObserverLight businessLight, Country country, ThreeLightsRepresentation threeLightsRepresentation) {

        this.country = country;
        businessLight.addObserver((Observer) this);
        this.businessLight = businessLight;
        this.threeLightsRepresentation = threeLightsRepresentation;
        this.uiCountryLightMapper = new UICountryLightMapper();

        switch (this.country) {
            case GERMANY:
                countrySpecificLightRepresentationMap = uiCountryLightMapper.germanLightMap();
                break;
            case NETHERLANDS:
                countrySpecificLightRepresentationMap = uiCountryLightMapper.dutchLightMap();
                break;
        }
    }

    /*
    Returns a color array which the GUI(Class that connects fxml to logic) class can
    use to display a light
     */
    @Override
    public Color[] getColorArray(String color) {

        Color[] toReturn;

        switch (color) {
            case "red":
                return countrySpecificLightRepresentationMap.get("redLightRepresentation");
            case "yellow":
                return countrySpecificLightRepresentationMap.get("yellowLightRepresentation");
            case "green":
                return countrySpecificLightRepresentationMap.get("greenLightRepresentation");
            case "redYellow":
                return countrySpecificLightRepresentationMap.get("redYellowLightRepresentation");
            default:
                return uiCountryLightMapper.getAllTransparent();
        }
    }

    @Override
    public void changeColor(Color[] colors) {
        threeLightsRepresentation.setColor(colors);
    }
}
