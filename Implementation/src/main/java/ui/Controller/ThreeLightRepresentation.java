package ui.Controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
This class takes the three circles of a traffic lights.
Its used to simplefi the trafficlight in the UI.
 */
public class ThreeLightRepresentation implements LightRepresentation{
    private Circle topCircle;
    private Circle midCircle;
    private Circle bottomCircle;

    public ThreeLightRepresentation(Circle topCircle, Circle midCircle, Circle bottomCircle) {

        this.topCircle = topCircle;
        this.midCircle = midCircle;
        this.bottomCircle = bottomCircle;
    }

    @Override
    public void setColor(Color[] colorArray) {

        topCircle.setFill(colorArray[0]);
        midCircle.setFill(colorArray[1]);
        bottomCircle.setFill(colorArray[2]);
    }
}
