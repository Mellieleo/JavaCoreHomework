package Homework_1;

public class Robot implements Abilities {

    @Override
    public void canRun() {
        System.out.println("I am running.");
    }

    @Override
    public void canJump() {
        System.out.println("I am jumping.");
    }

    @Override
    public int maxRun() {
        return 300;
    }

    @Override
    public int maxJump() {
        return 10;
    }

    private final String model;
    private int prodYear;

    public Robot (String model, int prodYear) {
        this.model = model;
        this.prodYear = prodYear;
    }

    public String getModel() {
        return model;
    }
}
