public class Recursion_Questions {
    public static void main(String[] args) {
       /* 
        Steps to identify and solve a Recursion problem:

            1. Try to break down a problem into smaller ones

            2. Write the recurrence relation if needed.

            3. Draw the recursion tree using pen and paper.

            4. About the tree:
                a. See the flow of functions, how they getting in stack.

                b. Indentify the left tree calls and right tree calls.
            
            5. See how the values (and their types) are returned in each step and keep an eye on the flow of function.

        Generic steps to solve a Recursive Problem:
        -----------------------------------

            Let f(n) be a recursive function

            1) Show f(1) works (i.e. base case)

            2) Assume f(n-1) works

            3) Show f(n) works using f(n-1)
       */ 
          System.out.println(reverseNum(1021));
        // printDescending(10);
    }

    static int Fibo(int n){ //Print nth Fibonacci Number
        /* 
            1. Nth Fibonacci Number= (N-1)th Fibonacci Number + (N-2)th Fibonacci Number (It is the Recurrence relation)

            2. The Base Condition is represented by answers we already have i.e. F(0) is 0, F(1) is 1.

            3. Refer to the video lecture for any doubt.

        */

        if(n<2) return n;
        return Fibo(n-1)+Fibo(n-2); // Any of these function calls made by Fibo function are not the last statement (Adding and returning the received values is the last step) of the function. So it is **not** tail recursion.
    }
    

    /* 

    Types of variables used in Recursion:

        1. Variables used as Arguments (These variables will be used in the next function calls)

        2. Variables used as Return Type (Whatever the function has to return )

        3. Variables used in the Body of the function (These variables are specific to each function call)

    */

    static int binarySearch(int[] arr, int target, int start,int end ){ //For any doubt, checkout the video lecture

    //For BinarySearch the recurrence relation is as follows: F(N)= O(1)+F(N/2)  where, O(1) represents the time complexity of the comparison made in each step, and F(N/2) represents the division of given array in two parts 
    
    /* Types of Recurrence Relation:
    
        1. Linear Recurrence Relation e.g. Fibonacci Numbers (In this case, the search space gets reduced in a negligible rate. This is why it is inefficient )

        2. Divide and Conquer Recurrence Relation e.g. Binary Search (In this case, the search space gets divided into two parts in each step i.e. reduced by a factor. It is very efficient)
    
    */

    // Important: If the main function has a return condition, we need to return the same type from each sub-recursion call

        if(start>end){
            return  -1;
        }

        int mid= start+(end-start)/2;

        if(arr[mid]==target){
            return mid;
        }

        // It is an example of tail-recursion
        if(target<arr[mid]){
            return binarySearch(arr, target, start, mid-1);
        }

        return binarySearch(arr, target, mid+1, end);


    }

    // Recursion Easy Questions
    static void printDescending(int n){
        if(n==0) return;
        System.out.println(n);      // Prints while going
        printDescending(n-1);
    }

    static void printAscending(int n){
        if(n==0) return;
        printAscending(n-1);        // Prints while returning
        System.out.println(n);
    }

    static void printBoth(int n){
        if(n==0) return;
        System.out.println(n);     // Prints both ways
        printBoth(n-1);
        System.out.println(n);
    }

    static int sumOfDigits(int n){
        if(n==0) return 0;
        return (n%10)+sumOfDigits(n/10);
    }

    static int productOfDigits(int n){
        if(n<10) return n;       // If there is only one digit, return it
        return (n%10)*productOfDigits(n/10); 
    }


    static int reverseNum(int n){       
        int digits= (int)Math.log10(n)+1;       
        return reverseHelper(n, digits);        // since, we do not want to use global variable to store the ans, we are using helper function
    }
    static int reverseHelper(int n,int noOfDigits){
        if(n%10==n) return n;
        int rem= n%10;
        return (int)Math.pow(10, noOfDigits-1)*rem + reverseHelper(n/10, noOfDigits-1);    // At every stage, it multiplies the remainder with 10^(no. of Digits) and adds value returned by the recursion call.
    }


    static boolean isPalindrome(int n){
        return n==reverseNum(n);
    }

    static int calculateZeros(int num){

        if(num<10){
            if(num==0) return 1;
            return 0;
        }
        
        int count = num%10 != 0 ? 0 : 1;
        
        return count+calculateZeros(num/10);
    }

    public double myPow(double x, long n) {     // https://leetcode.com/problems/powx-n/description/

        if(n<0) return 1/myPow(x,-n);

        if(n==0) return 1;

        if(n==1) return x;

        int lastBit= (int)n&1;

        if(lastBit!=0) return x*myPow(x*x,n/2);

        return myPow(x*x,n/2);
    }

}
