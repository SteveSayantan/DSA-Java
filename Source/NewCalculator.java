import java.util.Scanner;

public class NewCalculator {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int ans= 0;

        while (true) {
            char op= in.next().trim().charAt(0);

            if(op=='+'||op=='-'||op=='*'||op=='/'||op=='%'){
                int num1= in.nextInt();
                int num2= in.nextInt();


            }
            else if(op=='x'||op=='X'){
                break;
            }
            else{
                System.out.println("Invalid Operation");
            }
            System.out.println(ans);
            
        }
    }
    
}
