package java8.chap04.streams;

import java.util.stream.Stream;

/**
 * Created by aaron on 16-12-13.
 */
public class Iterator {
    public static void main(String[] args) {
        Stream.iterate(2, i -> i + 2)
                .limit(10)
                .forEach(System.out::println);

    }
}
