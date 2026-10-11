package Introduction_to_Datastructures.Assignment_problems;

public class Q1 {
    static int[] findTopper(int[][] marks) {
        int bestRow = 0;
        int bestTotal = -1;
        for (int i = 0; i < marks.length; i++) {
            int total = 0;
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        int[] result = {bestRow, bestTotal};
        return result;
    }
    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };
        int[] r = findTopper(marks);
        System.out.println("(" + r[0] + ", " + r[1] + ")");  
    }
}