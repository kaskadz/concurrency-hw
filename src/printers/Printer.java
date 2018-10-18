package printers;

public abstract class Printer extends Thread {
    private final Object NextLock;
    private final Object CurrentLock;

    public Printer(Object nextLock, Object currrentLock) {
        NextLock = nextLock;
        CurrentLock = currrentLock;
    }

    @Override
    public void run() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            try {
                synchronized (CurrentLock) {
                    CurrentLock.wait();
                }
                print();
                synchronized (NextLock) {
                    NextLock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    abstract void print();
}
