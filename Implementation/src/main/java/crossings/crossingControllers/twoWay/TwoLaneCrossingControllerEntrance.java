package crossings.crossingControllers.twoWay;

import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import lane.Lane;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static crossings.parameterEnums.LaneType.LEFT_LANE;
import static crossings.parameterEnums.LaneType.RIGHT_LANE;

public abstract class TwoLaneCrossingControllerEntrance implements TwoWayCrossingController {
    /**
     * The lanes belonging to a crossing
     */
    private Lane leftLane;
    private Lane rightLane;
    /**
     * The time before the next lane start its cycle
     */

    private int secondsBetweenLaneSwitch;

    public TwoLaneCrossingControllerEntrance(Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        this.changeLeftLane(parameterList.get(LEFT_LANE));
        this.changeRightLane(parameterList.get(RIGHT_LANE));
        this.secondsBetweenLaneSwitch = secondsBetweenLaneSwitch;
    }

    /**
     * @param straightLeftLane left straight controller that has to be cycled.
     * @param straightRightLane right straight controller that has to be cycled
     * @throws InterruptedException
     */

    private void threadOperation(Lane straightLeftLane, Lane straightRightLane) throws InterruptedException {
        //Create threads out of given lanes
        Thread straightLeftLaneThread = new Thread((Runnable) straightLeftLane.getStraightLaneController());
        Thread straightRightLaneThread = new Thread((Runnable) straightRightLane.getStraightLaneController());

        Thread pedestrianLeft = new Thread((Runnable) straightLeftLane.getPedestrianLaneController());
        Thread pedestrianRight = new Thread((Runnable) straightRightLane.getPedestrianLaneController());
        //Pedestrian Lanes

        //cycleLights
        straightLeftLaneThread.start();
        straightRightLaneThread.start();

        try {
            straightLeftLaneThread.join();
            straightRightLaneThread.join();
        } catch (InterruptedException e) {
            throw new InterruptedException("Threads failed to join at: TwoLaneCrossingControllerEntrance.java lane 46");
        }

        pedestrianLeft.start();
        pedestrianRight.start();

        try {
            pedestrianLeft.join();
            pedestrianRight.join();
        } catch (InterruptedException e) {
            throw new InterruptedException("Threads failed to join at: TwoLaneCrossingControllerEntrance.java lane 61");
        }

        try {
            TimeUnit.SECONDS.sleep(secondsBetweenLaneSwitch);
        } catch (InterruptedException e) {
            throw new InterruptedException("Threads failed to join at: TwoLaneCrossingControllerEntrance.java lane 65");
        }
    }

    /**
     * Before threadOperation specified cycle, this method decides in what order are lights being switched ON and OFF
     */

    @Override
    public void cycleLanes() throws InterruptedException {
        this.threadOperation(this.rightLane, this.leftLane);
        this.threadOperation(this.rightLane, this.rightLane);
    }

    /**
     * Creates a new left lane and sets it with the given parameters.
     *
     * @param parameterList Required parameters for constructing a lane
     */
    public abstract void changeLeftLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList);

    /**
     * Creates a new right lane and sets it with the given parameters.
     *
     * @param parameterList Required parameters for constructing a lane
     */
    public abstract void changeRightLane(Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList);

    /**
     * Gets left lane.
     *
     * @return the left lane
     */
    public Lane getLeftLane() {
        return leftLane;
    }

    /**
     * Sets left lane.
     *
     * @param leftLane the left lane
     */
    public void setLeftLane(Lane leftLane) {
        this.leftLane = leftLane;
    }

    /**
     * Gets right lane.
     *
     * @return the right lane
     */
    public Lane getRightLane() {
        return rightLane;
    }

    /**
     * Sets right lane.
     *
     * @param rightLane the right lane
     */
    public void setRightLane(Lane rightLane) {
        this.rightLane = rightLane;
    }
}
