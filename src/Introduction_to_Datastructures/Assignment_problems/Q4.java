package Introduction_to_Datastructures.Assignment_problems;

public class Q4 {
    static int countAlerts(int[] readings, int k, int threshold) {
        int needed = k * threshold;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += readings[i];
        }
        int count = 0;
        if (windowSum >= needed) {
            count++;
        }
        for (int i = k; i < readings.length; i++) {
            windowSum += readings[i];
            windowSum -= readings[i - k];
            if (windowSum >= needed) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4));
    }
}
