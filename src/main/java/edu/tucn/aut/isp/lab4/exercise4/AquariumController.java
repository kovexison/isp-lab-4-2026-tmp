package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class AquariumController {
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private LocalTime lightOnTime;
    private LocalTime lightsOffTime;
    private FishFeeder feeder;
    private Lights lights;

    public AquariumController(String manufacturer,
                              String model,
                              FishFeeder feeder,
                              Lights lights,
                              LocalTime feedingTime,
                              LocalTime lightOnTime,
                              LocalTime lightsOffTime,
                              LocalTime currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
        this.lights = lights;
        this.feedingTime = feedingTime;
        this.lightOnTime = lightOnTime;
        this.lightsOffTime = lightsOffTime;
        this.currentTime = currentTime;
    }

    public FishFeeder getFeeder() {
        return feeder;
    }

    public Lights getLights() {
        return lights;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (feedingTime != null && feedingTime.equals(currentTime) && feeder != null) {
            feeder.feed();
        }
        updateLights();
    }

    private void updateLights() {
        if (lights == null || lightOnTime == null || lightsOffTime == null || currentTime == null) {
            return;
        }
        boolean shouldBeOn = !currentTime.isBefore(lightOnTime) && currentTime.isBefore(lightsOffTime);
        if (shouldBeOn) {
            lights.turnOn();
        } else {
            lights.turnOff();
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", lightOnTime=" + lightOnTime +
                ", lightsOffTime=" + lightsOffTime +
                ", feeder=" + feeder +
                ", lights=" + lights +
                '}';
    }
}
