package dk.via.session6.exercise6_1;

public class Red implements TrafficLightState {
    private final TrafficLight trafficLight;

    public Red(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void next() {
        trafficLight.turnOn(Lights.YELLOW);
        trafficLight.setState(new YellowRed(trafficLight));
    }
}
