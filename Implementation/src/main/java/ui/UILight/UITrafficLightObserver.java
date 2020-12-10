package ui.UILight;

import javafx.scene.paint.Color;
import lights.ObserverLight;
import java.util.Observable;
import java.util.Observer;

public abstract class UITrafficLightObserver extends UITrafficLight implements Observer {

    public UITrafficLightObserver(ObserverLight businessLight, Country country) {
        super(businessLight, country);
    }

    @Override
    public void update(Observable o, Object arg) {

        var color = (String) arg;
        Color[] circleData = this.getColorArray(color);
        applyChanges(circleData);
    }
}
