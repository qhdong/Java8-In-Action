package java8.chap03.functionalinterface;

import jdk.nashorn.internal.objects.annotations.Function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDemo {
    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/etc/passwd"))) {
            return br.readLine();
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/etc/passwd"))) {
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(processFile());
        System.out.println(processFile((BufferedReader br) -> br.readLine() + '\n' + br.readLine()));
    }
}
