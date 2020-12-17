package crossings.crossingControllers;

/**
 * Interface specifying a crossing controller. Crossing controllers manage and save the lanes belonging to a crossing.
 */
public interface CrossingController {
    /**
     * A before specified cycle, that decides in what order lights are being switched on and off is being executed
     * upon calling this method.
     */
    void cycleLanes();
}
