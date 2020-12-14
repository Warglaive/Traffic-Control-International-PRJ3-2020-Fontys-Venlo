package ui.UILight.PedestrianLights;

import javafx.scene.paint.Color;
import lights.ObserverLight;
import ui.Controller.TwoLightsRepresentation;
import ui.UILight.Country;

import java.util.Observable;
import java.util.Observer;

public class UIPedestrianLightObserver extends UIPedestrianLight implements Observer {

    public UIPedestrianLightObserver(ObserverLight businessLight, Country country, TwoLightsRepresentation pedestrianLightRepresentation) {
        super(businessLight, country, pedestrianLightRepresentation);
    }


    public void update(Observable o, Object colorObj) {
        var color = (String) colorObj;
        Color[] circleData = this.getColorArray(color);
        applyChanges(circleData);
    }

    private void applyChanges(Color[] circleData) {
        //what should this do?
    }
}
