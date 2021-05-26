package Homework_3;


import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private T[] fruitInside;

    public Box(T... fruitInside) {
        this.fruitInside = fruitInside;
    }

    public void addNew(T newFruit) {
        Arrays.stream(fruitInside).toList().add(newFruit);
    }


    public float getWeight() {
        float weight = 0;
        for (T fruit : fruitInside) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void moveTo(Box<T> otherBox) {
        for (T fruit:fruitInside) {
            otherBox.addNew(fruit);
        }
        Arrays.stream(fruitInside).toList().clear();
    }
}
