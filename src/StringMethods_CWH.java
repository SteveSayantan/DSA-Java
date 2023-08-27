import java.util.Arrays;

public class StringMethods_CWH {
    public static void main(String[] args) {
        
    //String Methods do not change the existing string (As Strings are immutable). Instead, they create a copy of the string , modify and return it.


/*
 

*/

        String str= "Steve";
        System.out.println("Steve".length()); //5 Returns the length of the string

        System.out.println(str.toUpperCase()); //Changes the charactes to Uppercase, toLowercase() does the opposite.

        String whiteSpace= "  Steve  ";
        System.out.println(whiteSpace.trim()); //"Steve"

        System.out.println(str.substring(2)); //eve   Takes two arguments startIndex and endIndex. If endIndex it not provided, it will traverse till the end of the string. 
        System.out.println(str.substring(2,4)); //ev   When the endIndex is provided, it will go till endIndex-1. 


        System.out.println("Harry".replace('r','p')); //Happy  replaces all the occurrences of oldchar(r) in this string with newChar(p).
        System.out.println(str.replace("ve","am")); //Steam  replaces all the occurrences of ve in this string with am. (from beginning to end)


        System.out.println(str.startsWith("S")); //true 
        System.out.println(str.startsWith("e",3)); //false  Tests if the substring of this string beginning at the specified index starts with the specified prefix.
        System.out.println(str.endsWith("e")); //true  


        System.out.println(str.charAt(3)); //v

        System.out.println(str.indexOf('e')); //2  Returns the index at which the character occurs first. If a string is supplied, it will return the first occurrence of that string. Returns -1 if not found.
        System.out.println(str.indexOf('e',3)); //4  Returns the index at which the character occurs from the given index. Same applies in case of a string.

        System.out.println(str.lastIndexOf('e')); //4   Returns the index at which the character occurs for the last time.It searches from backwards. We can find the last occurrence of a string too.Returns -1 if not found.
        System.out.println(str.lastIndexOf('e',3)); //2   Returns the index at which the character occurs from the given index while searching backwards.Same applies in case of a string.

        System.out.println(str.equals("Steve")); //true     Used to compare only the "values" of two strings. Does not care about if the reference variables are pointing towards the same object or not. Case sensitive.
        System.out.println(str.equalsIgnoreCase("sTeve")); //true  Case insensitive.

        System.out.println(Arrays.toString(str.toCharArray())); //Creates a character array from the given string

        System.out.println(Arrays.toString(str.split("e"))); //Splits the string on basis of "e" and returns an array

        
        
    }
}
