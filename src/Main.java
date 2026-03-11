package Palindrome;

import java.util.Scanner;

public class UseCasePalindromeCheckerApp {

    // Method to preprocess string and check palindrome
    public static boolean isPalindrome(String input) {

        // Normalize string:
        // 1. Remove spaces using regex
        // 2. Convert to lowercase
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Convert to char array
        char[] arr = processed.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        // Compare characters from both ends
        while (start < end) {
            if (arr[start] != arr[end])
                return false;

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input))
            System.out.println("Result: The string IS a palindrome.");
        else
            System.out.println("Result: The string is NOT a palindrome.");

        sc.close();
    }
}