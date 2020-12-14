package ui.UILight.PedestrianLights;

import javafx.scene.paint.Color;
import lights.ObserverLight;
import ui.Controller.TwoLightsRepresentation;
import ui.UILight.Country;
import ui.UILight.UICountryLightMapper;
import ui.UILight.UILight;

import java.util.Map;

public class UIPedestrianLight implements UILight  {

    private Map<String, Color[]> countrySpecificLightRepresentationMap;
    private ObserverLight businessLight;
    private UICountryLightMapper uiCountryLightMapper;
    protected TwoLightsRepresentation pedestrianLightRepresentation;

    public UIPedestrianLight(ObserverLight businessLight, Country country, TwoLightsRepresentation pedestrianLightRepresentation) {
        this.businessLight = businessLight;
        this.pedestrianLightRepresentation = pedestrianLightRepresentation;
        switch (country) {
            case Germany:
                this.countrySpecificLightRepresentationMap = this.uiCountryLightMapper.germanLightMap();
                break;
            default:
                //Default will work for the Netherlands
                this.countrySpecificLightRepresentationMap = this.uiCountryLightMapper.dutchLightMap();
                break;
        }
    }

    @Override
    public Color[] getColorArray(String color) {
        Color[] colorArray;
        switch (color.toLowerCase()) {
            case "red":
                colorArray = this.countrySpecificLightRepresentationMap.get("redLightRepresentation");
            case "yellow":
                colorArray = this.countrySpecificLightRepresentationMap.get("yellowLightRepresentation");
            case "green":
                colorArray = this.countrySpecificLightRepresentationMap.get("greenLightRepresentation");
            case "redYellow":
                colorArray = this.countrySpecificLightRepresentationMap.get("redYellowLightRepresentation");
            default:
                colorArray = this.uiCountryLightMapper.getAllTransparent();
        }

        return colorArray;
    }

    @Override
    public void changeColor(Color[] colors) {
        this.pedestrianLightRepresentation.setColor(colors);
    }

}
