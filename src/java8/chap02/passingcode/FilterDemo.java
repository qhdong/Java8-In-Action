package java8.chap02.passingcode;

import java8.chap01.functions.FilteringApples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterDemo {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<FilteringApples.Apple> inventory = Arrays.asList(
                new FilteringApples.Apple(12, "red"),
                new FilteringApples.Apple(150, "Green"));
        List<FilteringApples.Apple> redApples = filter(inventory, (FilteringApples.Apple apple) -> "red".equals(apple.getColor()));

    }
}
