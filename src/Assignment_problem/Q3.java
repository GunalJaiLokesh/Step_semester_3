package Assignment_problem;

class Customer {
    String name;
    Customer(String name) {
        this.name = name;
    }
}
abstract class Seat {
    String seatNumber;
    Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    abstract double getPrice();
}
class RegularSeat extends Seat {
    RegularSeat(String seatNumber) {
        super(seatNumber);
    }
    double getPrice() {
        return 150;
    }
}
class PremiumSeat extends Seat {
    PremiumSeat(String seatNumber) {
        super(seatNumber);
    }
    double getPrice() {
        return 250;
    }
}
class ReclinerSeat extends Seat {
    ReclinerSeat(String seatNumber) {
        super(seatNumber);
    }
    double getPrice() {
        return 400;
    }
}
class Show {
    String showName;
    String[] bookedSeats = new String[100];
    int count = 0;
    Show(String showName) {
        this.showName = showName;
    }
    boolean isSeatAvailable(String seatNo) {
        for (int i = 0; i < count; i++) {
            if (bookedSeats[i].equals(seatNo)) {
                return false;
            }
        }
        return true;
    }
    void bookSeat(String seatNo) {
        bookedSeats[count++] = seatNo;
    }
    void releaseSeat(String seatNo) {
        for (int i = 0; i < count; i++) {
            if (bookedSeats[i].equals(seatNo)) {
                bookedSeats[i] = bookedSeats[count - 1];
                bookedSeats[count - 1] = null;
                count--;
                break;
            }
        }
    }
}
class Booking {
    Customer customer;
    Show show;
    Seat[] seats;
    int seatCount;
    Booking(Customer customer, Show show, Seat[] seats, int seatCount) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
        this.seatCount = seatCount;
    }
    double calculateTotal() {
        double total = 0;
        for (int i = 0; i < seatCount; i++) {
            total += seats[i].getPrice();
        }
        return total;
    }
    void cancelBooking() {
        for (int i = 0; i < seatCount; i++) {
            show.releaseSeat(seats[i].seatNumber);
        }
        System.out.println(customer.name +
                "'s booking cancelled. Seats released.");
    }
}
public class Q3 {
    public static void main(String[] args) {
        Show show = new Show("7 PM Show");
        Customer asha = new Customer("Asha");
        Seat[] ashaSeats = {
                new RegularSeat("A1"),
                new RegularSeat("A2"),
                new PremiumSeat("F5")
        };
        boolean possible = true;
        for (int i = 0; i < ashaSeats.length; i++) {
            if (!show.isSeatAvailable(ashaSeats[i].seatNumber)) {
                possible = false;
            }
        }
        if (possible) {
            for (int i = 0; i < ashaSeats.length; i++) {
                show.bookSeat(ashaSeats[i].seatNumber);
            }
            Booking b1 = new Booking(asha, show, ashaSeats, 3);
            System.out.println("Booking confirmed for Asha: A1, A2, F5");
            System.out.println("Total: ₹" + b1.calculateTotal());
            Customer ravi = new Customer("Ravi");
            if (!show.isSeatAvailable("A2")) {
                System.out.println("Seat A2 is already booked for this show.");
            }
            Seat[] raviSeats = {
                  new ReclinerSeat("R1")
            };
            show.bookSeat("R1");
            Booking b2 = new Booking(ravi, show, raviSeats, 1);
            System.out.println("Booking confirmed for Ravi: R1");
            System.out.println("Total: ₹" + b2.calculateTotal());
            b1.cancelBooking();
            Customer neha = new Customer("Neha");
            if (show.isSeatAvailable("A2")) {
                Seat[] nehaSeats = {new RegularSeat("A2")
                };
                show.bookSeat("A2");
                Booking b3 = new Booking(neha, show, nehaSeats, 1);
                System.out.println("Booking confirmed for Neha: A2");
                System.out.println("Total: ₹" + b3.calculateTotal());
            }
        }
    }
}   
