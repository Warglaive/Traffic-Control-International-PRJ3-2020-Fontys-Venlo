package lightBehaviours;

import lights.PedestrianLight;

public enum PedestrianLightBehaviourExtended implements PedestrianLightBehaviour {
    RED("red") {
        @Override
        public String changeColor(PedestrianLight pedestrianLight) {
            pedestrianLight.setChangeBehaviour(GREEN);
            return GREEN.getColor();
        }
    },

    GREEN("green") {
        @Override
        public String changeColor(PedestrianLight pedestrianLight) {
            pedestrianLight.setChangeBehaviour(GREENBLINKING);
            return GREENBLINKING.getColor();
        }
    },

    GREENBLINKING("greenblinking") {
        @Override
        public String changeColor(PedestrianLight pedestrianLight) {
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
}
