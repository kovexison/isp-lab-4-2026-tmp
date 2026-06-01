package edu.tucn.aut.isp.lab4.exercise6;

public class Actuator {
    private String manufacturer;
    private String model;
    private boolean isOn;

    public Actuator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    @Override
    public String toString() {
        return "Actuator{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}
