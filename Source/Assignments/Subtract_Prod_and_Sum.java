import java.util.Scanner;

public class Subtract_Prod_and_Sum {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int num= in.nextInt(), prod= 1, sum=0;

        while (num>0) {
         int rem= num%10;
         prod*=rem;
         sum+=rem;
         num/= 10;
        }
        System.out.println(prod-sum);
    }
}
