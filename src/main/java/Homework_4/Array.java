package Homework_4;

import java.util.*;

public class Array {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("папа", "может", "в", "си", "папа", "может", "в", "си", "пока", "это", "так", "все", "в", "порядке", "на", "руси");
        Set<String> newSet = new LinkedHashSet<>(stringList);
        System.out.println(newSet);
        System.out.println(newSet.size());
    }
}
