package lane.laneControllers;

import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.PedestrianLightBehaviourStandard;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static crossings.LaneControllerType.PEDESTRIAN;
import static crossings.LaneControllerType.STRAIGHT;
import static crossings.LaneParameterKey.*;
import static crossings.LaneParameterKey.NUMBER_LIGHTS;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mock;

public class TestPedestrianControllerStandard {
    @Mock
    Location location;

    PedestrianLightBehaviour lightBehaviour;

    LaneControllerStandard pedestrianLaneControllerStandard;
    Map<LaneControllerType, Map<LaneParameterKey, Object>> leftLaneParams;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.openMocks(this);
        location = mock(Location.class);
        lightBehaviour = PedestrianLightBehaviourStandard.RED;
        leftLaneParams = new HashMap();

        HashMap leftLaneStraightParams = new HashMap();
        leftLaneStraightParams.put(NUMBER_LIGHTS, 2);
        leftLaneStraightParams.put(LIGHT_BEHAVIOUR, lightBehaviour);
        leftLaneStraightParams.put(LOCATION, location);
        leftLaneStraightParams.put(GO_DURATION, 25);
        leftLaneStraightParams.put(CYCLE_TIME, 2);

        leftLaneParams = new HashMap();
        leftLaneParams.put(PEDESTRIAN, leftLaneStraightParams);

        pedestrianLaneControllerStandard = new PedestrianLaneControllerStandard(
                leftLaneStraightParams
        );
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0"
    })
    public void testAddLightsThrowsExceptionNumberLights(int numberLights) {
        leftLaneParams.get(PEDESTRIAN).replace(NUMBER_LIGHTS, numberLights);
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                pedestrianLaneControllerStandard = new StraightLaneControllerStandard(
                        leftLaneParams.get(PEDESTRIAN)
                );
        assertThatCode(exceptionCode)
                .hasMessage("The number of lights has to be greater than 0")
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testAddLightsNoException() {
        ThrowableAssert.ThrowingCallable exceptionCode = () ->
                pedestrianLaneControllerStandard = new PedestrianLaneControllerStandard(
                        leftLaneParams.get(PEDESTRIAN)
                );
        assertThatCode(exceptionCode)
                .doesNotThrowAnyException();
    }

    @Test
    public void testAddLightsThrowsExceptionBehaviour() {
        ThrowableAssert.ThrowingCallable exceptionCode = () -> {
            pedestrianLaneControllerStandard.addLights(2,
                    StraightTrafficLightBehaviourGermany.RED,
                    location);
        };

        assertThatCode(exceptionCode)
                .hasMessage("The light behaviour has to be of type PedestrianLightBehaviour")
                .isExactlyInstanceOf(ClassCastException.class);
    }
}
