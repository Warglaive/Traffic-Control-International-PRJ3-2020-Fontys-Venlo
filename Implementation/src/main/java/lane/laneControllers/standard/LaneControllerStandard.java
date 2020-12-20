package lane.laneControllers.standard;

import crossings.parameterEnums.LaneParameterKey;
import lane.laneControllers.LaneController;
import lane.laneControllers.Sleeper;
import lightBehaviours.LightBehaviour;
import lights.Location;
import lights.observer.ObserverLight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static crossings.parameterEnums.LaneParameterKey.*;

public abstract class LaneControllerStandard implements LaneController, Runnable{
    protected List<ObserverLight> lights;
    /**
     * cycleTime = the amount of time the light will need to switch between states
     * goDuration = the amount of time the light will stay on the color that resembles go
     */
    private int cycleTime, goDuration;
    private LightBehaviour goState, stopState;


    /**
     * Creates an Instance and Components of LaneControllerStandard.
     * @param parameterList The parameters required to create LaneControllerStandard.
     */
    public LaneControllerStandard(Map<LaneParameterKey, Object> parameterList) {
        //Create fields and assign values
        lights = new ArrayList<ObserverLight>();

        this.goDuration = (int) parameterList.get(GO_DURATION);
        this.cycleTime = (int) parameterList.get(CYCLE_TIME);

        var numberLights = (Integer) parameterList.get(NUMBER_LIGHTS);
        var lightsBehaviour = (LightBehaviour) parameterList.get(LIGHT_BEHAVIOUR);
        var location = (Location) parameterList.get(LOCATION);

        //Get go and stop state out of light behaviour
        goState = lightsBehaviour.getGoState();
        stopState = lightsBehaviour.getStopState();

        //Create and add lights
        addLights(numberLights,
                lightsBehaviour,
                location);
    }

    /**
     * Return List with lights
     * @return List with ObserverLights
     */
    @Override
    public List<ObserverLight> getLights() {
        return lights;
    }

    /**
     * Proceed all saved lights by one state.
     */
    @Override
    public void proceedOneState() {
        for (var currentLight : lights) {
            currentLight.changeColor();
        }
    }

    /**
     * Cycle all saved lights.
     * @param sleeper A class used to sleep a Thread.
     * @throws InterruptedException If the thread gets interrupted.
     */
    void cycleLights(Sleeper sleeper) throws InterruptedException {
        var leadingLight = lights.get(0);
        var currentState = leadingLight.getChangeBehaviour();

        do {
            if (currentState != goState) {
                sleeper.sleep(cycleTime);
            } else {
                sleeper.sleep(goDuration);
            }
            System.out.println(currentState.getColor());
            proceedOneState();

            currentState = currentState.getNextState();
        } while (currentState != stopState);
    }

    /**
     * Call cycle lights and give standard Sleeper.
     * @throws InterruptedException If the thread gets interrupted.
     */
    @Override
    public void cycleLights() throws InterruptedException {
        this.cycleLights(new Sleeper());
    }

    /**
     * Call cycleLights method.
     */
    @Override
    public void run() {
        try {
            cycleLights();
        } catch (InterruptedException e) {
            //TODO: Proper exception handling
        }
    }
}
