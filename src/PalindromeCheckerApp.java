import java.util.*;

// 🔥 STRATEGY INTERFACE
interface PalindromeStrategy {
    boolean check(String input);
}

// 🔥 STACK STRATEGY
class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// 🔥 DEQUE STRATEGY
class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleaned.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// 🔥 CONTEXT CLASS
class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.check(input);
    }
}

// 🔥 MAIN CLASS
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack");
        System.out.println("2. Deque");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.checkPalindrome(input);

        if (result) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

        sc.close();
    }
}