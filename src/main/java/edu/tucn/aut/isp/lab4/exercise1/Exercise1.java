package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class Exercise1 {

    public static void main(String[] args) {
        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A1000",
                LocalTime.of(8, 0));
        System.out.println(controller);
        controller.setCurrentTime(LocalTime.of(12, 0));
        System.out.println(controller);
    }
}
