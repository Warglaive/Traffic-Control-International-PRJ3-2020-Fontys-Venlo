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
    private Country country;
    private UICountryLightMapper uiCountryLightMapper;


    public UITrafficLight(StraightTrafficObserverLight businessLight, Country country){

        this.country = country;
        businessLight.addObserver(this);
        this.buisnessLight = businessLight;

        switch(this.country){
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

        switch(color.toLowerCase()) {
            case "red":
                toReturn = countrySpecificLightRepresentationMap.get("redLightRepresentation");
            case "yellow":
                toReturn = countrySpecificLightRepresentationMap.get("yellowLightRepresentation");
            case "green":
                toReturn = countrySpecificLightRepresentationMap.get("greenLightRepresentation");
            case "redyellow":
                toReturn = countrySpecificLightRepresentationMap.get("redyellowLightrepresentation");
            default:
                toReturn = uiCountryLightMapper.getAllTransparent();
        }

        return toReturn;
    }

    //Fillt die mitgegebenen Circles
    public void applyChanges(Color[] circleData) {
        //Irgendwas code mit countrySpecific

        //Circle1.setFill(Color[0})
        //Circle2.setFill()
        //Circle3.setFill();
    }

    //TODO in Observer Klasse packen
    @Override
    public void update(Observable o, Object arg) {
        //Here the color string comes from
            var color = (String) arg;
            Color[] circleData = this.getColorArray(color);
            applyChanges(circleData);

    }

}
