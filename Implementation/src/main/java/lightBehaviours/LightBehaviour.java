package lightBehaviours;

import lights.Light;

public interface LightBehaviour {
    String changeColor(Light light);
    String getColor();
}
