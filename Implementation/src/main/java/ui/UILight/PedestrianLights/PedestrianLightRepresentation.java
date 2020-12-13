package ui.UILight.PedestrianLights;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PedestrianLightRepresentation{
    //Leave only 2 circles
    private Circle topCircle;
    private Circle midCircle;
    private Circle bottomCircle;

    public PedestrianLightRepresentation(Circle topCircle, Circle midCircle, Circle bottomCircle) {
        this.topCircle = topCircle;
        this.midCircle = midCircle;
        this.bottomCircle = bottomCircle;
    }

    public void setCircleColor(Color[] colorArray) {
        topCircle.setFill(colorArray[0]);
        midCircle.setFill(colorArray[1]);
        bottomCircle.setFill(colorArray[2]);
    }
}
