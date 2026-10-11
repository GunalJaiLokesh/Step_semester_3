package Abstraction_and_Interface.Class_problems;
public class Q2 {
    public interface Printable {
        String printLabel();
    }
    static class PackageBox implements Printable {
        private String trackingId;
        public PackageBox(String trackingId) {
            this.trackingId = trackingId;
        }
        @Override
        public String printLabel() {
            return "Package label: " + trackingId;
        }
    }
    static class Invoice implements Printable {
        private String invoiceNumber;
        public Invoice(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }
        @Override
        public String printLabel() {
            return "Invoice label: " + invoiceNumber;
        }
    }
    static void printAll(Printable[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].printLabel());
        }
    }
    public static void main(String[] args) {
        PackageBox p = new PackageBox("TRK-88");
        Invoice i = new Invoice("INV-42");
        System.out.println(p.printLabel());
        System.out.println(i.printLabel());
        printAll(new Printable[]{p, i});
    }
}
