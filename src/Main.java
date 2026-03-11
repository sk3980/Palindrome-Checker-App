package Palindrome;
public class UseCasePalindromeCheckerApp{

    public static void main(String[] args) {

        // Hardcoded string
        String word = "racecar";

        // Convert string to character array
        char[] chars = word.toCharArray();

        // Two-pointer variables
        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        // Compare characters from both ends
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Print result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }
}