package uilight;

import javafx.scene.paint.Color;

import org.junit.jupiter.api.Test;
import ui.UILight.UICountryLightMapper;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;


public class UICountryLightMapperTest {

    private UICountryLightMapper countryLightMapper = new UICountryLightMapper();
    private static Color green = Color.GREEN;
    private static Color red = Color.RED;
    private static Color yellow = Color.YELLOW;
    private static Color black = Color.BLACK;
    private Color[] greenTrafficLightArray = {black, black, green};
    private Color[] yellowTrafficLightArray = {black, yellow, black};
    private Color[] redTrafficLightArray = {red, black, black};
    private Color[] redYellowTrafficLightArray = {red, yellow, black};
    private Color[] pedestrianRedLightRepresentation = {red, black};
    private Color[] pedestrianGreenLightRepresentation = {black, green};

    /*
    The Lights in the map are inserted from top to bottom. Like in the Color[]
     */
    @Test
    public void germanLightMapTest(){

        Map<String, Color[]> germanMap = new HashMap<>();
        germanMap.put("redLightRepresentation", redTrafficLightArray);
        germanMap.put("redYellowLightRepresentation", redYellowTrafficLightArray);
        germanMap.put("yellowLightRepresentation", yellowTrafficLightArray);
        germanMap.put("greenLightRepresentation", greenTrafficLightArray);

        assertEquals(germanMap, countryLightMapper.germanLightMap());
    }

    @Test
    public void dutchLightMapTest(){

        Map<String, Color[]> dutchMap = new HashMap<>();
        dutchMap.put("redLightRepresentation", redTrafficLightArray);
        dutchMap.put("yellowLightRepresentation", yellowTrafficLightArray);
        dutchMap.put("greenLightRepresentation", greenTrafficLightArray);

        assertEquals(dutchMap, countryLightMapper.dutchLightMap());
    }

    @Test
    public void pedestrianStandardLightMap(){

        Map<String, Color[]> pedestrianMap = new HashMap<>();
        pedestrianMap.put("pedestrianRedLightRepresentation", pedestrianRedLightRepresentation);
        pedestrianMap.put("pedestrianGreenLightRepresentation", pedestrianGreenLightRepresentation);

        assertEquals(pedestrianMap, countryLightMapper.pedestrianStandardLightMap());
    }


}
