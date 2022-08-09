import java.util.Scanner;

public class LoopQ_LargestNum {
    public static void main(String[] args) {
        //Q: Take three numbers as input and find the largest one

        Scanner in= new Scanner(System.in);

        int num1= in.nextInt();
        int num2= in.nextInt();
        int num3= in.nextInt();

        int max=0;
        if(num1>num2){
            max=num1;
        }
        else{
            max=num2;
        }

        if(num3>max){
            max=num3;
        }

        System.out.println(max);

        /**
         * It can be also done using Math obj. Math.max() method takes two numbers as input
         * 
         * int max= Math.max(c,Math.max(a,b))
         * 
         */
    }
    
}
