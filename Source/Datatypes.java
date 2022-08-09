import java.util.Scanner;

public class Datatypes {
    public static void main(String[] args) { 
        System.out.println("Hey!!Whassup");
        Scanner input= new Scanner(System.in); //System.in denotes the standard input stream (keyboard). Scanner class is used to take inputs 
        System.out.println(input.nextInt()); //This line prints the integer value next to input

        byte small= 54; //stores 1 byte, value ranges from -128 to 127, default value 0
        short length= 108; //stores 2 bytes,default value 0
        int rollNo= 108654634; //We can also write like this 234_000_356, stores 4 bytes, default value 0
        long largeInteger= 4554655645454545454L;//By default, the type is integer, to store it as a long we *must* use L, default value 0, stores 8 bytes
        float marks = 98.35f; //All the decimal values are double in nature, to store it as a float we *must* use f (except user input), stores 4 bytes, default value is 0.0f
        double largeDecimalNumbers= 5656536.65464; //default value 0.0d, stores 8 bytes
        boolean check = true; //default value is false.
        char letter= 'r'; //char starts with '', String starts with "". Stores 2 bytes. Supports unicode characters.Its value ranges from 0 to 65535 (2^16-1)

        //The values provided are called literals.
        //The variables,name of class,methods,packages are called identifiers.

        //**Checkout CWH's video on Precedence and Associativity**
    
        /**Formula to determine the range of different datatypes
         * 
         * 
         *  We know short stores 2 bytes. 2*8=16 bits;
         * 
         *  Its range lies between -(2^16)/2 to (2^16)/2-1 (1 is subtracted because there is a 0)
         *  
         * We know int stores 4 bytes. 4*8=32 bits;
         * 
         * Its range lies between -(2^32)/2 to (2^32)/2-1 (1 is subtracted because there is a 0)
         * 
         */
        int num=1463847412;
        int num2= 2147483641;
    }
}
