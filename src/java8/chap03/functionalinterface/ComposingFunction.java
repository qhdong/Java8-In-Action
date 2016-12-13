package java8.chap03.functionalinterface;

import java.util.function.Function;

/**
 * Created by aaron on 16-12-7.
 */
public class ComposingFunction {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        System.out.println(h.apply(1)); // 4
        Function<Integer, Integer> h2 = f.compose(g);
        System.out.println(h2.apply(1)); // 3

    }
}
