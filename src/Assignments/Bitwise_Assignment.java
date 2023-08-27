package Assignments;

import java.util.ArrayList;

public class Bitwise_Assignment {
    public static void main(String[] args) {
        
    }

    
    static String addBinary(String a, String b) {

        // Initializing two pointers at the end
        int i= a.length() -1;
        int j= b.length() -1;
        int carry=0;
        StringBuilder str= new StringBuilder();

        // Keep looping until one of the string ends
        while(i>=0 && j>=0){
            /* 
                We know that , arithmatic operation between charaters returns integer. 

                Now the input string is a binary string containing 0 and 1. Therefore,

                '1'-'0' --> 49 - 48 --> 1

                '0'-'0' --> 48 - 48 --> 0

                In this way we can access the actual integers present in the given string
                */
            int firstBit= a.charAt(i)-'0';  
            int secondBit= b.charAt(j)-'0';

            int sumBit=firstBit ^ secondBit ^ carry;    // perform xor to find the sum bit

            carry=(firstBit+secondBit+carry)/2;         // as we are performing binary addition, we have to divide this by 2(i.e. the base)

            str.append(sumBit);     
            i--;
            j--;

        }
        // There might be cases where the first string is not finished 
        while(i>=0){
            int digit = a.charAt(i)-'0';    
            str.append(digit^carry);        // perform xor and append the sum bit (Even if the carry becomes 0, we need not to worry as A^0=A)
            carry=(digit+carry)/2;          // update the carry 
            i--;
        }

        // There might be cases where the second string is not finished 
        while(j>=0){
            int digit = b.charAt(j)-'0';
            str.append(digit^carry);        
            carry=(digit+carry)/2;  
            j--;
        }

        if(carry==1) str.append(carry);     // leftover carry, add it
    
        return str.reverse().toString();

    }
    
    static int reverseBits(int n) {

        int ans=0,count=32;
        
        while(count>0){     // we must run the loop for 32 times to reverse all of the 32 bits
            int lastDigit= n&1;
            ans= ans*2+lastDigit;
            n=n>>1;
            count--;
        }
       
        return ans;
    }

    static int hammingDistance(int x, int y) {
        // Basically, if we XOR both the numbers, we get 1 where bits were different. Return number of 1s in that!! 
       int setBits= countSetBits(x^y);
       return setBits;
    }
    static int countSetBits(int n){
        int count=0;
        while(n>0){
            count++;
            n=n&(n-1);
            n=n>>1;    
        }
        return count;
    }

    static int findComplement(int num) {
        // Suppose, there are three bits in a number. Now, if we subtract the number from 111 we get all of its bits reversed. 
        int digits= (int)(Math.log(num)/Math.log(2)+1);
        int upperLimit= (int)(Math.pow(2,digits)-1);
        return upperLimit-num;
    }

    static boolean hasAlternatingBits(int n) {
        int prevBit=n&1;
        while(n>0){
           n=n>>1;
           int currentBit=n&1;
           if(currentBit==prevBit){
               return false;
           }
           prevBit=currentBit; 
        }
        return true;
    }

    static int numberOfSteps(int num) {
        int steps=0;
        while(num>0){
            int lastBit=num&1;
            // If the lastBit is 1, the number is odd. Subtract 1 to make it even
            if(lastBit==1){
                num--;
            }
            else{
                // It is already even, divide by 2
                num=num>>1;
            }
            steps++;
        }
        return steps;
    }
    

    static ArrayList< ArrayList<Integer> > subsets(int[] nums) {

        // Intuition: https://youtu.be/b7AYbpM5YrE

        int n= (int)Math.pow(2,nums.length);        // The power set of a set having 'n' element contains 2^n elements.

        ArrayList<ArrayList<Integer>> ans= new ArrayList<>(n);

        // We shall iterate from 0 to (2^n)-1. At every step, for each set bit at a particular index, we shall add an element from corresponding index of the given array to our arraylist.
        for(int i=0;i<n;i++){       
            ArrayList<Integer> temp= new ArrayList<>();
            // checking for set bit at each index

            for(int j=0;j<nums.length;j++){     // each array index is represented by a bit, therefore number of bits= number of element in the array 
                if(isSet(i,j)){
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;

    }
    static boolean isSet(int a,int b){
        int mask= 1<<b;
        
        if((a&mask)>0){
            return true;
        }
        return false;
    }

}
