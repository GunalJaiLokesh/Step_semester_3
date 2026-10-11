package Introduction_to_Datastructures.Class_problems;

import java.util.Arrays;
public class Q3 {
    static boolean hasPairWithSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean hasPairWithSumSorted(int[] nums, int target) {
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
        int[] a = {2, 7, 11, 15};
        int[] b = {3, 4, 6};
        System.out.println(hasPairWithSum(a, 9)); 
        System.out.println(hasPairWithSum(b, 20));
        System.out.println(hasPairWithSumSorted(a, 9)); 
        System.out.println(hasPairWithSumSorted(b, 20));
    }
}