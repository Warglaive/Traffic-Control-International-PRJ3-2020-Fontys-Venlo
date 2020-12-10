package ui.UILight;

import javafx.scene.paint.Color;

public interface UILight {

    //Takes the String from the Business Logic and translates it to a lighting state.
   public Color[] getColorArray(String color);

}
