package edu.tucn.aut.isp.lab4.exercise1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class AquariumControllerTest {
    @Test
    void currentTimeUpdatesToString() {
        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A1000",
                LocalTime.of(8, 0));

        String before = controller.toString();
        controller.setCurrentTime(LocalTime.of(10, 30));
        String after = controller.toString();

        Assertions.assertNotEquals(before, after);
        Assertions.assertTrue(after.contains("10:30"));
    }
}
