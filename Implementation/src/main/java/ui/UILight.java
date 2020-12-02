package ui;

public interface UILight extends UIOutput {

    //Takes the String from the Buisness Logic and translates it to a lighting state.
    String changeColor(String color);

}
