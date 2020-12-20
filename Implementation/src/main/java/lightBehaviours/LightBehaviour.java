package lightBehaviours;

import lights.observer.ObserverLight;

public interface LightBehaviour {
    /**
     * Advance one state.
     * @param light The light the LightBehaviour has to be changed on.
     * @return A String representation of the light.
     */
    String changeColor(ObserverLight light);
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
