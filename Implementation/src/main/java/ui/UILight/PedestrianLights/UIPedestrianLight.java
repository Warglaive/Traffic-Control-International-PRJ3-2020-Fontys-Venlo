package ui.UILight.PedestrianLights;

import javafx.scene.paint.Color;
import ui.UILight.UICountryLightMapper;
import ui.UILight.UILight;

import java.util.Map;

public class UIPedestrianLight implements UILight {

    private Map<String, Color[]> countrySpecificLightRepresentationMap;
    private UICountryLightMapper uiCountryLightMapper;

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
    public void changeColor(String color) {

    }
}
