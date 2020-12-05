package lightBehaviours;

import lights.StraightTrafficObserverLight;

public enum StraightTrafficLightBehaviourGermany implements StraightTrafficLightBehaviour {
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