package Class_problem;

interface PaymentMethod {
    boolean processPayment(double amount);
    String getMethodName();
}

class CreditCardPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        return true;
    }

    public String getMethodName() {
        return "Credit Card";
    }
}

class PayPalPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        return false;
    }

    public String getMethodName() {
        return "PayPal";
    }
}

class BankTransferPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        return true;
    }

    public String getMethodName() {
        return "Bank Transfer";
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Product {
    String productName;
    double price;
    int quantity;

    Product(String productName,
            double price,
            int quantity) {

        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }
}

class Order {
    Customer customer;
    Product[] products;
    int count;
    String status;

    Order(Customer customer) {
        this.customer = customer;
        products = new Product[10];
        count = 0;
        status = "Pending";

        System.out.println(
                "Order created for "
                + customer.name + ".");
    }

    void addProduct(Product product) {
        products[count++] = product;
    }

    double calculateTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += products[i].getTotalPrice();
        }

        return total;
    }

    void makePayment(PaymentMethod method) {

        if (count == 0) {
            System.out.println(
                    "Cannot process payment for an empty order.");
            return;
        }

        System.out.println(
                "Payment initiated via "
                + method.getMethodName()
                + " for "
                + customer.name + "'s Order.");

        boolean success =
                method.processPayment(
                        calculateTotal());

        if (success) {
            status = "Paid";

            System.out.println(
                    "Payment for "
                    + customer.name
                    + "'s Order successful.");

            System.out.println(
                    "Order status: "
                    + status + ".");
        } else {

            System.out.println(
                    "Payment for "
                    + customer.name
                    + "'s Order failed.");

            System.out.println(
                    "Order status: "
                    + status + ".");
        }
    }
}

public class Q5 {
    public static void main(String[] args) {

        Customer x =
                new Customer("Customer X");

        Order order1 =
                new Order(x);

        order1.addProduct(
                new Product(
                        "Product A",
                        100,
                        2));

        order1.addProduct(
                new Product(
                        "Product B",
                        200,
                        1));

        order1.makePayment(
                new CreditCardPayment());

        Customer y =
                new Customer("Customer Y");

        Order order2 =
                new Order(y);

        order2.makePayment(
                new CreditCardPayment());

        Customer z =
                new Customer("Customer Z");

        Order order3 =
                new Order(z);

        order3.addProduct(
                new Product(
                        "Product C",
                        300,
                        1));

        order3.makePayment( new PayPalPayment());
    }
}