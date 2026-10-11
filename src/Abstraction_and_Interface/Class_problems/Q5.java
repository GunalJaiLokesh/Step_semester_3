package Abstraction_and_Interface.Class_problems;

public class Q5 {
    static abstract class DeliveryNote {
        public DeliveryNote() {
        }
        public abstract String confirmDelivery();
        String confirmDelivery(String signature) {
            return confirmDelivery() + ", signed by " + signature;
        }
    }
    static class ParcelNote extends DeliveryNote {
        private String trackingId;
        public ParcelNote(String trackingId) {
            super();
            this.trackingId = trackingId;
        }
        @Override
        public String confirmDelivery() {
            return "Parcel " + trackingId + " delivered";
        }
    }
    static class LetterNote extends DeliveryNote {
        private String trackingId;
        public LetterNote(String trackingId) {
            super();
            this.trackingId = trackingId;
        }
        @Override
        public String confirmDelivery() {
            return "Letter " + trackingId + " delivered";
        }
    }
    static void logAll(DeliveryNote[] notes) {
        for (int i = 0; i < notes.length; i++) {
            System.out.println(notes[i].confirmDelivery());
        }
    }
    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));
        DeliveryNote ref = p; 
        logAll(new DeliveryNote[]{ref, new LetterNote("TRK-2")});
    }
}