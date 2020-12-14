package crossings;

import lane.Lane;
import lightBehaviours.StraightTrafficLightBehaviour;
import locations.Location;

import static crossings.LaneParameterKey.*;
import static crossings.LaneType.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class FourWayCrossingControllerEntrance implements FourWayCrossingController {
    private Lane leftLane;
    private Lane rightLane;
    private Lane topLane;
    private Lane bottomLane;
    private int secondsBetweenLaneSwitch;

    public FourWayCrossingControllerEntrance(
            Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList, int secondsBetweenLaneSwitch) {
        this.changeLeftLane(parameterList.get(LEFT_LANE));
        this.changeRightLane(parameterList.get(RIGHT_LANE));
        this.changeTopLane(parameterList.get(TOP_LANE));
        this.changeBottomLane(parameterList.get(BOTTOM_LANE));

        this.secondsBetweenLaneSwitch = secondsBetweenLaneSwitch;
    }

    @Override
    public void cycleLanes() {
        this.threadOperation(topLane, bottomLane, rightLane, leftLane);
        this.threadOperation(rightLane, leftLane, topLane, bottomLane);
    }

    private void threadOperation(Lane straightOne, Lane straightTwo, Lane pedestrianThree, Lane pedestrianFour) {
        Thread straightOneLaneThread = new Thread((Runnable) straightOne.getStraightLaneController());
        Thread straightTwoLaneThread = new Thread((Runnable) straightTwo.getStraightLaneController());
        Thread pedestrianThreeLaneThread = new Thread((Runnable) pedestrianThree.getPedestrianLaneController());
        Thread pedestrianFourLaneThread = new Thread((Runnable) pedestrianFour.getPedestrianLaneController());

        straightOneLaneThread.start();
        straightTwoLaneThread.start();
        pedestrianThreeLaneThread.start();
        pedestrianFourLaneThread.start();

        try {
            straightOneLaneThread.join();
            straightTwoLaneThread.join();
            pedestrianThreeLaneThread.join();
            pedestrianFourLaneThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
            //TODO: Proper exception handling
        }

        try {
            TimeUnit.SECONDS.sleep(secondsBetweenLaneSwitch);
        } catch (InterruptedException e) {
            //TODO: Proper exception handling
            e.printStackTrace();
        }
    }

    public abstract void changeLeftLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );

    public abstract void changeRightLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );

    public abstract void changeTopLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );

    public abstract void changeBottomLane(
            Map<LaneControllerType, Map<LaneParameterKey, Object>> parameterList
    );

    public void setLeftLane(Lane leftLane) {
        this.leftLane = leftLane;
    }

    public Lane getRightLane() {
        return rightLane;
    }

    public void setRightLane(Lane rightLane) {
        this.rightLane = rightLane;
    }

    public Lane getTopLane() {
        return topLane;
    }

    public void setTopLane(Lane topLane) {
        this.topLane = topLane;
    }

    public Lane getBottomLane() {
        return bottomLane;
    }

    public void setBottomLane(Lane bottomLane) {
        this.bottomLane = bottomLane;
    }

    public Lane getLeftLane() {
        return leftLane;
    }
}
