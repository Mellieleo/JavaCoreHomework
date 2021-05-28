package Homework_3;

import java.util.Arrays;

public class Main {

    public static <T> void swap(T[] array) {
        T temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    public static void main(String[] args) {
        String[] array = {"16", "bfee", "4782", "1"};
        swap(array);
        System.out.println(Arrays.toString(array));

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> appleBox = new Box<>(apple1, apple2, apple3);
        System.out.println(appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>(orange1, orange2, orange3, orange4);
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Apple newApple = new Apple();
        appleBox.addNew(newApple);
        System.out.println(appleBox.getWeight());

        Box<Orange> otherOrangeBox = new Box<>();
        orangeBox.moveTo(otherOrangeBox);
        System.out.println(orangeBox.getWeight());
        System.out.println(otherOrangeBox.getWeight());
    }


}
