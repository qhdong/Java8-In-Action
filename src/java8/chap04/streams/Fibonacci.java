package java8.chap04.streams;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0]+f[1]})
                .limit(20)
                .map(f -> f[0])
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1);
        ones.limit(10).forEach(System.out::print);

        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });

        twos.limit(80).forEach(System.out::print);

        IntSupplier fib = new IntSupplier() {
            private int prev = 0;
            private int curr = 1;
            @Override
            public int getAsInt() {
                int next = prev + curr;
                prev = curr;
                curr = next;
                return prev;
            }
        };

        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }
}
