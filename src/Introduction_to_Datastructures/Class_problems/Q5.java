package Introduction_to_Datastructures.Class_problems;

public class Q5 {
    static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int best = 0;
        while (left < right) {
            int h = heights[left];
            if (heights[right] < h) {
                h = heights[right];
            }
            int area = h * (right - left);
            if (area > best) {
                best = area;
            }
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }
    static int maxContainerAreaBruteForce(int[] heights) {
        int best = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int h = heights[i];
                if (heights[j] < h) {
                    h = heights[j];
                }
                int area = h * (j - i);
                if (area > best) {
                    best = area;
                }
            }
        }
        return best;
    }
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights));            
        System.out.println(maxContainerAreaBruteForce(heights));  
    }
}