import java.util.*;

public class PalindromeCheckerApp {

    // Simple method
    static boolean simpleCheck(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Stack method
    static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Deque method
    static boolean dequeCheck(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque.add(c);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        // SIMPLE
        long start1 = System.nanoTime();
        boolean r1 = simpleCheck(cleaned);
        long end1 = System.nanoTime();

        // STACK
        long start2 = System.nanoTime();
        boolean r2 = stackCheck(cleaned);
        long end2 = System.nanoTime();

        // DEQUE
        long start3 = System.nanoTime();
        boolean r3 = dequeCheck(cleaned);
        long end3 = System.nanoTime();

        // RESULTS
        System.out.println("\n--- RESULTS ---");

        System.out.println("Simple Method: " + r1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Stack Method:  " + r2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Deque Method:  " + r3 + " | Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}