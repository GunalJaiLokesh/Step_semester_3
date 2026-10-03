package Class_problem;

abstract class Vehicle {
    String vehicleName;
    boolean available = true;
    Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    abstract double calculateCharge(int days);
}
class Sedan extends Vehicle {
    Sedan(String vehicleName) {
        super(vehicleName);
    }
    double calculateCharge(int days) {
        return days * 50;
    }
}
class SUV extends Vehicle {
    SUV(String vehicleName) {
        super(vehicleName);
    }
    double calculateCharge(int days) {
        return days * 80;
    }
}
class Truck extends Vehicle {
    Truck(String vehicleName) {
        super(vehicleName);
    }
    double calculateCharge(int days) {
        return days * 100;
    }
}
class Customer {
    String name;
    Customer(String name) {
        this.name = name;
    }
}
class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;
    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }
    void rentVehicle() {
        if (vehicle.available) {
            vehicle.available = false;
            System.out.println(vehicle.vehicleName+ " rented successfully by "+ customer.name + ".");
            System.out.println("Rental charge: $" + vehicle.calculateCharge(days));
        } else {
            System.out.println(vehicle.vehicleName+ " is currently unavailable.");
        }
    }
    void returnVehicle() {
        vehicle.available = true;
        System.out.println(vehicle.vehicleName+ " returned by "+ customer.name + ".");
    }
}
public class Q1 {
    public static void main(String[] args) {
        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");
        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");
        Rental r1 = new Rental(sedanA, c1, 3);
        r1.rentVehicle();
        Rental r2 = new Rental(sedanA, c2, 2);
        r2.rentVehicle();
        r1.returnVehicle();
        Rental r3 = new Rental(suvB, c3, 5);
        r3.rentVehicle();
    }
}
