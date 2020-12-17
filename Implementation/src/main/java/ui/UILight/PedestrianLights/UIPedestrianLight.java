package ui.UILight.PedestrianLights;

import javafx.scene.paint.Color;
import lights.observer.ObserverLight;
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
        this.uiCountryLightMapper = new UICountryLightMapper();
        //TODO: Country makes no sense here, pedestrian lights do not relate to countries
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

    @Override
    public void changeColor(Color[] colors) {
        this.pedestrianLightRepresentation.setColor(colors);
    }

}
