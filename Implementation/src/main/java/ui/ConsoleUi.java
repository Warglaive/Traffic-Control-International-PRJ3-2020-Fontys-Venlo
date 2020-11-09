package ui;

import java.util.Observable;

public class ConsoleUi implements Ui {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("The traffic light shows: " + arg);
    }
}
