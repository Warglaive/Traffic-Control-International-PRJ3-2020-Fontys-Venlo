package ui.UILight;

import javafx.scene.paint.Color;

public interface UILight {

    //Takes the String from the Business Logic and translates it to a lighting state.
   publi Color[] getColorArray(String color);

}
