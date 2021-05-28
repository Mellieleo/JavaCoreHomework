package Homework_4;

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        List<String> duplicates1 = Arrays.asList("1(555)6497653", "1(555)6495453");
        Map<String, List<String>> phones = new HashMap<>();

        phones.put("Geller", duplicates1);
        phones.put("Green", Collections.singletonList("1(555)2864188"));
        phones.put("Bing", Collections.singletonList("1(555)1568435"));
        phones.put("Tribbiani", Collections.singletonList("1(555)1248648"));
        phones.put("Buffay", Collections.singletonList("1(555)9434346"));
        System.out.println(phones.get("Geller"));
    }
}
/*
Возник вопрос касательно дубликатов. Если у нас книга постоянно пополняется пользователями извне,
мы не можем сделать так, как я сделала выше, так как каждый пользователь вводит данные независимо.
На StackOverFlow предложено такое решение этой проблемы:

public class DuplicateMap<K, V> {

    private Map<K, ArrayList<V>> m = new HashMap<>();

    public void put(K k, V v) {
        if (m.containskey(k)) {
            m.get(k).add(v);
        } else {
            ArrayList<V> arr = new ArrayList<>();
            arr.add(v);
            m.put(k, arr);
        }
    }

    public ArrayList<V> get(K k) {
        return m.get(k);
    }

    public V get(K k, int index) {
        return m.get(k).size()-1 < index  ? null : m.get(k).get(index);
    }
}

Вопрос: стоит ли использовать предложенный метод в подобных случаях или проще воспользоваться сторонними
библиотеками?
*/