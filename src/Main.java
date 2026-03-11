package Palindrome;

import java.util.*;

public class UseCasePalindromeCheckerApp {

    // ---------- Stack Method ----------
    public static boolean stackMethod(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray())
            stack.push(c);

        for (char c : str.toCharArray())
            if (c != stack.pop())
                return false;

        return true;
    }

    // ---------- Deque Method ----------
    public static boolean dequeMethod(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray())
            deque.addLast(c);

        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;

        return true;
    }

    // ---------- Recursion Method ----------
    public static boolean recursionMethod(String str) {
        String processed = str.replaceAll("\\s+", "").toLowerCase();
        return recursiveCheck(processed, 0, processed.length() - 1);
    }

    private static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return recursiveCheck(str, start + 1, end - 1);
    }

    // ---------- Two Pointer Array Method ----------
    public static boolean arrayMethod(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        char[] arr = str.toCharArray();

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Palindrome Algorithm Performance Comparison ===");
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        // Stack
        long start = System.nanoTime();
        boolean stackResult = stackMethod(input);
        long end = System.nanoTime();
        long stackTime = end - start;

        // Deque
        start = System.nanoTime();
        boolean dequeResult = dequeMethod(input);
        end = System.nanoTime();
        long dequeTime = end - start;

        // Recursion
        start = System.nanoTime();
        boolean recResult = recursionMethod(input);
        end = System.nanoTime();
        long recTime = end - start;

        // Array
        start = System.nanoTime();
        boolean arrResult = arrayMethod(input);
        end = System.nanoTime();
        long arrTime = end - start;

        // ---------- Output ----------
        System.out.println("\nResults:");
        System.out.println("Stack Method      → " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Method      → " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("Recursion Method  → " + recResult + " | Time: " + recTime + " ns");
        System.out.println("Array Method      → " + arrResult + " | Time: " + arrTime + " ns");

        sc.close();
    }
}