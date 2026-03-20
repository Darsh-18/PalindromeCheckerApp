import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive function
    static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true; // Base condition
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Clean input
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(cleaned, 0, cleaned.length() - 1);

        if (result) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        sc.close();
    }
}