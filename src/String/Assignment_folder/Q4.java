package Step_semester_3.src.String.Assignment_folder;

import java.util.Scanner;

public class Q4 {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA = totalA + sectionA[i];
            totalB = totalB + sectionB[i];
        }
        System.out.println("Total quantity in Section A: " + totalA);
        System.out.println("Total quantity in Section B: " + totalB);
        if (totalA == totalB) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
        int max = sectionA[0];
        String section = "A";
        int index = 0;
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "A";
                index = i;
            }
            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "B";
                index = i;
            }
        }
        System.out.println("Highest quantity: " + max);
        System.out.println("Found in Section " + section);
        System.out.println("Index: " + index);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items:");
        int n = sc.nextInt();
        int[] sectionA = new int[n];
        int[] sectionB = new int[n];
        System.out.println("Enter quantities for Section A:");
        for (int i = 0; i < n; i++) {
            sectionA[i] = sc.nextInt();
        }
        System.out.println("Enter quantities for Section B:");
        for (int i = 0; i < n; i++) {
            sectionB[i] = sc.nextInt();
        }
        analyzeInventory(sectionA, sectionB);
        sc.close();
    }
}

