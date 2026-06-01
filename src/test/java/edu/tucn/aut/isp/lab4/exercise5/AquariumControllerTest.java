package edu.tucn.aut.isp.lab4.exercise5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class AquariumControllerTest {

    @Test
    void waterLevelControlsAlarm() {
        LevelSensor levelSensor = new LevelSensor("AquaCorp", "L100", 5);
        TemperatureSensor temperatureSensor = new TemperatureSensor("AquaCorp", "T100", 25.0f);
        Alarm alarm = new Alarm("AquaCorp", "AL1");
        Heater heater = new Heater("AquaCorp", "H1");
        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A3000",
                new FishFeeder("AquaCorp", "F300", 3),
                LocalTime.of(12, 0),
                LocalTime.of(11, 0),
                24,
                10.0f,
                levelSensor,
                temperatureSensor,
                alarm,
                heater);

        controller.checkWaterLevel();
        Assertions.assertTrue(alarm.isOn());

        levelSensor.setValue(12);
        controller.checkWaterLevel();
        Assertions.assertFalse(alarm.isOn());
    }

    @Test
    void temperatureControlsHeater() {
        LevelSensor levelSensor = new LevelSensor("AquaCorp", "L100", 12);
        TemperatureSensor temperatureSensor = new TemperatureSensor("AquaCorp", "T100", 23.0f);
        Alarm alarm = new Alarm("AquaCorp", "AL1");
        Heater heater = new Heater("AquaCorp", "H1");
        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A3000",
                new FishFeeder("AquaCorp", "F300", 3),
                LocalTime.of(12, 0),
                LocalTime.of(11, 0),
                24,
                10.0f,
                levelSensor,
                temperatureSensor,
                alarm,
                heater);

        controller.checkTemperature();
        Assertions.assertTrue(heater.isOn());

        temperatureSensor.setValue(24.0f);
        controller.checkTemperature();
        Assertions.assertFalse(heater.isOn());
    }
}
