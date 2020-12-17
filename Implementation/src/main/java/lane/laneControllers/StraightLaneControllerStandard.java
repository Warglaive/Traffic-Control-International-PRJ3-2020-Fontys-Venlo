package lane.laneControllers;

import crossings.parameterEnums.LaneParameterKey;
import lightBehaviours.LightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;
import lights.observerLights.StraightTrafficObserverLightStandard;

import java.util.Map;

public class StraightLaneControllerStandard extends LaneControllerStandard {
    public StraightLaneControllerStandard(Map<LaneParameterKey, Object> parameterList) {
        super(parameterList);
    }

    /**
     * Adds lights to controller. Checks for correct typage in subclasses.
     *
     * @param numberLights    The number of lights to be added.
     * @param lightsBehaviour Behaviour the light is getting
     * @param location        The location of the light.
     */
    public void addLights(int numberLights,
                          LightBehaviour lightsBehaviour,
                          Location location) {

        if (numberLights <= 0) {
            throw new IllegalArgumentException("The number of lights has to be greater than 0");
        }

        StraightTrafficLightBehaviour straightLightsBehaviour;

        try {
            straightLightsBehaviour = (StraightTrafficLightBehaviour) lightsBehaviour;
        } catch (ClassCastException e) {
            throw new ClassCastException("The light behaviour has to be of type StraightTrafficLightBehaviour");
        }

        for (int i = 0; i < numberLights; i++) {
            super.getLights().add(new StraightTrafficObserverLightStandard(straightLightsBehaviour, location));
        }
    }
}
