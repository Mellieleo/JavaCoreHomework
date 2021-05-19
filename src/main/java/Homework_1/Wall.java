package Homework_1;

public class Wall {
    private int maxJump;

    public void jump(Object obj, int height) {
        if (height<=maxJump) {
            System.out.println(obj.toString() + " jumped on " + height + " metres.");
        } else {
            System.out.println(obj.toString() + " can't jump this high.");
        }
    }

}
