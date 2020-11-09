package lightBehaviours;

import lights.StraightTrafficLight;

public enum StraightTrafficLightBehaviourGermany implements StraightTrafficLightBehaviour {
    RED("red") {
        @Override
        public String changeColor(StraightTrafficLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(REDYELLOW);
            return REDYELLOW.getColor();
        }
    },

    REDYELLOW("red and yellow") {
        @Override
        public String changeColor(StraightTrafficLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(GREEN);
            return GREEN.getColor();
        }
    },

    GREEN("green") {
        @Override
        public String changeColor(StraightTrafficLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(YELLOW);
            return YELLOW.getColor();
        }
    },

    YELLOW("yellow") {
        @Override
        public String changeColor(StraightTrafficLight straightTrafficLight) {
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
}