import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Clean input (same as UC4)
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        // 🔥 STACK LOGIC
        Stack<Character> stack = new Stack<>();

        // Push characters
        for (int i = 0; i < cleaned.length(); i++) {
            stack.push(cleaned.charAt(i));
        }

        // Pop and build reversed string
        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Compare
        if (cleaned.equals(reversed)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        sc.close();
    }
}