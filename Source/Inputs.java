import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) { 
        Scanner input= new Scanner(System.in);
        // System.out.print("Please enter some input: ");
        // int rollno= input.nextInt(); //nextInt method takes the next integer from keyboard (as the input stream is system.in)
        // System.out.println("Your roll number is "+rollno);

        String name= input.nextLine(); //nextLine() takes the next line entirely
        System.out.print(name);
    }
}
