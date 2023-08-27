import java.util.Scanner;

public class LoopQ_CaseCheck {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);

        char ch= in.next().trim().charAt(0); //next() method takes the next word as input. trim() method removes whitespaces from the end and the beginning of the string. charAt() method returns the character at given index

        in.close();
        
        if(ch>='A'&& ch<='Z'){ //checks if the int value of the given char lies b/w that of A and Z

            System.out.println("UpperCase");
        }
        else{
            System.out.println("LowerCase");
        }
    }
    
}
