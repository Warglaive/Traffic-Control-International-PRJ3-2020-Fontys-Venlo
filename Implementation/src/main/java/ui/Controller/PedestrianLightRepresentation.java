package ui.Controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PedestrianLightRepresentation implements LightRepresentation {

    private Circle topCircle;
    private Circle midCircle;
    private Circle bottomCircle;

    public PedestrianLightRepresentation(Circle topCircle, Circle midCircle, Circle bottomCircle) {

        this.topCircle = topCircle;
        this.midCircle = midCircle;
        this.bottomCircle = bottomCircle;
    }
    @Override
    public void setColor(Color[] colorArray) {

        topCircle.setFill(colorArray[0]);
        midCircle.setFill(colorArray[1]);
    }
}
