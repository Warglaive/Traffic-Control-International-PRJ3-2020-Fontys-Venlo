package lights;

import annotations.Generated;
import lightBehaviours.LightBehaviour;
import locations.Location;

public interface Light {
    void changeColor();

    void setChangeBehaviour(LightBehaviour changeBehaviour);

    LightBehaviour getChangeBehaviour();

    Location getLocation();

}
