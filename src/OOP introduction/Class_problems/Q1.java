package Class_problems;

import java.util.Scanner;

class PlacementRecord {
    String studentname;
    String company;
    double packageLPA;
    public PlacementRecord(String studentname, String company, double packageLPA) {
        this.studentname = studentname;
        this.company = company;
        this.packageLPA = packageLPA;
    }
    public void printRecord() {
        System.out.println(studentname + " -> " + company + " @ " + packageLPA + " LPA");
    }
}
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of students:");
        int a = sc.nextInt();
        sc.nextLine();
        PlacementRecord[] pr = new PlacementRecord[a];
        for (int i = 0; i < a; i++) {
            System.out.println("Enter name:");
            String name = sc.nextLine();
            System.out.println("Enter company:");
            String company = sc.nextLine();
            System.out.println("Enter salary:");
            double packageLPA = sc.nextDouble();
            sc.nextLine();
            pr[i] = new PlacementRecord(name, company, packageLPA);
        }
        System.out.println("\nPlacement Records:");
        for (int i = 0; i < a; i++) {
            pr[i].printRecord();
        }
        sc.close();
    }
}