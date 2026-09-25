package Assignment_problems;

import java.util.Scanner;

class Q5 {
    static void printFilteredWordFrequency(String feedback) {
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");
        String[] stopWords = {"the","was","and","a","is","of","in"};
        String[] words = feedback.split("\\s+");
        String[] uniqueWords = new String[words.length];
        int[] counts = new int[words.length];
        int size = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean stop = false;
            for (int j = 0; j < stopWords.length; j++) {
                if (word.equals(stopWords[j])) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                continue;
            }
            int index = -1;
            for (int j = 0; j < size; j++) {
                if (uniqueWords[j].equals(word)) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                uniqueWords[size] = word;
                counts[size] = 1;
                size++;
            } else {
                counts[index]++;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(uniqueWords[i] + ": " + counts[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String feedback = sc.nextLine();
        printFilteredWordFrequency(feedback);
        sc.close();
    }
}