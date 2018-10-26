public class Monitor {
    private int currentNumber;

    public Monitor() {
        currentNumber = 1;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void incrementCurrentNumber() {
        currentNumber = (currentNumber % 3) + 1;
    }
}
