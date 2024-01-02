public class Recursion_Basics {
    public static void main(String[] args) {
      print(1);  
    }

    //Print all numbers from 1 to 5 just by calling one function

    //Approach 1:
    static void message1(int n){
        System.out.println(n);
        message2(2);
    }
    static void message2(int n){
        System.out.println(n);
        message3(3);
    }
    static void message3(int n){
        System.out.println(n);
        message4(4);
    }
    static void message4(int n){
        System.out.println(n);
        message5(5);
    }
    static void message5(int n){
        System.out.println(n);
    }
    /* 

    Explanation: (How function calls work internally)

        1. While the function is not finished executing it will remain in the stack memory

        2. In Java, the main is the first function to be executed. Hence, it enters the stack first.

        3. It calls the message1 function with 1 as a parameter. As a result, message1(1) enters the stack. main sits in the stack already.

        4. After printing 1, message1 calls message2 with 2 as a parameter. As a result, message2(2) enters the stack.

        5. After printing 2, message2 calls message3 with 3 as a parameter. As a result, message3(3) enters the stack.

        6. This process continues till message5(5) is called by message4. message5(5) enters the stack.

        7. As message5 does not call any other function, it prints 5 and leaves the stack. (When a function finishes executing, it is removed from the stack)

        8. The flow of function is restored to where the function is called. In this case, the flow goes back to where message5 was called i.e. at message4.

        9. As message4 has nothing to do anymore, it also leaves the stack and the flow of function goes back to where message4 was called i.e. message3.
        
        10. This process continues till the main function leaves the stack and program gets over.
    */

    //Approach 2:

    static void print(int n){
        System.out.println(n);
        if(n==5) return;

        print(n+1); //This function call is the last statement of the parent function. This is why it is called tail recursion. 
        
        /* 
            Refer to Recursion_Questions.java , https://www.geeksforgeeks.org/tail-recursion, https://www.geeksforgeeks.org/tail-call-elimination/ for more details
            on tail-recursion and its benefits over non-tail recursion .
        */
    }

    //Recursion: When a function calls itself is called recursion.

    /* 
    Explanation:

        1. At first, main function is called and it enters the stack.

        2. Secondly, main calls print with 1 as a parameter. print(1) enters the stack.

        3. After printing 1, print(1) calls itself again with 2 as a parameter. print(2) enters the stack.

        4. After printing 2, print(2) calls itself again with 3 as a parameter. print(3) enters the stack.

        5. This process continues till print(5) prints 5.

        6. As n==5 (Base Condition),  print(5) leaves stack and the flow of program is returned to print(4).

        7. As print(4) has finished executing, it leaves the stack too, and this process continues till main leaves the stack and the program gets over.


    Note: Though the same function is called repeatedly (before the previous function call is over), each call would require separate memory allocation in the stack.

    Base Condition: Condition where our recursion will stop making new calls. Without Base Condition, the function calls will fill up the stack memory and result in StackOverFlow Error when the memory of the computer exceeds.

    Recursion has a space complexity of O(N) i.e. the height (max length of path) of the recursion tree
    */

    //Uses of Recursion:

    /* 
        1. It helps us in solving bigger, complex problems in a simple manner.

        2. Recursion solutions can be converted into iterations (Loops) and vice-versa.

        3. Space complexity is not constant. As each function call takes some space in the stack.
   
    
    */
}
