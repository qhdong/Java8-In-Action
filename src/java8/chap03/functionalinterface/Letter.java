package java8.chap03.functionalinterface;

import java.util.function.Function;

public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan:\n" + text;
    }

    public static String addFooter(String text) {
        return text + "\nKind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline
                = addHeader
                .andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);

        System.out.println(transformationPipeline.apply("Hello, labda!"));
    }
}
