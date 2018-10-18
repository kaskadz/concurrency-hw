package printers;

public class ThreePrinter extends Printer {
    public ThreePrinter(Object nextPrinter, Object previousPrinter) {
        super(nextPrinter, previousPrinter);
    }

    @Override
    public void print() {
        System.out.println(3);
    }
}
