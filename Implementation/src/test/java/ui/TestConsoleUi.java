package ui;

import lights.Light;
import lights.Location;
import scrapped.StraightTrafficLightGermany;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TestConsoleUi {
    @Test
    public void testUpdate() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Ui consoleUi = new ConsoleUi();

        Light trafficLightGermany = new StraightTrafficLightGermany(
                consoleUi, mock(Location.class)
        );

        trafficLightGermany.changeColor();
        assertEquals("The traffic light shows: red and yellow", output.toString().trim());
    }
}
