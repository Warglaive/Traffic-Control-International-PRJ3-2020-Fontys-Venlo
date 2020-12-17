package lightBehaviours;

import lights.observer.PedestrianObserverLight;

/**
 * The enum Pedestrian light behaviour standard.
 */
public enum PedestrianLightBehaviourStandard implements PedestrianLightBehaviour {
    /**
     * The Red.
     */
    RED("red") {
        @Override
        public LightBehaviour getNextState() {
            return GREEN;
        }

        @Override
        public String changeColor(PedestrianObserverLight pedestrianLight) {
            pedestrianLight.setChangeBehaviour(GREEN);
            return GREEN.getColor();
        }
    },

    /**
     * The Green.
     */
    GREEN("green") {
        @Override
        public LightBehaviour getNextState() {
            return RED;
        }

        @Override
        public String changeColor(PedestrianObserverLight pedestrianLight) {
            pedestrianLight.setChangeBehaviour(RED);
            return RED.getColor();
        }
    };

    private String color;

    PedestrianLightBehaviourStandard(String color) {
        this.color = color;
    }


    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public LightBehaviour getGoState() {
        return GREEN;
    }

    @Override
    public LightBehaviour getStopState() {
        return RED;
    }
}
