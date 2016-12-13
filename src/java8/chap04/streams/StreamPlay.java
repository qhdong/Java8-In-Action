package java8.chap04.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by aaron on 16-12-12.
 */
public class StreamPlay {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();
        List<String> threeHighCaloricDishNames =
                menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(threeHighCaloricDishNames);

        System.out.println(menu.stream().map(Dish::getName).collect(toList()));
        System.out.println(menu.stream().map(Dish::getCalories).collect(toList()));

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);

        List<String> names =
                menu.stream()
                .filter(d -> {
                    System.out.println("[filtering] " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("[mapping] " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(names);

        menu.forEach(System.out::println);
        long count = menu.stream().filter(d -> d.getName().length() > 5)
                .count();
        System.out.println(count);
        System.out.println(menu.stream().sorted(Comparator.comparingInt(Dish::getCalories)).collect(toList()));
    }
}
