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
       */ 
      System.out.println(Fibo(4));
    }

    static int Fibo(int n){ //Print nth Fibonacci Number
        /* 
            1. Nth Fibonacci Number= (N-1)th Fibonacci Number + (N-2)th Fibonacci Number (It is the Recurrence relation)

            2. The Base Condition is represented by answers we already have i.e. F(0) is 0, F(1) is 1.

            3. Refer to the video lecture for any doubt.

        */

        if(n<2) return n;
        return Fibo(n-1)+Fibo(n-2); // The return value of each Fibo function depends on the functions returned by it. So it is **not** tail recursion.
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

        if(target<arr[mid]){
            return binarySearch(arr, target, start, mid-1);
        }

        return binarySearch(arr, target, mid+1, end);


    }
}
