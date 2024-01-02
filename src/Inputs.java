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
}
