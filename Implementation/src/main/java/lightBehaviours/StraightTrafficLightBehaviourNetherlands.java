package lightBehaviours;

import lights.StraightTrafficObserverLight;

public enum StraightTrafficLightBehaviourNetherlands implements StraightTrafficLightBehaviour {
    RED("red") {
        @Override
        public String changeColor(StraightTrafficObserverLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(GREEN);
            return GREEN.getColor();
        }
    },

    GREEN("green") {
        @Override
        public String changeColor(StraightTrafficObserverLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(YELLOW);
            return YELLOW.getColor();
        }
    },

    YELLOW("yellow") {
        @Override
        public String changeColor(StraightTrafficObserverLight straightTrafficLight) {
            straightTrafficLight.setChangeBehaviour(RED);
            return RED.getColor();
        }
    };

    private String color;

    StraightTrafficLightBehaviourNetherlands(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

