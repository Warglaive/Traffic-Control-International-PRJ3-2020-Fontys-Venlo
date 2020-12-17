package lane.laneControllers.standard;

import crossings.parameterEnums.LaneParameterKey;
import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviour;
import lights.Location;
import lights.observer.PedestrianObserverLightStandard;

import java.util.Map;

public class PedestrianLaneControllerStandard extends LaneControllerStandard{


    public PedestrianLaneControllerStandard(Map<LaneParameterKey, Object> parameterList) {
        super(parameterList);
    }

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
