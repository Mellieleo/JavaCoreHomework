package Homework_1;

public class Cat implements Abilities {

    @Override
    public void canRun() {
        System.out.println("I run!!!");
    }

    @Override
    public void canJump() {
        System.out.println("I jump!!!");
    }

    @Override
    public int maxRun() {
        return 850;
    }

    @Override
    public int maxJump() {
        return 60;
    }

    private final String name;
    private int age;

    public Cat (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

}
