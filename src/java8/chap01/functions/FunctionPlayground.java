package java8.chap01.functions;

import java.io.File;
import java.io.FileFilter;

public class FunctionPlayground {
    public static void main(String[] args) {
        listFiles();
        listFiles2();
    }

    public static void listFiles2() {
        File[] hiddenFiles = new File("/etc").listFiles(File::isHidden);
        for (File file : hiddenFiles) {
            System.out.println(file);
        }
    }


    public static void listFiles() {
        File[] hiddenFiles = new File("/etc").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        for (File file : hiddenFiles) {
            System.out.println(file);
        }
    }
}
