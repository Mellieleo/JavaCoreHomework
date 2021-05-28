package Homework_3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitInside;

    @SafeVarargs
    public Box(T... fruitInside) {
        this.fruitInside = new ArrayList<>(Arrays.asList(fruitInside));
    }

    public void addNew(T newFruit) {
        fruitInside.add(newFruit);
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
        fruitInside.clear();
    }
}
