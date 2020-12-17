package lane.laneControllers.standard;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import lightBehaviours.PedestrianLightBehaviourStandard;
import lightBehaviours.StraightTrafficLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import lights.Location;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static crossings.parameterEnums.LaneParameterKey.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class TestStraightLaneControllerStandard {
    @Mock
    Location location;

    StraightTrafficLightBehaviour lightBehaviour;

    LaneControllerStandard straightLaneControllerStandard;
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;
    Map<LaneControllerType, Map<LaneParameterKey, Object>> leftLaneParams;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.openMocks(this);
        location = mock(Location.class);
        straightTrafficLightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        leftLaneParams = new HashMap();

        HashMap leftLaneStraightParams = new HashMap();
        leftLaneStraightParams.put(NUMBER_LIGHTS, 2);
        leftLaneStraightParams.put(LIGHT_BEHAVIOUR, straightTrafficLightBehaviour);
        leftLaneStraightParams.put(LOCATION, location);
        leftLaneStraightParams.put(GO_DURATION, 25);
        leftLaneStraightParams.put(CYCLE_TIME, 2);

        leftLaneParams = new HashMap();
        leftLaneParams.put(STRAIGHT, leftLaneStraightParams);

        straightLaneControllerStandard = new StraightLaneControllerStandard(
                leftLaneStraightParams
        );
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0"
    })
    public void testAddLightsThrowsExceptionNumberLights(int numberLights) {
        leftLaneParams.get(STRAIGHT).replace(NUMBER_LIGHTS, numberLights);
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                straightLaneControllerStandard = new StraightLaneControllerStandard(
                leftLaneParams.get(STRAIGHT)
                        );
        assertThatCode(exceptionCode)
                .hasMessage("The number of lights has to be greater than 0")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testAddLightsNoException() {
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                straightLaneControllerStandard = new StraightLaneControllerStandard(
                        leftLaneParams.get(STRAIGHT)
                );
        assertThatCode(exceptionCode)
                .doesNotThrowAnyException();
    }

    @Test
    public void testAddLightsThrowsExceptionBehaviour() {
        ThrowableAssert.ThrowingCallable exceptionCode = () -> {
            straightLaneControllerStandard.addLights(2,
                    PedestrianLightBehaviourStandard.RED,
                    location);
        };

        assertThatCode(exceptionCode)
                .hasMessage("The light behaviour has to be of type StraightTrafficLightBehaviour")
                .isExactlyInstanceOf(ClassCastException.class);
    }



    /*@Test
    public void testAddLightsThrowsExceptionUi() {
        UIOutput falseUserInterface = mock(UIOutput.class);

        straightLaneController = new StraightLaneControllerStandard(
                2,
                StraightTrafficLightBehaviourGermany.RED,
                location
        );

        ThrowableAssert.ThrowingCallable exceptionCode = () -> {
            straightLaneController.addLights(
                    2,
                    StraightTrafficLightBehaviourGermany.RED,
                    falseUserInterface,
                    location
            );
        };
        assertThatCode(exceptionCode)
                .isExactlyInstanceOf(ClassCastException.class)
                .hasMessage("The userInterface has to be of type UIObserver");
    }*/
}
