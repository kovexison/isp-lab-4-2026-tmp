package edu.tucn.aut.isp.lab4.exercise4;

public class Lights {
    private boolean isOn;

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Lights turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Lights turned off.");
    }

    @Override
    public String toString() {
        return "Lights{" +
                "isOn=" + isOn +
                '}';
    }
}
