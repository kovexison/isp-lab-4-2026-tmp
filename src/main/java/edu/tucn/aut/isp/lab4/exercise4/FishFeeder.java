package edu.tucn.aut.isp.lab4.exercise4;

public class FishFeeder {
    public static final int MAX_MEALS = 14;

    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    public int getMeals() {
        return meals;
    }

    public void fillUp() {
        meals = MAX_MEALS;
        System.out.println("FishFeeder refilled to " + MAX_MEALS + " meals.");
    }

    public void feed() {
        if (meals > 0) {
            meals--;
            System.out.println("FishFeeder served one meal. Remaining meals: " + meals + ".");
        } else {
            System.out.println("FishFeeder is empty. Please refill.");
        }
    }

    @Override
    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", meals=" + meals +
                '}';
    }
}
