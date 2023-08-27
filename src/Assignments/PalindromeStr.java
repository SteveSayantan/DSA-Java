package Assignments;

import java.util.Scanner;

public class PalindromeStr {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        
        System.out.println(checkIfPalindrome(in.next())); 
        
        in.close();
        
    }
    
    static void checkPalindrome(String str){
        str= str.trim().toLowerCase();

        String compString= ""; //This is not an optimised solution as it creates new string object with every concatenation. Use StringBuilder instead.

        for (int i = str.length()-1; i >=0; i-- ) {
            compString+=str.charAt(i);
        }

        if(compString.equals(str)){
            System.out.println("Palindrome");
            return;
        }
        
        System.out.println("Not Palindrome");
    }

    static boolean checkIfPalindrome(String str){ //Optimized version of the same code
        str= str.trim().toLowerCase();
        int start=0,end=str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
