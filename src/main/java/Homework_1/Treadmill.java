package Homework_1;

public abstract class Treadmill {

    private int maxRun;

    public void run(Object obj, int distance) {
        if (distance<=maxRun) {
            System.out.println(obj + " ran " + distance + " metres.");
        } else {
            System.out.println(obj + " can't run this far.");
        }
    }


}
