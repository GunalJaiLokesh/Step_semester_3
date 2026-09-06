package Step_semester_3.src.String.Assignment_folder;

import java.util.Scanner;
public class Q3 {
    static void findLongestStreak(String signalLog) {
        int count = 1;
        int max = 1;
        char color = signalLog.charAt(0);
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                count++;
            }
            else {
                count = 1;
            }
            if (count > max) {
                max = count;
                color = signalLog.charAt(i);
            }
        }
        System.out.println("Longest streak color: " + color);
        System.out.println("Length of longest streak: " + max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the signal log:");
        String signalLog = sc.nextLine();
        findLongestStreak(signalLog);
        sc.close();
    }
}

