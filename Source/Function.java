public class Function {
    public static void main(String[] args) {
       Greet(); //Calling the function 
    
        int A= 10,B=20;
        System.out.println(sum(A,B)); //The function sum returns the integer value which is printed by System.out command

        String name= "Jenny"; // name reference variable is pointing towards "Jenny" object
        System.out.println(GreetwName(name));
    }

    /**
     
     //Syntax of a function in Java
    
    access_modifier return_type function_name(args){
        //body
    }

    **/

    static void Greet(){ //Currently, ignoring the access modifiers. As our main function is static, any function called inside main must be static too.
        System.out.println("Hello there!! Have a nice day!!");
    }

    static String GreetwName(String id){ //A copy of the value of the reference variable <name> is passed to <id> (as <name> contains a reference data type), hence <id> is also pointing towards "Jenny" 

        //id is accessible only within this scope, any modifications in the value of <id> may result into the change in value of <name> as they are pointing towards the same object (However,in this case, modification is not possible as we are dealing with String)

        return "Hello "+id+" F yourself";
    }

    static int sum(int a, int b){ // The value of A (10) is passed to a,the value of B (20) is passed to b (As these are primitive datatype) 

        //a and b are only accessible inside this scope, any changes in the values of a & b will not affect the value of A & B (As they have already passed their values).

        int sum= a+b;
        return sum; //sum is the return value of this function, which is an int . Any statement after 'return' will not be executed
        // return a+b; (Shortcut)
    }





}
