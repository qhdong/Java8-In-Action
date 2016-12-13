package java8.chap04.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by aaron on 16-12-13.
 */
public class CreateStream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java8", "Lambdas", "In", "Action");
        stream.forEach(System.out::println);

        int[] numbers = {2, 3, 4, 5 ,6 ,7 ,8};
        int sum = Arrays.stream(numbers).sum();
    }
}
