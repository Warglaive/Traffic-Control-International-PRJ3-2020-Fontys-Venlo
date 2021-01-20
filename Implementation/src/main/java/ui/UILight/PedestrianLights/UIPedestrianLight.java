package ui.UILight.PedestrianLights;

import javafx.scene.paint.Color;
import lights.observer.ObserverLight;
import ui.Controller.TwoLightsRepresentation;
import ui.UILight.Country;
import ui.UILight.UICountryLightMapper;
import ui.UILight.UILight;

import java.util.Map;

public class UIPedestrianLight implements UILight {

    private Map<String, Color[]> countrySpecificLightRepresentationMap;
    private ObserverLight businessLight;
    private UICountryLightMapper uiCountryLightMapper;
    protected TwoLightsRepresentation pedestrianLightRepresentation;

    /**
     * @param businessLight                 - take observer light in order to change color and to notify observers
     * @param country                       - to be extended
     * @param pedestrianLightRepresentation - a light representation
     */
    public UIPedestrianLight(ObserverLight businessLight, Country country, TwoLightsRepresentation pedestrianLightRepresentation) {
        this.businessLight = businessLight;
        this.pedestrianLightRepresentation = pedestrianLightRepresentation;
        this.uiCountryLightMapper = new UICountryLightMapper();
        //default is same as GERMANY use case since there is no difference at the moment for different countries.
        switch (country) {
            case GERMANY:
                this.countrySpecificLightRepresentationMap = this.uiCountryLightMapper.pedestrianStandardLightMap();
                break;
            default:
                //Default will work for the Netherlands
                this.countrySpecificLightRepresentationMap = this.uiCountryLightMapper.pedestrianStandardLightMap();
                break;
        }
    }

    /**
     * @param color
     * @return an Color[]
     */
    @Override
    public Color[] getColorArray(String color) {
        switch (color.toLowerCase()) {
            case "red":
                return this.countrySpecificLightRepresentationMap.get("pedestrianRedLightRepresentation");
            case "green":
                return this.countrySpecificLightRepresentationMap.get("pedestrianGreenLightRepresentation");
            default:
                return this.uiCountryLightMapper.getAllTransparent();
        }
    }

    /**
     * change pedestrian light to either red or green
     */
    @Override
    public void changeColor(Color[] colors) {
        this.pedestrianLightRepresentation.setColor(colors);
    }

}
