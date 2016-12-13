package java8.chap02.passingcode;

public class RunnableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Hello, world"));

        t.run();
        t2.run();

        Runnable r1 = () -> System.out.println("Hello, world");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello world 3"));

    }

    public static void process(Runnable r) {
        r.run();
    }
}
