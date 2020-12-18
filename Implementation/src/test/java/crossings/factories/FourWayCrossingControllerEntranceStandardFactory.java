package crossings.factories;

import lightBehaviours.PedestrianLightBehaviour;
import lightBehaviours.StraightTrafficLightBehaviour;
import lights.Location;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

public class FourWayCrossingControllerEntranceStandardFactory {
    //hardcoded values
    private final int numberOfLightsForVehicles = 3;
    private final int numberOfLightsForPedestrians = 2;
    //all number of lights is for straight crossings
    //Vehicles number of lights per lane
    int straightNumberLightsLeftVehicles;
    int straightNumberLightsRightVehicles;
    int straightNumberLightsTopVehicles;
    int straightNumberLightsBottomVehicles;
    //Pedestrians number of lights per lane
    int straightNumberLightsLeftPedestrians;
    int straightNumberLightsRightPedestrians;
    int straightNumberLightsTopPedestrians;
    int straightNumberLightsBottomPedestrians;
    //Vehicles traffic light behaviour
    @Mock
    StraightTrafficLightBehaviour straightTrafficLightBehaviour;
    //Pedestrian traffic light behaviour
    @Mock
    PedestrianLightBehaviour pedestrianLightBehaviour;
    //GoDuration Vehicles
    int goDurationVehiclesLight;
    int goDurationPedestriansLight;
    //CycleTimeVehicles
    int cycleTimeVehiclesLight;
    int cycleTimePedestrianLight;
    //Location
    @Mock
    Location location;
    int secondsBetweenLaneSwitch;

    @BeforeEach
    void setUp() {
        //Initialize number of lights for Vehicles
        this.straightNumberLightsLeftVehicles = this.numberOfLightsForVehicles;
        this.straightNumberLightsRightVehicles = this.numberOfLightsForVehicles;
        this.straightNumberLightsTopVehicles = this.numberOfLightsForVehicles;
        this.straightNumberLightsBottomVehicles = this.numberOfLightsForVehicles;
        //Initialize number of lights for Pedestrians
        this.straightNumberLightsLeftPedestrians = this.numberOfLightsForPedestrians;
        this.straightNumberLightsRightPedestrians = this.numberOfLightsForPedestrians;
        this.straightNumberLightsTopPedestrians = this.numberOfLightsForPedestrians;
        this.straightNumberLightsBottomPedestrians = this.numberOfLightsForPedestrians;
    }
}
