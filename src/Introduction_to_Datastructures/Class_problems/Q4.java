package Introduction_to_Datastructures.Class_problems;

import java.util.Arrays;
public class Q4 {
    static boolean hasPairBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean hasPairTwoPointers(int[] nums, int target) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int low = 0;
        int high = sorted.length - 1;
        while (low < high) {
            int sum = sorted[low] + sorted[high];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] s1 = {2, 7, 11, 15};
        int[] s2 = {3, 4, 6};
        System.out.println(hasPairBruteForce(s1, 9)); 
        System.out.println(hasPairBruteForce(s2, 20));
        System.out.println(hasPairTwoPointers(s1, 9));
        System.out.println(hasPairTwoPointers(s2, 20));
    }
}
