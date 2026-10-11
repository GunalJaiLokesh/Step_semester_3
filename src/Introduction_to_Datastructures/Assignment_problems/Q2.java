package Introduction_to_Datastructures.Assignment_problems;

public class Q2 {
    static int[] mergeTokens(int[] counterA, int[] counterB) {
        int[] result = new int[counterA.length + counterB.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < counterA.length && j < counterB.length) {
            if (counterA[i] <= counterB[j]) {
                result[k] = counterA[i];
                i++;
            } else {
                result[k] = counterB[j];
                j++;
            }
            k++;
        }
        while (i < counterA.length) {
            result[k] = counterA[i];
            i++;
            k++;
        }
        while (j < counterB.length) {
            result[k] = counterB[j];
            j++;
            k++;
        }
        return result;
    }
    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        int[] a = {3, 8, 15, 20};
        int[] b = {5, 8, 12};
        printArray(mergeTokens(a, b));
        int[] empty = {};
        int[] c = {4, 9};
        printArray(mergeTokens(empty, c));
    }
}
