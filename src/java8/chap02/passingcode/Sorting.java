package java8.chap02.passingcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = Apple.getApples();

        Comparator<Apple> appleComparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };
        inventory.sort(appleComparator);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        inventory.sort(comparing((Apple a) -> a.getWeight()));

        inventory.sort(comparing(Apple::getWeight));

        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight)
        .reversed()
        .thenComparing(Apple::getColor));
        System.out.println(inventory);
    }
}
