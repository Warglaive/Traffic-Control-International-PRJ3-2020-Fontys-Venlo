package crossings;

import java.util.Map;

public interface Crossing {

    void changeController(
            Map<LaneType, Map<LaneControllerType, Map<LaneParameterKey, Object>>> parameterList,
            int secondsBetweenLaneSwitch
    );

    FourWayCrossingControllerEntrance getController();

    void setController(FourWayCrossingControllerEntrance controller);

    void cycleLanes();
}
