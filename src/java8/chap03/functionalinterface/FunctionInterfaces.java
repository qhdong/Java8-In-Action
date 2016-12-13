package java8.chap03.functionalinterface;

import java8.chap02.passingcode.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionInterfaces {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T s : list) {
            if (p.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> listOfStrings = Arrays.asList("hello", "", "god", "");
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        System.out.println(nonEmpty);

        forEach(listOfStrings, System.out::println);

        List<Integer> len = map(listOfStrings, String::length);
        System.out.println(len);

        List<String> strs = Arrays.asList("a", "B", "c", "D", "e");
        strs.sort(String::compareTo);
        System.out.println(strs);
        strs.sort(String::compareToIgnoreCase);
        System.out.println(strs);

        BiFunction<Integer, String, Apple> c3 = Apple::new;
        System.out.println(c3.apply(150, "Orange"));

    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<R>();
        for (T i : list) {
            result.add(f.apply(i));
        }
        return result;
    }
}
