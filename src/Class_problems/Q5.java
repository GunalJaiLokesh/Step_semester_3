package Class_problems;

import java.util.Scanner;

class Q5 {
    static String normalizeReference(String raw) {
        raw = raw.trim();
        String bankCode = raw.substring(0, 3).toUpperCase();
        String remaining = raw.substring(3);
        return bankCode + remaining;
    }
    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9);
        StringBuilder result = new StringBuilder();
        result.append("[")
              .append(bankCode)
              .append("] DATE: ")
              .append(day)
              .append("/")
              .append(month)
              .append("/")
              .append(year)
              .append(" | SEQ: ")
              .append(sequence);
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw = sc.nextLine();
        String reference = normalizeReference(raw);
        System.out.println(validateAndFormat(reference));
        sc.close();
    }
}
