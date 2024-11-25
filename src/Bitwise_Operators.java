import java.util.Arrays;

public class Bitwise_Operators {
    /* 
        Bitwise AND Operator(&):
        -----------------------

        1. We already know the basic concepts of AND operation.

        2. We already know, A AND 1 = A, i.e. all the digits of a number remains the same if we perform AND operation with 1.

        3. A & B => Bitwise AND (&) operator performs LOGICAL AND operation on the corresponding bits of binary equivalent of the given numbers. It returns the decimal equivalent of the result.

        Other Operators:
        ---------------

        4. We already know, the basic concepts of XOR and OR also. The corresponding opeartors are ^ (Bitwise XOR) and | (Bitwise OR)

        5. If we perform XOR operation on each bit of a number with 1, it will give 1's complement of the number. 

        6. ~ is used to take 1's complement of a number and it returns the decimal equivalent of the complement.

        7. Modern computers use 2's complement method to store signed binary numbers.

        8. Detailed explanation of signed and unsigned binary numbers:

            i) https://youtu.be/K_fjZH5mBaI     (Introduction)

            ii) https://youtu.be/LpPsM5a8kO0    (Signed Magnitude)

            iii) https://youtu.be/SgC-DnrQJpc   (1's complement)

            iv) https://youtu.be/lHmqKz0o1Ww    (2's complement)


        Left Shift Operator(<<)
        -----------------------

        1. Shifts all the bits to the left by one place, the empty space is filled with 0. (Logical Left Shift) 

        2. Any binary number shifted to left once, is actually twice the previous number i.e. multiplied by its base.

        3. If we shift binary number 'a', b times, it becomes a*2^b


        Right Shift Operator(>>)
        -----------------------

        1. Shifts all the bits to the right by one place, the empty space is filled with 0. (Logical Right Shift) 

        2. Any binary number shifted to right once, is actually half of the previous number i.e. divided by its base.

        3. If we shift binary number 'a', b times, it becomes a/2^b



     */
    public static void main(String[] args) {

        // System.out.println(resetBit(5, 1));
        System.out.println(magicNum(5,10));

        // System.out.println(power(2, 10));

        System.out.println(5>>1);


        int [][] image={{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};

        int [][] newImage= flipAndInvertImage(image);

        for(int[] row:newImage){
            System.out.println(Arrays.toString(row));
        }

        
    }
    
    static boolean isOdd(int n){
    /* 
        Q1: Check the given number A is odd or even.

        Approach: We know, if the LSB of the binary equivalent of a number is 1, it is odd. Otherwise, in case of 0, it is even. For details about this, watch the lecture (part 1).

        Therefore, to get the LSB, we can simply perform AND operation like this, A & 1.
        
        The Binary Equivalent of 1 is 000001. Therefore all the bits of the binary equivalent of A will be ANDed with 0 and the LSB of A will be ANDed with 1. 

        As a result, it only returns the LSB (0 or 1).  

    */
        return (n & 1)==1;      // If the output of the AND operation is 1, it will return true, else it will return false.
    }

    static int findUnique(int[] arr){
    /* 
        Q2: In a given array, all the numbers appear twice (or even times). Find the number with single appearance.

        We know if similar bits are XORed, it gives 0. If 0 is XORed with some other bit, it always gives that bit.

        Therefore, if we XOR all the elements of the array, it gives the number that appears once only. (As all the duplicates will result in 0 ).
            
    */  
        int unique=0;       // It is taken as 0 because A^0, gives A itself.

        for (int i : arr) {
            unique^=i;
        }
        return unique;
    }

    static int findBit(int num,int n){
    /* 
        Q3. Find the nth bit of a given number.

        The idea is simple, we have to perform AND on the desired bit with 1, remaining bits are to be ANDed with 0.

        Therefore, we need to create a mask value that contains 1 at its nth bit and rest of the bits are 0.

        We can accomplish that with the help of Left Shift Operation.
    
    */
        int mask= 1<<n-1;     // To get the nth bit, we need 1 followed by n-1 zeros. i.e. we need to left shift 1, (n-1) times

        // System.out.println((num&mask));      // This output can either be 0 or decimal equivalent of the resultant binary number. Therefore, the following logic is implemented.

        if((num&mask)!=0){
            return 1;
        }
        return 0;
    }

    static int setBit(int num, int n){
        /* 
         Q: Set the ith bit.

            Here, we need to set the ith bit of the given number to 1 (even if it is 1)

            First, we shall create a mask that contains 1 at its ith position and rest of the bits are 0.

            Perform Bitwise OR operation on these two.
        */ 
        
        int mask= 1<<n-1;
        return num|mask;
    }

    static int resetBit(int num,int n){
        /* 
         Q: Reset the ith bit.

            Here, we need to set the ith bit of the given number to 0 (even if it is 0)

            Firstly, we have to create a mask that contains 0 at its ith position and rest of the bits are 1.

            To create that mask, we shall create a mask containing 1 at its ith position and take complement of it.

            Perform Bitwise AND operation on these two.
        */ 
        int mask= ~(1<<n-1);
        return num&mask;    
    }

    static int posOfSetBit(int num){
        /* 
         Q: Find the position (from right) of the right most set bit.

            We have to take the 2's complement of the given number and perform bitwise AND with the given number.

            Taking log(base 2) of the result and add 1 to get the position. If we want the index, we do not need to add 1. Take any number and experiment with that.
            
            For details, checkout the lecture.
         */
        int twos_Complement= ~num+1;
        
        return (int)(Math.log(twos_Complement&num)/Math.log(2))+1;
    }

    static void searchUnique(int [] arr){

        /* 
         Q: In a given array, all the numbers appear thrice (or odd times). Find the number with single appearance. 

            Take sum of all the elements. Modulo the result with three (or, the number of times each elements appear) and we shall get the result.

            Try on pen-paper for better understanding.

        */
    }

    static int magicNum(int n,int b){ //https://www.geeksforgeeks.org/problems/magic-number4431/1
        /* 
         Q: Find the nth magic number having base b (here, it is 5 as per the problem statement).

            Check the lecture to find out what is magic number and the detailed approach for the solution.
        */

        int ans=0,base=b;
        while(n>0){
            int last=n&1;
            n=n>>1;
            ans+=last*base;
            base*=b;
        }
        return ans;
    }

    static int noOfDigits(int n,int b){
        /* 
         Q: Find the number of digits in n having base b.

            Formula: 
                We need to take the integer value of "log of n to the base b" , and add 1 to it.
        */

        int ans= (int)(Math.log(n)/Math.log(b)+1);
        return ans;
    }

    static int findSumofPascalRow (int n){
        /* 
         Q: Find the sum of the nth row of Pascal's Triangle.

            Basically, the sum of the first row of Pascal's Triangle is 1 (2^0)
            That of the second is 2 (2^1)
            That of the third is 4 (2^2) and so on...

            Checkout the lecture for details
        */
        return 1<<(n-1); 
    }

    static boolean powOfTwo(int n){
        /* 
         Q: Find whether the given number is a power of two. (i.e. 1,2,4,8,16 etc.)

            2 (10 in binary) is a power of two, it is sum of 01+1 (in binary)

            8 (1000 in binary) is a power of two, it is sum of 111+1 (in binary)

            16 (10000 in binary) is a power of two, it is sum of 1111+1 (in binary)

            From the above pattern, we can conclude that the result of AND operation on n (given number) and n-1, gives 0 only if n is a power of 2.

            E.g. 15 is not a power of 2, therefore 15&14 != 0

        */
        if(n==0) return false;
        return (n&(n-1))==0;
    }

    static int power(int a,int b){ // T.C. O(log b)
        /* 
         Q: Find a^b.
         
         Suppose, we want to find 3^6. We can write 6 as 110 in binary, here 3 is base and 6 is exponent.

         Therefore, 3^6= 3^110 . We can also say, 3^110 = 3^4 * 3^2 * 3^0  i.e. for each set bit, the base has to be raised at corresponding place value of the set bit and multiplied.  
        */

        int ans=1;
        while(b>0){
            if((b&1)==1){
                ans*=a;
            }
            a*=a;
            b=b>>1;
            
        }
        return ans;
    }

    static int countSetBits(int n){
        /* 
         Q: Find the number of set bits in n.

            If we perform n&(n-1) successively, at each step a set bit is removed from n. We get the new number as the result.
            Therefore, no of set bits in n = no of steps required till n becomes 0.

        */

        int count=0;
        while(n>0){
            count++;
            n=n&(n-1);
        }
        return count;

    }

    static int findXOR(int n){
        /* 
         Q: Find XOR of numbers from 0 to a.

            There is a pattern in the results of (0^1),(0^1^2),(0^1^2^3) and so on. Based on that pattern, we have to solve this problem. 

            Refer to the video lecture for any doubt.

        */
        if(n%4==0) return n;

        if(n%4==1) return 1;

        if(n%4==2) return n+1;

        return 0;
    }

    static int findRangedXOR(int a, int b){
        /* 
         Q: Find XOR of numbers from a to b , where a<b.

            The idea is to find XOR of numbers from 0 to b and store it.

            After that, we need to find XOR of nubers from 0 to a-1 and store it again.

            Finally, we can XOR these two to get our answer. (The extra part i.e. XOR(0 to a-1) is being eliminated in this way)
        */

        int ans= findXOR(b)^findXOR(a-1);

        return ans;
    }

    static int[][] flipAndInvertImage(int[][] image){
        /* 
         Q: https://leetcode.com/problems/flipping-an-image/description/

        */
        for(int[] row: image){
            // swap
            int start=0,end=row.length-1;  

            while(start<=end){              // Here, as we are inverting each element, we need to run the loop for the last single element too. Therefore, <= is used.

                int temp=row[start]^1;      // While swapping, we can take complement too using XOR operation
                row[start]=row[end]^1;
                row[end]=temp;
                start++;
                end--;
            }
        }
        return image;
    }
}
