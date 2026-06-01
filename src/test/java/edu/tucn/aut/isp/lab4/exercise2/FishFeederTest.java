package edu.tucn.aut.isp.lab4.exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FishFeederTest {

    @Test
    void fillUpResetsMeals() {
        FishFeeder feeder = new FishFeeder("AquaCorp", "F200", 3);
        feeder.fillUp();
        Assertions.assertEquals(FishFeeder.MAX_MEALS, feeder.getMeals());
    }

    @Test
    void feedDecreasesMeals() {
        FishFeeder feeder = new FishFeeder("AquaCorp", "F200", 2);
        feeder.feed();
        Assertions.assertEquals(1, feeder.getMeals());
    }
}
