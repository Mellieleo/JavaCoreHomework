package Homework_1;

public class Main {
    public static void main(String[] args) {
        Human joe = new Human("Joe", 23);
        Cat lucky = new Cat("Lucky", 4);
        Robot ra9 = new Robot("ra9", 2018);

        ra9.canJump();
        ra9.canRun();
        joe.canJump();
        joe.canRun();
        lucky.canJump();
        lucky.canRun();

        Treadmill a = new Treadmill() {
            @Override
            public void run(Object obj, int distance) {
                super.run(obj, distance);
            }
        };
        a.run(lucky, 500);
    }
}
