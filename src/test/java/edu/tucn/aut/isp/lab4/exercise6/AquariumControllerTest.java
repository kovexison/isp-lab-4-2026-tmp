package edu.tucn.aut.isp.lab4.exercise6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class AquariumControllerTest {

    @Test
    void phOutOfRangeTurnsOnAlarm() {
        LevelSensor levelSensor = new LevelSensor("AquaCorp", "L200", 12);
        TemperatureSensor temperatureSensor = new TemperatureSensor("AquaCorp", "T200", 25.0f);
        PhSensor phSensor = new PhSensor("AquaCorp", "P200", 6.0f);
        Alarm alarm = new Alarm("AquaCorp", "AL2");
        Heater heater = new Heater("AquaCorp", "H2");
        Alarm phAlarm = new Alarm("AquaCorp", "PH1");

        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A4000",
                new FishFeeder("AquaCorp", "F400", 3),
                LocalTime.of(12, 0),
                LocalTime.of(11, 0),
                24,
                10.0f,
                levelSensor,
                temperatureSensor,
                phSensor,
                alarm,
                heater,
                phAlarm);

        controller.checkPh();
        Assertions.assertTrue(phAlarm.isOn());

        phSensor.setValue(7.0f);
        controller.checkPh();
        Assertions.assertFalse(phAlarm.isOn());
    }
}
