package Introduction_to_Datastructures.Assignment_problems;

public class Q3 {
    static String mostPopular(String[] orders) {
        String[] items = new String[orders.length];
        int[] counts = new int[orders.length];
        int itemCount = 0;
        for (int i = 0; i < orders.length; i++) {
            int found = -1;
            for (int j = 0; j < itemCount; j++) {
                if (items[j].equals(orders[i])) {
                    found = j;
                    break;
                }
            }
            if (found == -1) {
                items[itemCount] = orders[i];
                counts[itemCount] = 1;
                itemCount++;
            } else {
                counts[found]++;
            }
        }
        int best = 0;
        for (int j = 1; j < itemCount; j++) {
            if (counts[j] > counts[best]) {
                best = j;
            }
        }
        return "(" + items[best] + ", " + counts[best] + ")";
    }
    public static void main(String[] args) {
        String[] o1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        System.out.println(mostPopular(o1));
        String[] o2 = {"tea", "coffee", "coffee", "tea"};
        System.out.println(mostPopular(o2));
    }
}