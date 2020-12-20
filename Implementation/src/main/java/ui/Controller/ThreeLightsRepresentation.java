package ui.Controller;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
This class takes the three circles of a traffic lights.
Its used to simplefi the trafficlight in the UI.
 */
public class ThreeLightsRepresentation implements LightRepresentation{
    private Circle topCircle;
    private Circle midCircle;
    private Circle bottomCircle;

    public ThreeLightsRepresentation(Circle topCircle, Circle midCircle, Circle bottomCircle) {

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

    @Override
    public Color[] getColor() {

        Color topCircleFill = (Color) topCircle.getFill();
        Color midCircleFill = (Color) midCircle.getFill();
        Color bottomCircleFill = (Color) bottomCircle.getFill();
        Color[] colorArray = {topCircleFill, midCircleFill, bottomCircleFill };

        return colorArray;
    }
}
