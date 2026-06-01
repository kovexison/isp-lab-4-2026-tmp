package edu.tucn.aut.isp.lab4.exercise5;

import java.time.LocalTime;

public class AquariumController {
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder feeder;
    private int presetTemperature;
    private float presetLevel;
    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;
    private Actuator alarm;
    private Actuator heater;

    public AquariumController(String manufacturer,
                              String model,
                              FishFeeder feeder,
                              LocalTime feedingTime,
                              LocalTime currentTime,
                              int presetTemperature,
                              float presetLevel,
                              LevelSensor levelSensor,
                              TemperatureSensor temperatureSensor,
                              Actuator alarm,
                              Actuator heater) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
        this.feedingTime = feedingTime;
        this.currentTime = currentTime;
        this.presetTemperature = presetTemperature;
        this.presetLevel = presetLevel;
        this.levelSensor = levelSensor;
        this.temperatureSensor = temperatureSensor;
        this.alarm = alarm;
        this.heater = heater;
    }

    public Actuator getAlarm() {
        return alarm;
    }

    public Actuator getHeater() {
        return heater;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if (feedingTime != null && feedingTime.equals(currentTime) && feeder != null) {
            feeder.feed();
        }
    }

    public void checkWaterLevel() {
        if (levelSensor == null || alarm == null) {
            return;
        }
        if (levelSensor.getValue() < presetLevel) {
            alarm.turnOn();
        } else {
            alarm.turnOff();
        }
    }

    public void checkTemperature() {
        if (temperatureSensor == null || heater == null) {
            return;
        }
        if (temperatureSensor.getValue() < presetTemperature) {
            heater.turnOn();
        } else {
            heater.turnOff();
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", presetTemperature=" + presetTemperature +
                ", presetLevel=" + presetLevel +
                ", feeder=" + feeder +
                ", levelSensor=" + levelSensor +
                ", temperatureSensor=" + temperatureSensor +
                ", alarm=" + alarm +
                ", heater=" + heater +
                '}';
    }
}
