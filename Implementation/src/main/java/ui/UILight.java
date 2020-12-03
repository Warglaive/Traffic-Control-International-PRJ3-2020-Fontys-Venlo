package ui;

import javafx.scene.paint.Color;

public interface UILight extends UIOutput {

    //Takes the String from the Buisness Logic and translates it to a lighting state.
    Color[] getColorArray(String color);

}
