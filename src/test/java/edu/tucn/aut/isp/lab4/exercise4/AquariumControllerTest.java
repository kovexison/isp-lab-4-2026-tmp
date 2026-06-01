package edu.tucn.aut.isp.lab4.exercise4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class AquariumControllerTest {

    @Test
    void lightsTurnOnAndOffBasedOnTime() {
        FishFeeder feeder = new FishFeeder("AquaCorp", "F200", 3);
        Lights lights = new Lights();
        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A2000",
                feeder,
                lights,
                LocalTime.of(12, 0),
                LocalTime.of(8, 0),
                LocalTime.of(14, 0),
                LocalTime.of(7, 0));

        controller.setCurrentTime(LocalTime.of(9, 0));
        Assertions.assertTrue(lights.isOn());

        controller.setCurrentTime(LocalTime.of(14, 0));
        Assertions.assertFalse(lights.isOn());
    }
}
