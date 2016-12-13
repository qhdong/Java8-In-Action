package java8.chap03.functionalinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FruitStore {
    private static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return map.get(fruit.toLowerCase())
                .apply(weight);
    }

    public static void main(String[] args) {
        System.out.println(giveMeFruit("Apple", 120));
        System.out.println(giveMeFruit("Orange", 180));
    }
}
