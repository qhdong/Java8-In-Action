package java8.chap04.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAndMatching {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();

        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        boolean isHealthy = menu.stream()
                .noneMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(dish);

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                numbers.stream()
                .map(x->x*x)
                .filter(x->x % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree);

//        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum = numbers.stream().reduce(0, Integer::sum);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(sum);
        System.out.println(product);
        Optional<Integer> sum2 = numbers.stream().reduce(Integer::sum);
        System.out.println(sum2);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max);

        int sum3 = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println(sum3);

    }
}
