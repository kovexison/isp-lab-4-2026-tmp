package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("AquaCorp", "F200", 5);
        AquariumController controller = new AquariumController(
                "AquaCorp",
                "A1000",
                feeder,
                LocalTime.of(12, 0),
                LocalTime.of(11, 0));

        System.out.println(controller);
        controller.setCurrentTime(LocalTime.of(12, 0));
        System.out.println("Meals after feeding: " + feeder.getMeals());
    }
}
