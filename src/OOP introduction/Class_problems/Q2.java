package Class_problems;

import java.util.Scanner;

class MessWallet {
    private double balance;
    public MessWallet(double balance) {
        if (balance < 0) {
            this.balance = 0;
            System.out.println("Warning: input cannot be negative");
        } else {
            this.balance = balance;
        }
    }
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top up rejected");
        } else {
            balance += amount;
            System.out.println("Amount deposited successfully");
        }
    }
    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (amount > balance) {
            System.out.println("Transaction denied due to insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Transaction successful");
        }
    }
    public void getBalance() {
        System.out.println("Balance: " + balance);
    }
}
public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial balance:");
        double balance = sc.nextDouble();
        MessWallet m = new MessWallet(balance);
        System.out.println("\nEnter the operation to be performed");
        System.out.println("1 - Top Up");
        System.out.println("2 - Deduct");
        System.out.println("3 - Get Balance");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter amount to top up:");
                double topUpAmount = sc.nextDouble();
                m.topUp(topUpAmount);
                m.getBalance();
                break;
            case 2:
                System.out.println("Enter amount to deduct:");
                double deductAmount = sc.nextDouble();
                m.deduct(deductAmount);
                m.getBalance();
                break;
            case 3:
                m.getBalance();
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}
