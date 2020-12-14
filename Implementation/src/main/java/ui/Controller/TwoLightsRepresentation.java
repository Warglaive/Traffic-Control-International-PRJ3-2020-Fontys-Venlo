package ui.Controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TwoLightsRepresentation implements LightRepresentation {

    private Circle topCircle;
    private Circle bottomCircle;

    public TwoLightsRepresentation(Circle topCircle, Circle bottomCircle) {

        this.topCircle = topCircle;
        this.bottomCircle = bottomCircle;
    }
    @Override
    public void setColor(Color[] colorArray) {
        topCircle.setFill(colorArray[0]);
        bottomCircle.setFill(colorArray[1]);
    }
}
