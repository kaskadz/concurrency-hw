import printers.OnePrinter;
import printers.Printer;
import printers.ThreePrinter;
import printers.TwoPrinter;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        Object oneLock = new Object();
        Object twoLock = new Object();
        Object threeLock = new Object();

        Printer one = new OnePrinter(twoLock, oneLock);
        Printer two = new TwoPrinter(threeLock, twoLock);
        Printer three = new ThreePrinter(oneLock, threeLock);

        one.start();
        two.start();
        three.start();

        Thread.sleep(1);
        synchronized (oneLock) {
            oneLock.notify();
        }
        one.join();
        two.join();
        three.join();
    }
}
