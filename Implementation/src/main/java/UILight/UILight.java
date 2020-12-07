package UILight;

import javafx.scene.paint.Color;
import ui.UIOutput;

public interface UILight extends UIOutput {

    //Takes the String from the Buisness Logic and translates it to a lighting state.
    Color[] getColorArray(String color);

}
