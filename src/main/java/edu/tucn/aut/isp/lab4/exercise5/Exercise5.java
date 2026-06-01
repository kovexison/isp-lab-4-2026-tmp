package edu.tucn.aut.isp.lab4.exercise5;

import java.time.LocalTime;

public class Exercise5 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("AquaCorp", "F300", 6);
        LevelSensor levelSensor = new LevelSensor("AquaCorp", "L100", 10);
        TemperatureSensor temperatureSensor = new TemperatureSensor("AquaCorp", "T100", 23.5f);
        Alarm alarm = new Alarm("AquaCorp", "AL1");
        Heater heater = new Heater("AquaCorp", "H1");

        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A3000",
                feeder,
                LocalTime.of(12, 0),
                LocalTime.of(11, 0),
                24,
                12.0f,
                levelSensor,
                temperatureSensor,
                alarm,
                heater);

        controller.checkWaterLevel();
        controller.checkTemperature();
        System.out.println("Alarm on: " + alarm.isOn());
        System.out.println("Heater on: " + heater.isOn());
    }
}
