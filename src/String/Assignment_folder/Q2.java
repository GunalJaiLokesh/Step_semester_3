package Step_semester_3.src.String.Assignment_folder;

import java.util.Scanner;

public class Q2 {

    static void checkTypingAccuracy(String original, String typed) {

        int count = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                count++;
            }
            else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (count * 100.0) / original.length();

        System.out.println("Accuracy: " + accuracy + "%");

        if (firstMismatch == -1) {
            System.out.println("There are no mismatches.");
        }
        else {
            System.out.println("First mismatch is at position: " + (firstMismatch + 1));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the original passage:");
        String original = sc.nextLine();

        System.out.println("Enter the typed text:");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}
