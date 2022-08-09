import java.util.Scanner;

public class Find_the_Factors {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);

        int num= in.nextInt(),c=1;

        while (c*c<=num) {
            if(num%c==0){
                System.out.print(c+" ");
                
                if(c*c!=num){
                    System.out.print(num/c+" ");
                }
            }
            c++;
        }

    }
}
