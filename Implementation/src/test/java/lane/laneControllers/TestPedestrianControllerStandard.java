package lane.laneControllers;

import crossings.LaneControllerType;
import crossings.LaneParameterKey;
import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.PedestrianLightBehaviourStandard;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import locations.Location;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
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
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class TestPedestrianControllerStandard {
    @Mock
    Location location;

    PedestrianLightBehaviour lightBehaviour;

    LaneControllerStandard pedestrianLaneControllerStandard;
    Map<LaneControllerType, Map<LaneParameterKey, Object>> leftLaneParams;

    @BeforeEach
    @Before
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
    public void testAddLightsThrowsExceptionBehaviour() {
        /*ThrowableAssert.ThrowingCallable exceptionCode = () ->
            pedestrianLaneControllerStandard.addLights(2,
                    StraightTrafficLightBehaviourGermany.RED,
                    location);

        assertThatThrownBy(exceptionCode)
                .isExactlyInstanceOf(ClassCastException.class)
                .hasMessage("The light behaviour has to be of type PedestrianLightBehaviour");*/

        assertThrows(ClassCastException.class, () ->
                pedestrianLaneControllerStandard.addLights(2,
                StraightTrafficLightBehaviourGermany.RED,
                location));
    }

    @Test
    public void testAddLightsThrowsNumberException() {
        /*ThrowableAssert.ThrowingCallable exceptionCode = () ->
            pedestrianLaneControllerStandard.addLights(2,
                    StraightTrafficLightBehaviourGermany.RED,
                    location);

        assertThatThrownBy(exceptionCode)
                .isExactlyInstanceOf(ClassCastException.class)
                .hasMessage("The light behaviour has to be of type PedestrianLightBehaviour");*/

        assertThrows(IllegalArgumentException.class, () ->
                pedestrianLaneControllerStandard.addLights(0,
                PedestrianLightBehaviourStandard.RED,
                location));
    }


}
