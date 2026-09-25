package Class_problems;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String fileName = sc.nextLine();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            System.out.println("Rejected - invalid file type");
        } else {
            String extension = fileName.substring(dotIndex + 1);
            if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip")) {
                System.out.println("Accepted");
            } else {
                System.out.println("Rejected - invalid file type");
            }
        }
        sc.close();
    }
}