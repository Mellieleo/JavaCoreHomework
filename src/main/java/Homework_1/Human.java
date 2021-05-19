package Homework_1;

public class Human implements Abilities {

    @Override
    public void canRun() {
        System.out.println("I'm running!");
    }

    @Override
    public void canJump() {
        System.out.println("I'm jumping!");
    }

    @Override
    public int maxRun() {
        return 500;
    }

    @Override
    public int maxJump() {
        return 30;
    }

    private final String name;
    private int age;

    public Human (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
