package Class_problems;

import java.util.Scanner;
public class Q4 {
    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Error: Phone number must contain exactly 10 digits";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Error: Phone number must contain only digits";
            }
        }
        String lastFour = phone.substring(6);
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append("-");
        masked.append(lastFour);
        return masked.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        String phone = sc.nextLine();
        System.out.println(maskPhoneNumber(phone));
    }
}
