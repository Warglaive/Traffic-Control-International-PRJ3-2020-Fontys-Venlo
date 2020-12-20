package ui.Controller;

import javafx.scene.paint.Color;

public interface LightRepresentation {
    /*
    Takes the color array and sets each entry into the circles from the UI
     */
    void setColor(Color[] colorArray);

    /*
    Returns the set colors as Color[], from top to bottom
     */
    Color[] getColor();
}
