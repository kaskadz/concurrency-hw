public class Printer extends Thread {
    private final Monitor monitor;
    private final int number;

    public Printer(Monitor monitor, int number) {
        this.monitor = monitor;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                synchronized (monitor) {
                    while (this.number != monitor.getCurrentNumber()) {
                        monitor.wait();
                    }
                    System.out.println(number);
                    monitor.incrementCurrentNumber();
                    monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
