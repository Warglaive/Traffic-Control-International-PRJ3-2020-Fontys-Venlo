package crossings;

import crossings.crossingControllers.fourWay.FourWayCrossingControllerEntrance;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;

import java.util.Map;

/**
 * Specifies a crossing
 */
public interface Crossing {

    /**
     * Creates and sets new changeController.
     * @param parameterList Parameters required by controllers constructor (needed to create lanes)
     * @param secondsBetweenLaneSwitch When two lanes have finished their cycle, the amount of time specified in this parameter
     * will pass until the next two lanes begin their cycle.
     */
    void changeController(
            Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList,
            int secondsBetweenLaneSwitch
    );

    /**
     * Gets controller.
     * @return the controller
     */
    FourWayCrossingControllerEntrance getController();

    /**
     * Sets controller.
     * @param controller the controller
     */
    void setController(FourWayCrossingControllerEntrance controller);

    /**
     * A before specified cycle, that decides in what order lights are being switched on and off is being executed
     * upon calling this method.
     */
    void cycleLanes();
}
