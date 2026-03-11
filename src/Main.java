package Palindrome;

import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray())
            stack.push(c);

        for (char c : str.toCharArray())
            if (c != stack.pop())
                return false;

        return true;
    }
}

// Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;
        }
        return true;
    }
}

// Context Class
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        if (strategy == null)
            throw new IllegalStateException("Strategy not selected!");
        return strategy.check(input);
    }
}

// Main Class
public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("=== Strategy Pattern Palindrome Checker ===");
        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                context.setStrategy(new StackStrategy());
                break;
            case 2:
                context.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice.");
                sc.close();
                return;
        }

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        boolean result = context.execute(input);

        if (result)
            System.out.println("Result: The string IS a palindrome.");
        else
            System.out.println("Result: The string is NOT a palindrome.");

        sc.close();
    }
}