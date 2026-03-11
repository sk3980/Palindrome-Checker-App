package Palindrome;
import java.util.*;
public class UseCasePalindromeCheckerApp {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Input text: ");
        String input= sc.next();
        char[] ch= input.toCharArray();
        String reversed= "";

        for(int i=input.length()-1; i>=0; i-- ){
            reversed += ch[i];
        }

        if(input.equals(reversed)){
            System.out.println("Is it a Palindrome? : True");
        }
        else {
            System.out.println("Is it a Palindrome? : False");
        }
    }


}