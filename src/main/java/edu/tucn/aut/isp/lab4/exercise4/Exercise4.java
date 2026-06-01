package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class Exercise4 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("AquaCorp", "F200", 4);
        Lights lights = new Lights();
        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A2000",
                feeder,
                lights,
                LocalTime.of(12, 0),
                LocalTime.of(8, 0),
                LocalTime.of(16, 0),
                LocalTime.of(7, 30));

        controller.setCurrentTime(LocalTime.of(9, 0));
        System.out.println("Lights on: " + lights.isOn());
        controller.setCurrentTime(LocalTime.of(16, 0));
        System.out.println("Lights on: " + lights.isOn());
    }
}
