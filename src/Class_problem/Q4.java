package Class_problem;

abstract class Room {
    String roomNumber;
    boolean available = true;
    Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    abstract double calculatePrice(int days);
}
class StandardRoom extends Room {
    StandardRoom(String roomNumber) {
        super(roomNumber);
    }
    double calculatePrice(int days) {
        return days * 100;
    }
}
class DeluxeRoom extends Room {
    DeluxeRoom(String roomNumber) {
        super(roomNumber);
    }
    double calculatePrice(int days) {
        return days * 200;
    }
}
class Suite extends Room {
    Suite(String roomNumber) {
        super(roomNumber);
    }
    double calculatePrice(int days) {
        return days * 350;
    }
}
class Customer {
    String name;
    Customer(String name) {
        this.name = name;
    }
}
class Reservation {
    Customer customer;
    Room room;
    String startDate;
    String endDate;
    int days;
    Reservation(Customer customer,Room room,String startDate,String endDate,int days) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
    }
    void checkAvailability() {
        if (room.available) {
            System.out.println(room.roomNumber+ " is available from "+ startDate+ " to "+ endDate + ".");
        } else {
            System.out.println( room.roomNumber+ " is not available from "+ startDate+ " to "+ endDate + ".");
        }
    }
    void reserveRoom() {
        if (room.available) {
            room.available = false;
            System.out.println("Reservation confirmed for "+ customer.name + ", "+ room.roomNumber+ " (" + startDate+ "-" + endDate + ").");
            System.out.println("Price: $"+ room.calculatePrice(days));
        } else {
            System.out.println(
                    room.roomNumber
                    + " is not available from "
                    + startDate
                    + " to "
                    + endDate + ".");
        }
    }
    void cancelReservation() {
        room.available = true;
        System.out.println("Reservation for "+ customer.name + ", "+ room.roomNumber+ " (" + startDate+ "-" + endDate+ ") cancelled successfully.");
    }
}
public class Q4 {
    public static void main(String[] args) {
        Room room101 =new StandardRoom("Standard Room 101");

        Room room201 =new DeluxeRoom("Deluxe Room 201");
        Customer a =new Customer("Customer A");
        Reservation r1 =
                new Reservation(a,room101,"Jan 1","Jan 5",4);
        r1.checkAvailability();
        r1.reserveRoom();
        Customer b =new Customer("Customer B");
        Reservation r2 = new Reservation(b,room101,"Jan 3",
                        "Jan 7",4);
        r2.reserveRoom();
        r1.cancelReservation();
        Customer c =new Customer("Customer C");
        Reservation r3 =new Reservation(c,room201,"Feb 10","Feb 12",2);
        r3.reserveRoom();
    }
}