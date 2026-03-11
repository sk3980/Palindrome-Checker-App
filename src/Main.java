package Palindrome;

import java.util.Scanner;


public class UseCasePalindromeCheckerApp {

    // Recursive palindrome check
    public static boolean isPalindrome(String str, int start, int end) {

        // Base condition: crossed pointers or single char
        if (start >= end)
            return true;

        // If mismatch found
        if (str.charAt(start) != str.charAt(end))
            return false;

        // Recursive call
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Recursive Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Normalize string
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(processed, 0, processed.length() - 1);

        if (result)
            System.out.println("Result: The string IS a palindrome.");
        else
            System.out.println("Result: The string is NOT a palindrome.");

        sc.close();
    }
}