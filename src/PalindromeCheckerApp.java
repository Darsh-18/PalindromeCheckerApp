import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // 🔥 NORMALIZATION (MAIN PART)
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        // Check palindrome using simple loop
        boolean isPalindrome = true;

        int start = 0;
        int end = cleaned.length() - 1;

        while (start < end) {
            if (cleaned.charAt(start) != cleaned.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        sc.close();
    }
}