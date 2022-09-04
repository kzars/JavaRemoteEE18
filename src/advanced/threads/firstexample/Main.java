package advanced.threads.firstexample;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Bread("one"));
        Thread t2 = new Thread(new Bread("two"));
        Thread t3 = new Thread(new Bread("three"));
        Thread t4 = new Thread(new Bread("four"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
