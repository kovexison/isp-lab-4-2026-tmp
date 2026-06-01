package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class AquariumController {
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder feeder;

    public AquariumController(String manufacturer, String model, FishFeeder feeder, LocalTime feedingTime, LocalTime currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
        this.feedingTime = feedingTime;
        this.currentTime = currentTime;
    }

    public FishFeeder getFeeder() {
        return feeder;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (feedingTime != null && feedingTime.equals(currentTime) && feeder != null) {
            feeder.feed();
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", feeder=" + feeder +
                '}';
    }
}
