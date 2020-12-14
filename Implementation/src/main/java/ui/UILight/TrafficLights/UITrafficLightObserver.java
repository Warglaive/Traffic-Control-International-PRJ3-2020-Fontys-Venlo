package ui.UILight.TrafficLights;

import javafx.scene.paint.Color;
import lights.ObserverLight;
import ui.Controller.ThreeLightRepresentation;
import ui.UILight.Country;

import java.util.Observable;
import java.util.Observer;

public abstract class UITrafficLightObserver extends UITrafficLight implements Observer {

    public UITrafficLightObserver(ObserverLight businessLight, Country country, ThreeLightRepresentation threeLightRepresentation) {
        super(businessLight, country, threeLightRepresentation);
    }

    @Override
    public void update(Observable o, Object arg) {
        var color = (String) arg;
        Color[] circleData = this.getColorArray(color);
        changeColor(circleData);
    }
}
