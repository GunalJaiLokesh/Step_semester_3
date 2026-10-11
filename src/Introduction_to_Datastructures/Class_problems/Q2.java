package Introduction_to_Datastructures.Class_problems;

public class Q2 {
    static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxValue = -1;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        int[] result = {total, maxRow, maxCol};
        return result;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        int[] r = warehouseSummary(grid);
        System.out.println("(" + r[0] + ", (" + r[1] + ", " + r[2] + "))");
    }
}