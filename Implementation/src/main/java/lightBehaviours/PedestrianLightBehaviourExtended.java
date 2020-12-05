package lightBehaviours;

import lights.PedestrianObserverLight;

public enum PedestrianLightBehaviourExtended implements PedestrianLightBehaviour {
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

    GREEN("green") {
        @Override
        public LightBehaviour getNextState() {
            return GREENBLINKING;
        }

        @Override
        public String changeColor(PedestrianObserverLight pedestrianLight) {
            pedestrianLight.setChangeBehaviour(GREENBLINKING);
            return GREENBLINKING.getColor();
        }
    },

    GREENBLINKING("greenblinking") {
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

    PedestrianLightBehaviourExtended(String color) {this.color = color;}


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
