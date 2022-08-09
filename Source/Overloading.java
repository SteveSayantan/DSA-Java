import java.util.Arrays;

public class Overloading {

    //When we have multiple methods with the same name, but they take different number or type of arguments , is known as function overloading. The return type (void/int etc.) of the functions do not matter.
    public static void main(String[] args) {
 

       fun(12); //This calls the first fun, it will not call the fun with variable args as we already have a fun that takes a integer argument. If we did not have the first fun, it would have called the fun with variable arguments.

       System.out.println(fun("Steve")); //This calls the fun which accepts a string as input

       fun(45,78); //This calls the second fun which takes two integers, it will not call the fun with variable args as we already have a fun that takes two integers as arguments

       fun(); //This calls the fun with variable args as we don't have any fun other than that one which may take zero arguments.


    }

    static void fun(int a){ //This fun is taking an integer as input
      System.out.println("First One "+a);  
    }

    static void fun(int a, int b){ //This is taking two integers as input
        System.out.println("Second One "+a+" "+b); 
    }
    
    static void fun(int ...arr){
        System.out.print("Variable args");
        System.out.println(Arrays.toString(arr));
    }
    static String fun(String a){ //This takes a string as input
        return a;
    }

}
