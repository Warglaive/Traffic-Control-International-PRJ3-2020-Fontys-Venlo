package ui;

import crossings.fourWay.FourWayCrossing;
import crossings.fourWay.FourWayCrossingEntranceStandard;
import crossings.parameterEnums.LaneControllerType;
import crossings.parameterEnums.LaneParameterKey;
import crossings.parameterEnums.LaneType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lightBehaviours.LightBehaviour;
import lightBehaviours.PedestrianLightBehaviourStandard;
import lightBehaviours.StraightTrafficLightBehaviourGermany;
import lights.Location;
import ui.UICrossing.UIFourWayCrossingEntrance;
import ui.UICrossing.UIFourWayCrossingEntranceObserver;

import java.util.HashMap;
import java.util.Map;

import static crossings.parameterEnums.LaneControllerType.PEDESTRIAN;
import static crossings.parameterEnums.LaneControllerType.STRAIGHT;
import static crossings.parameterEnums.LaneParameterKey.*;
import static crossings.parameterEnums.LaneType.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        var loader = new FXMLLoader(getClass().getClassLoader().getResource("Intersection.fxml"));

        Parent root = loader.load();
        Scene intersections = new Scene(root);

        primaryStage.setTitle("Traffic");
        primaryStage.setScene(intersections);

        primaryStage.show();

        var namespace = loader.getNamespace();

        var fourWayCrossing = this.getStandardBusinessCrossing();
        var fourWayCrossingController = fourWayCrossing.getController();

        var ui = new UIFourWayCrossingEntranceObserver(
                fourWayCrossingController.getLeftLane(),
                fourWayCrossingController.getRightLane(),
                fourWayCrossingController.getTopLane(),
                fourWayCrossingController.getBottomLane(),
                namespace
        );


        var thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                  var executionThread = new Thread((Runnable) fourWayCrossing);
                    executionThread.start();
                    try {
                        executionThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
//        executionThread.start();
//        while (true) {
//            if (!executionThread.isAlive()) {
//                executionThread.start();

            }




    public static void main(String[] args) {
        launch(args);
    }

    private FourWayCrossing getStandardBusinessCrossing() {
        var goDuration = 5;
        var cycleTime = 2;
        var straightLightBehaviour = StraightTrafficLightBehaviourGermany.RED;
        var pedestrianLightBehaviour = PedestrianLightBehaviourStandard.RED;
        var location = new Location();

        var secondsBetweenLaneSwitch = 2;

        var fourWayCrossing = new FourWayCrossingEntranceStandard(
                getFourLaneParamMap(
                        goDuration,
                        cycleTime,
                        straightLightBehaviour,
                        pedestrianLightBehaviour,
                        location
                ),
                secondsBetweenLaneSwitch
        );

        return fourWayCrossing;
    }

    private Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> getFourLaneParamMap(
            int goDuration, int cycleTime, LightBehaviour straightLightBehaviour, LightBehaviour pedestrianLightBehaviour, Location location) {

        var fourLanes = new HashMap();

        fourLanes.put(LEFT_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(RIGHT_LANE, getLaneParamMap(
                goDuration, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(TOP_LANE, getLaneParamMap(
                goDuration+2, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));
        fourLanes.put(BOTTOM_LANE, getLaneParamMap(
                goDuration+2, cycleTime, straightLightBehaviour, pedestrianLightBehaviour, location
        ));

        return fourLanes;
    }

    private Map<LaneControllerType, Object> getLaneParamMap(
            int goDuration, int cycleTime, LightBehaviour straightLightBehaviour, LightBehaviour pedestrianLightBehaviour, Location location) {
        var laneMap = new HashMap();
        putLaneParamMap(laneMap, goDuration, cycleTime, straightLightBehaviour, location, STRAIGHT);
        putLaneParamMap(laneMap, goDuration+1, cycleTime, pedestrianLightBehaviour, location, PEDESTRIAN);

        return laneMap;
    }

    private void putLaneParamMap(
            Map<LaneControllerType, Object> laneMap, int goDuration, int cycleTime, LightBehaviour lightBehaviour, Location location, LaneControllerType laneControllerType) {

        laneMap.put(laneControllerType, getControllerParamMap(
                goDuration,
                cycleTime,
                lightBehaviour,
                location
        ));
    }

    private Map<LaneParameterKey, Object> getControllerParamMap(
            int goDuration, int cycleTime, LightBehaviour lightBehaviour, Location location) {

        var laneStraightParams = new HashMap();
        laneStraightParams.put(NUMBER_LIGHTS, 2);
        laneStraightParams.put(LIGHT_BEHAVIOUR, lightBehaviour);
        laneStraightParams.put(LOCATION, location);
        laneStraightParams.put(GO_DURATION, goDuration);
        laneStraightParams.put(CYCLE_TIME, cycleTime);

        return laneStraightParams;
    }

}
