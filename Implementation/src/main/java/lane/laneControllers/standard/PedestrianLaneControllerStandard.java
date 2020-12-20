package lane.laneControllers.standard;

import crossings.parameterEnums.LaneParameterKey;
import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import lights.Location;
import lights.observer.PedestrianObserverLightStandard;

import java.util.Map;

public class PedestrianLaneControllerStandard extends LaneControllerStandard{
    /**
     * Creates an Instance and Components of PedestrianLaneControllerStandard.
     * @param parameterList The parameters required to create LaneControllerStandard.
     */
    public PedestrianLaneControllerStandard(Map<LaneParameterKey, Object> parameterList) {
        super(parameterList);
    }

    /**
     * Adds lights to controller. Checks for correct typage in subclasses.
     * @param numberLights The number of lights to be added.
     * @param lightsBehaviour Behaviour the light is getting
     * @param location The location of the light.
     */
    @Override
    public void addLights(int numberLights, LightBehaviour lightsBehaviour, Location location) {
        if (numberLights <= 0) {
            throw new IllegalArgumentException("The number of lights has to be greater than 0");
        }

        PedestrianLightBehaviour pedestrianLightBehaviour;

        try {
            pedestrianLightBehaviour = (PedestrianLightBehaviour) lightsBehaviour;
        } catch (ClassCastException e) {
            throw new ClassCastException("The light behaviour has to be of type PedestrianLightBehaviour");
        }

        for (int i = 0; i < numberLights; i++) {
            super.getLights().add(new PedestrianObserverLightStandard(pedestrianLightBehaviour, location));
        }
    }
}
