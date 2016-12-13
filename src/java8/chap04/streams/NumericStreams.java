package java8.chap04.streams;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreams {
    public static void main(String[] args) {
        List<Dish> menu = Dish.getMenu();
        OptionalDouble calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .average();
        System.out.println(calories.orElse(1));

        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.min());
    }
}
