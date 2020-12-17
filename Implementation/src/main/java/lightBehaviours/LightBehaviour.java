package lightBehaviours;

import lights.observerLights.ObserverLight;

public interface LightBehaviour {
    String changeColor(ObserverLight observerLight);
    String getColor();

    /**
     * Get the state that resembles the "go" signal.
     * @return The go state
     */
    LightBehaviour getGoState();

    /**
     * Get the state that resembles the "stop" signal.
     * @return The stop state
     */
    LightBehaviour getStopState();

    /**
     * Get the state that will be given on the next change.
     * @return The next state
     */
    LightBehaviour getNextState();
}
