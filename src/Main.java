package Palindrome;

import java.util.Scanner;

public class UseCasePalindromeCheckerApp {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Convert string to linked list
    public static Node createList(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();

        Node head = null, tail = null;

        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Reverse linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // Check palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        // Find middle using slow-fast pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow);

        // Compare halves
        Node firstHalf = head;
        Node tempSecond = secondHalf;

        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data)
                return false;

            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Linked List Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        Node head = createList(input);

        if (isPalindrome(head))
            System.out.println("Result: The string IS a palindrome.");
        else
            System.out.println("Result: The string is NOT a palindrome.");

        sc.close();
    }
}