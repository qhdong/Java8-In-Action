package java8.chap02.passingcode;

import java.util.Arrays;
import java.util.List;

public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public static List<Apple> getApples() {
        return Arrays.asList(
                new Apple(120, "Green"),
                new Apple(130, "Green"),
                new Apple(160, "Red"),
                new Apple(140, "Red"),
                new Apple(140, "Green")

        );
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}