package printers;

public abstract class Printer extends Thread {
    private final Object NextLock;
    private final Object CurrentLock;
    private final int Count = 10;

    public Printer(Object nextLock, Object currrentLock) {
        NextLock = nextLock;
        CurrentLock = currrentLock;
    }

    @Override
    public void run() {
        for (int i = 0; i < Count; i++) {
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
