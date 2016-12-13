package java8.chap04.streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Filters {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();

        List<Dish> vegetarianMenu = menu.stream()
                                        .filter(Dish::isVegetarian)
                                        .collect(toList());
        System.out.println(vegetarianMenu);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> (i & 1) == 0)
                .distinct()
                .forEach(System.out::println);

        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println(dishes);

        dishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println(dishes);

        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");

        List<String> uniqueCharacters = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(uniqueCharacters);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        numbers1.stream()
                .flatMap(i->
                        numbers2.stream()
                                .filter(j->(i+j) % 3 == 0)
                                .map(j->new int[]{i, j})
                )
                .forEach(System.out::println);



    }
}
