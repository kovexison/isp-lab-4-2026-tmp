package edu.tucn.aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("AquaCorp", "F200", 2);
        System.out.println(feeder);
        feeder.feed();
        feeder.feed();
        feeder.feed();
        feeder.fillUp();
        System.out.println(feeder);
    }
}
