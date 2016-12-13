package java8.chap04.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by aaron on 16-12-13.
 */
public class PythagoreanTriples {
    public static void main(String[] args) {
        Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                            IntStream.rangeClosed(a, 100).mapToObj(
                                    b -> new double[]{a, b, Math.sqrt(a*a + b*b)}
                            )
                            .filter(t -> t[2] % 1 == 0));

        pythagoreanTriples.forEach(t -> System.out.printf("%.0f, %.0f, %.0f%n", t[0], t[1], t[2]));
    }
}
