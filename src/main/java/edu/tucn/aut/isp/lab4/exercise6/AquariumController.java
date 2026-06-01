package edu.tucn.aut.isp.lab4.exercise6;

import java.time.LocalTime;

public class AquariumController {
    private static final float MIN_PH = 6.5f;
    private static final float MAX_PH = 7.5f;

    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private FishFeeder feeder;
    private int presetTemperature;
    private float presetLevel;
    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;
    private PhSensor phSensor;
    private Actuator alarm;
    private Actuator heater;
    private Actuator phAlarm;

    public AquariumController(String manufacturer,
                              String model,
                              FishFeeder feeder,
                              LocalTime feedingTime,
                              LocalTime currentTime,
                              int presetTemperature,
                              float presetLevel,
                              LevelSensor levelSensor,
                              TemperatureSensor temperatureSensor,
                              PhSensor phSensor,
                              Actuator alarm,
                              Actuator heater,
                              Actuator phAlarm) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
        this.feedingTime = feedingTime;
        this.currentTime = currentTime;
        this.presetTemperature = presetTemperature;
        this.presetLevel = presetLevel;
        this.levelSensor = levelSensor;
        this.temperatureSensor = temperatureSensor;
        this.phSensor = phSensor;
        this.alarm = alarm;
        this.heater = heater;
        this.phAlarm = phAlarm;
    }

    public Actuator getAlarm() {
        return alarm;
    }

    public Actuator getHeater() {
        return heater;
    }

    public Actuator getPhAlarm() {
        return phAlarm;
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

    public void checkPh() {
        if (phSensor == null || phAlarm == null) {
            return;
        }
        float value = phSensor.getValue();
        if (value < MIN_PH || value > MAX_PH) {
            phAlarm.turnOn();
        } else {
            phAlarm.turnOff();
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
                ", phSensor=" + phSensor +
                ", alarm=" + alarm +
                ", heater=" + heater +
                ", phAlarm=" + phAlarm +
                '}';
    }
}
