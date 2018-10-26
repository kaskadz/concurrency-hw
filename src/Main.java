public class Main {

    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();

        Printer one = new Printer(monitor, 1);
        Printer two = new Printer(monitor, 2);
        Printer three = new Printer(monitor, 3);

        one.start();
        two.start();
        three.start();

        one.join();
        two.join();
        three.join();
    }
}
