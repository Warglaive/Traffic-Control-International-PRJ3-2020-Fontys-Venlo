package lane.laneControllers;

import crossings.LaneParameterKey;
import lightBehaviours.LightBehaviour;
import lights.ObserverLight;
import locations.Location;

import static crossings.LaneParameterKey.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class LaneControllerStandard implements LaneController {
    protected List<ObserverLight> lights;
    /**
     * cycleTime = the amount of time the light will need to switch between states
     * goDuration = the amount of time the light will stay on the color that resembles go
     */
    private int cycleTime, goDuration;
    private LightBehaviour goState, stopState;


    public LaneControllerStandard(Map<LaneParameterKey, Object> parameterList) {

        lights = new ArrayList<ObserverLight>();

        //TODO: Exception handling
        this.goDuration = (int) parameterList.get(GO_DURATION);
        this.cycleTime = (int) parameterList.get(CYCLE_TIME);

        var numberLights = (Integer) parameterList.get(NUMBER_LIGHTS);
        var lightsBehaviour = (LightBehaviour) parameterList.get(LIGHT_BEHAVIOUR);
        var location = (Location) parameterList.get(LOCATION);

        goState = lightsBehaviour.getGoState();
        stopState = lightsBehaviour.getStopState();

        addLights(numberLights,
                lightsBehaviour,
                location);
    }

    @Override
    public List<ObserverLight> getLights() {
        return lights;
    }

    @Override
    public void proceedOneState() {
        for (var currentLight : lights) {
            currentLight.changeColor();
        }
    }

    void cycleLights(Sleeper sleeper) throws InterruptedException {
        var leadingLight = lights.get(0);
        var currentState = leadingLight.getChangeBehaviour();

        do {
            if (currentState != goState) {
                sleeper.sleep(cycleTime);
            } else {
                sleeper.sleep(goDuration);
            }

            proceedOneState();

            currentState = currentState.getNextState();
        } while (currentState != stopState);
    }

    @Override
    public void cycleLights() throws InterruptedException {
        this.cycleLights(new Sleeper());
    }
}
