package lightBehaviours;

import lights.PedestrianObserverLight;

public enum PedestrianLightBehaviourStandard implements PedestrianLightBehaviour {
    RED("red") {
        @Override
        public String changeColor(PedestrianObserverLight pedestrianLight) {
            pedestrianLight.setChangeBehaviour(GREEN);
            return GREEN.getColor();
        }
    },

    GREEN("green") {
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
}
