package Step_semester_3.src.String.Class_problems;


import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        String reverse="";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverse = reverse + name.charAt(i);
        }
        System.out.println("Original name :"+name);
        System.out.println("Reversed name :"+reverse);
        sc.close();
    }
}