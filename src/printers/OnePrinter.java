package printers;

public class OnePrinter extends Printer {
    public OnePrinter(Object nextPrinter, Object previousPrinter) {
        super(nextPrinter, previousPrinter);
    }

    @Override
    public void print() {
        System.out.println(1);
    }
}
