package edu.tucn.aut.isp.lab4.exercise3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class AquariumControllerTest {

    @Test
    void settingFeedingTimeTriggersFeeder() {
        FishFeeder feeder = new FishFeeder("AquaCorp", "F200", 3);
        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A1000",
                feeder,
                LocalTime.of(10, 0),
                LocalTime.of(9, 0));

        controller.setCurrentTime(LocalTime.of(10, 0));
        Assertions.assertEquals(2, feeder.getMeals());
    }
}
