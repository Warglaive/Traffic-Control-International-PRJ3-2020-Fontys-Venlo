package lightBehaviours;

import lights.ObserverLight;

public interface LightBehaviour {
    String changeColor(ObserverLight observerLight);
    String getColor();
}
