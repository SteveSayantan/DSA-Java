import java.util.ArrayList;

public class String_CWH {
    public static void main(String[] args) {
        
        //A string is a sequence of characters and they are immutable (can not be changed) due to security reasons.

        //Creating a new String
        String name= "SteveSayantan";
        String nameB= "SteveSayantan"; // When we create string objects with similar values, instead of creating multiple same objects, one object stored in the String Pool (A separate memory in Heap Memory) and different reference variables point towards it. 


        String name2= new String("Sweet"); //String is a class, name2 is the reference variable and "Sweet" is the object;
        String name3= new String("Sweet"); // as new keyword is used, name2 and name3 are two separate objects stored in heap memory (outside the pool)
        
        //Compairing Strings

        // == checks the value and if the reference variables are pointing towards the same object.

        System.out.println(name==nameB); //true as the values are the same and both the reference variables are pointing towards the same object in String Pool


        System.out.println(name2==name3); //false though the values are the same but the reference variables are pointing towards two different objects in Heap Memory




        //Printing a String
        
        System.out.println(name2); //Traditional Method

        System.out.format("%s",name2); 
        System.out.printf("The nature of %s is %n%s", name,name2); //Both are the same
       
        /**
         *  %d for int (also works for long)
         *  %f for float (also works for double)
         *  %c for char
         *  %s for string
         *  %n for a new line
         */
        
        //Formatting a neumeric String (For details checkout https://docs.oracle.com/javase/tutorial/java/data/numberformat.html )
        
         double pi= Math.PI;
         System.out.format("%n%10.3f%n", pi); //%10.3f ==> prints total 10 characters and the result is displayed and rounded off upto three decimal places

         //Escape Sequence

         System.out.println("This creates a \n new line"); // \n gives a new line

         System.out.println("This is how we use \" inside a string"); // Use \' to escape single quotes and \\ to escape \.

         System.out.println("It is used as\ttab"); // \t gives a tab

      
        //Operators ('+' is overloaded for string concatenation)

        System.out.println('a'+'b'); //195  Converts both the chars to their ASCII value and adds those (Similarly, we can use other arithmetic operators also)

        System.out.println("a"+"B"); // aB  Concatinates as both are of type String (new String object aB is created)

        System.out.println("a"+'B'); // aB  Converts B to String and concatinates both (new String object aB is created)
        
        System.out.println(3+'B'); // 69   Converts B to its ASCII value and adds both, if we typecast the final result to char, it will give E 

        System.out.println("B"+3); // B3    Converts 3(int) to Integer, calls to toString() method and converts it into a string and concatenates both. (new String object B3 is created)
        
        System.out.println("B"+new ArrayList<>()); // B[]    As ArrayList is an object, it will call toStirng() method for it, and convert it into a string to concatenate both. It creates a new String object.

        System.out.println(56 +""+new ArrayList<>()); // 56[]    + generally works with primitives(characters and numbers only). If used with reference datatypes, + needs minimum one string, otherwise it will give error. (creates a new String object)


        }
}
