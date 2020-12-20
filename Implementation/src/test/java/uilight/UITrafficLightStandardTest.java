package uilight;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ui.Controller.ThreeLightsRepresentation;
import ui.UILight.Country;
import ui.UILight.TrafficLights.UITrafficLightStandard;

import static org.junit.Assert.*;

public class UITrafficLightStandardTest {

    private String greenColor = "green";
    private Country germany = Country.GERMANY;
    private UITrafficLightStandard uiTrafficLight = new UITrafficLightStandard();
    private static Color[] colorRepresentation = {Color.BLACK, Color.BLACK, Color.GREEN};
    private Circle topCircle = new Circle();
    private Circle midCircle = new Circle();
    private Circle bottomCircle = new Circle();
    private ThreeLightsRepresentation threeLightsRepresentation = new ThreeLightsRepresentation(topCircle, midCircle, bottomCircle);

    @BeforeEach
    public void setUp(){


        uiTrafficLight.setCountry(germany);
    }

    @Test
    public void getColorArrayTest(){

        assertEquals(uiTrafficLight.getColorArray(greenColor), colorRepresentation);

    }

    @Test
    public void changeColorTest(){

        uiTrafficLight.setThreeLightsRepresentation(threeLightsRepresentation);
        uiTrafficLight.changeColor(colorRepresentation);
        assertEquals(threeLightsRepresentation.getColor(), colorRepresentation);
    }
}
