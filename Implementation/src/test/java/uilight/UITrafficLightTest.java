package uilight;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.UILight.TrafficLights.UITrafficLight;

public class UITrafficLightTest {

    private String color;
    private UITrafficLight uiTrafficLight;

    @BeforeEach
    public void beforeEach(){
        color = "green";
    }

    @Test
    public void getColorArrayTest(){
        uiTrafficLight.getColorArray(color);
    }

    @Test
    public void changeColorTest(){

    }
}
