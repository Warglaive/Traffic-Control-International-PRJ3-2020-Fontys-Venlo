package lane.laneControllers;

import lightBehaviours.LightBehaviour;
import lights.ObserverLight;
import locations.Location;

import java.util.ArrayList;
import java.util.List;

public abstract class LaneControllerStandard implements LaneController {
    protected List<ObserverLight> lights;
    /**
     * cycleTime = the amount of time the light will need to switch between states
     * goDuration = the amount of time the light will stay on the color that resembles go
     */
    private int cycleTime, goDuration;
    private LightBehaviour goState, stopState;


    public LaneControllerStandard(int numberLights,
                                  LightBehaviour lightsBehaviour,
                                  Location location,
                                  int goDuration,
                                  int cycleTime) {

        lights = new ArrayList<ObserverLight>();

        this.goDuration = goDuration;
        this.cycleTime = cycleTime;

        goState = lightsBehaviour.getGoState();
        stopState = lightsBehaviour.getStopState();

        addLights(numberLights,
                lightsBehaviour,
                location);
    }

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
