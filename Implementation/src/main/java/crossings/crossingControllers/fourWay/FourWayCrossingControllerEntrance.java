package crossings.crossingControllers.fourWay;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lane.Lane;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static crossings.parameterEnums.LaneType.*;

/**
 * The type Four way crossing controller entrance.
 */
public abstract class FourWayCrossingControllerEntrance implements FourWayCrossingController {
    /**
     * The lanes belonging to a crossing
     */
    private Lane leftLane;
    private Lane rightLane;
    private Lane topLane;
    private Lane bottomLane;
    /**
     * When two lanes have finished their cycle, the amount of time specified in this field will pass until
     * the next two lanes begin their cycle.
     */
    private int secondsBetweenLaneSwitch;

    /**
     * Passes necessary parameters to lane constructors and sets the returning lanes as fields.
     * @param parameterList Parameters for lane constructors.
     * @param secondsBetweenLaneSwitch When two lanes have finished their cycle, the amount of time specified in this parameter
     *  will pass until the next two lanes begin their cycle.
     */
    public FourWayCrossingControllerEntrance(
            Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        this.changeLeftLane(parameterList.get(LEFT_LANE));
        this.changeRightLane(parameterList.get(RIGHT_LANE));
        this.changeTopLane(parameterList.get(TOP_LANE));
        this.changeBottomLane(parameterList.get(BOTTOM_LANE));

        this.secondsBetweenLaneSwitch = secondsBetweenLaneSwitch;
    }

    /**
     * A before specified cycle, that decides in what order lights are being switched on and off is being executed
     * upon calling this method
     */
    @Override
    public void cycleLanes() {
        this.threadOperation(topLane, bottomLane, rightLane, leftLane);
        this.threadOperation(rightLane, leftLane, topLane, bottomLane);
    }

    /**
     * Takes care of executing the lane cycles.
     * @param straightOne One straight lane that has to be cycled.
     * @param straightTwo One straight lane that has to be cycled.
     * @param pedestrianThree One pedestrian lane that has to be cycled.
     * @param pedestrianFour One pedestrian lane that has to be cycled.
     */
    private void threadOperation(Lane straightOne, Lane straightTwo, Lane pedestrianThree, Lane pedestrianFour) {
        //Create threads out of given lanes
        Thread straightOneLaneThread = new Thread((Runnable) straightOne.getStraightLaneController());
        Thread straightTwoLaneThread = new Thread((Runnable) straightTwo.getStraightLaneController());
        Thread pedestrianThreeLaneThread = new Thread((Runnable) pedestrianThree.getPedestrianLaneController());
        Thread pedestrianFourLaneThread = new Thread((Runnable) pedestrianFour.getPedestrianLaneController());

        //Start the created threads
        straightOneLaneThread.start();
        straightTwoLaneThread.start();
        pedestrianThreeLaneThread.start();
        pedestrianFourLaneThread.start();

        //Try to join the threads to the main thread. The main threads can only proceed when all joined threads are finished.
        try {
            straightOneLaneThread.join();
            straightTwoLaneThread.join();
            pedestrianThreeLaneThread.join();
            pedestrianFourLaneThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
            //TODO: Proper exception handling
        }

        //Wait for an amount of time before finishing this threadOperation.
        try {
            TimeUnit.SECONDS.sleep(secondsBetweenLaneSwitch);
        } catch (InterruptedException e) {
            //TODO: Proper exception handling
            e.printStackTrace();
        }
    }

    /**
     * Creates a new left lane and sets it with the given parameters.
     * @param parameterList Required parameters for constructing a lane
     */
    public abstract void changeLeftLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );

    /**
     * Creates a new right lane and sets it with the given parameters.
     * @param parameterList Required parameters for constructing a lane
     */
    public abstract void changeRightLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );

    /**
     * Creates a new top lane and sets it with the given parameters.
     * @param parameterList Required parameters for constructing a lane
     */
    public abstract void changeTopLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );

    /**
     * Creates a new bottom lane and sets it with the given parameters.
     * @param parameterList Required parameters for constructing a lane
     */
    public abstract void changeBottomLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );


    /**
     * Sets left lane.
     * @param leftLane the left lane
     */
    public void setLeftLane(Lane leftLane) {
        this.leftLane = leftLane;
    }

    /**
     * Gets right lane.
     * @return the right lane
     */
    public Lane getRightLane() {
        return rightLane;
    }

    /**
     * Sets right lane.
     * @param rightLane the right lane
     */
    public void setRightLane(Lane rightLane) {
        this.rightLane = rightLane;
    }

    /**
     * Gets top lane.
     * @return the top lane
     */
    public Lane getTopLane() {
        return topLane;
    }

    /**
     * Sets top lane.
     * @param topLane the top lane
     */
    public void setTopLane(Lane topLane) {
        this.topLane = topLane;
    }

    /**
     * Gets bottom lane.
     * @return the bottom lane
     */
    public Lane getBottomLane() {
        return bottomLane;
    }

    /**
     * Sets bottom lane.
     * @param bottomLane the bottom lane
     */
    public void setBottomLane(Lane bottomLane) {
        this.bottomLane = bottomLane;
    }

    /**
     * Gets left lane.
     * @return the left lane
     */
    public Lane getLeftLane() {
        return leftLane;
    }
}
