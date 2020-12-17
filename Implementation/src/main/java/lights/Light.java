package lights;

import lightBehaviours.LightBehaviour;

/**
 * The interface Light.
 */
public interface Light {
    /**
     * Change color.
     */
    void changeColor();

    /**
     * Sets change behaviour.
     *
     * @param changeBehaviour the change behaviour
     */
    void setChangeBehaviour(LightBehaviour changeBehaviour);

    /**
     * Gets change behaviour.
     *
     * @return the change behaviour
     */
    LightBehaviour getChangeBehaviour();

    /**
     * Gets location.
     *
     * @return the location
     */
    Location getLocation();

}
