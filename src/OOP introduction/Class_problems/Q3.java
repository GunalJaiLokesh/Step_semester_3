package Class_problems;

import java.util.Scanner;

class Course {
    String code;
    String title;
    int credits;
    int labCredits;
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }
    public int totalCredits() {
        return credits + labCredits;
    }
}
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details of theory-only course");
        System.out.println("Enter course code:");
        String code = sc.nextLine();
        System.out.println("Enter title:");
        String title = sc.nextLine();
        System.out.println("Enter credits:");
        int credits = sc.nextInt();
        sc.nextLine();
        Course noLab = new Course(code, title, credits);
        System.out.println("\nEnter details of course with lab credits");
        System.out.println("Enter course code:");
        String code1 = sc.nextLine();
        System.out.println("Enter title:");
        String title1 = sc.nextLine();
        System.out.println("Enter credits:");
        int credits1 = sc.nextInt();
        System.out.println("Enter lab credits:");
        int labCredits1 = sc.nextInt();
        Course withLab = new Course(code1, title1, credits1, labCredits1);
        System.out.println("\n" + noLab.code +
                " total credits: " +
                noLab.totalCredits());
        System.out.println(withLab.code +
                " total credits: " +
                withLab.totalCredits());
        sc.close();
    }
}
