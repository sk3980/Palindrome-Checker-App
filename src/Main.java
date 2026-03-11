package Palindrome;

import java.util.Scanner;
import java.util.Stack;

// Service class (Encapsulation + SRP)
class PalindromeChecker {

    // Public method exposed to user
    public boolean checkPalindrome(String input) {

        // Preprocess string (ignore spaces & case)
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Internal Data Structure → Stack
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char c : processed.toCharArray()) {
            stack.push(c);
        }

        // Compare original with reversed (stack pop order)
        for (char c : processed.toCharArray()) {
            if (c != stack.pop())
                return false;
        }
        return true;
    }
}

// Main class
public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== OOP Palindrome Checker Service ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Object creation
        PalindromeChecker checker = new PalindromeChecker();

        // Service call
        boolean result = checker.checkPalindrome(input);

        if (result)
            System.out.println("Result: The string IS a palindrome.");
        else
            System.out.println("Result: The string is NOT a palindrome.");

        sc.close();
    }
}