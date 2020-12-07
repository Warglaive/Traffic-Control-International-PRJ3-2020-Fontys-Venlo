package lightBehaviours;

import lights.StraightTrafficObserverLight;

/**
 * The enum Straight traffic light behaviour germany.
 */
public enum StraightTrafficLightBehaviourGermany implements StraightTrafficLightBehaviour {
    /**
     * The Red.
     */
    RED("red") {
        @Override
        public LightBehaviour getNextState() {
            return REDYELLOW;
        }

        @Override
        public String changeColor(StraightTrafficObserverLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(REDYELLOW);
            return REDYELLOW.getColor();
        }
    },

    /**
     * The Redyellow.
     */
    REDYELLOW("redYellow") {
        @Override
        public LightBehaviour getNextState() {
            return GREEN;
        }

        @Override
        public String changeColor(StraightTrafficObserverLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(GREEN);
            return GREEN.getColor();
        }
    },

    /**
     * The Green.
     */
    GREEN("green") {
        @Override
        public LightBehaviour getNextState() {
            return YELLOW;
        }

        @Override
        public String changeColor(StraightTrafficObserverLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(YELLOW);
            return YELLOW.getColor();
        }
    },

    /**
     * The Yellow.
     */
    YELLOW("yellow") {
        @Override
        public LightBehaviour getNextState() {
            return RED;
        }

        @Override
        public String changeColor(StraightTrafficObserverLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(RED);
            return RED.getColor();
        }
    };


    private String color;

    StraightTrafficLightBehaviourGermany(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
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