package printers;

public class TwoPrinter extends Printer {
    public TwoPrinter(Object nextPrinter, Object previousPrinter) {
        super(nextPrinter, previousPrinter);
    }

    @Override
    public void print() {
        System.out.println(2);
    }
}
