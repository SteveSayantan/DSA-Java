import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) { 
        Scanner input= new Scanner(System.in);
        System.out.print("Please enter some input: ");
        int rollno= input.nextInt(); //nextInt method takes the next integer from keyboard (as the input stream is system.in)
        System.out.println("Your roll number is "+rollno);

        input.nextLine();   // Since we will be pressing 'Enter' after passing the previous value, it is important to clear the input buffer like this , for more info checkout https://www.freecodecamp.org/news/java-scanner-nextline-call-gets-skipped-solved/

        System.out.println("Enter your name:");
        String name= input.nextLine();      //nextLine() takes the next line entirely
        System.out.print("Hello, "+name);
        input.close();
    }


    // check the following code snippet:

    int getValidInput(Scanner scanner, String prompt){

        while (true) {

            try {

                System.out.print(prompt);

                int input = scanner.nextInt();

                if (input >= 1 && input <= 10) {

                    return input;

                } else {

                    System.out.println("Please enter a number between 1 and 10.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a whole number.");

                scanner.next(); // Clear invalid input

            }

        }

    }

    /* 
    Why scanner.next() is necessary in the catch block:
    -------------------------------------------------

    When scanner.nextInt() throws an InputMismatchException, it indicates that the input cannot be parsed as an integer e.g. when user enters a string. 
    However, the invalid input remains in the scanner's buffer. If you don't consume this invalid input, 
    the next iteration of the while loop will immediately encounter the same invalid input, 
    causing another InputMismatchException to be thrown. 
    
    This creates an infinite loop, and your program will continuously print "Invalid input. Please enter a whole number." without allowing the user to recover.
    
    You may want to consider using scanner.nextLine() instead of scanner.next() to consume the entire line, including any remaining characters. 
    This can prevent issues if the user enters multiple invalid values separated by spaces (e.g., "abc def").

    
    Difference between next() and nextLine():
    -----------------------------------------
    Both next() and nextLine() are used to retrieve input from the user, but they differ in how they handle the input and the buffer:

    next()
    ------
    => Returns: the next token (a sequence of characters separated by delimiters, which are whitespace characters by default: space, tab, newline, etc.)
    => Buffer behavior:
    => Consumes: the token (i.e., the input up to the next delimiter)
    => Leaves in buffer: any remaining characters on the same line (including the newline character, if present)
    => Example:
    Input: "Hello World" (without quotes)
    next() returns: "Hello"
    Remaining buffer: " World" (including the space)

    ----------
    nextLine()
    ----------
    => Returns: the entire line of input (up to and including the newline character)
    => Buffer behavior:
    => Consumes: the entire line, including the newline character
    => Leaves in buffer: nothing (the buffer is cleared)
    => Example:
    Input: "Hello World" (without quotes, followed by Enter)
    nextLine() returns: "Hello World"
    Remaining buffer: empty
    Key differences:

    Token vs Line: next() returns a single token, while nextLine() returns the entire line.
    Buffer handling: next() leaves the remaining line in the buffer, whereas nextLine() clears the buffer.
    Delimiter handling: next() uses delimiters (whitespace by default) to split input, while nextLine() ignores delimiters and treats the entire line as a single input.
    */

    
}
