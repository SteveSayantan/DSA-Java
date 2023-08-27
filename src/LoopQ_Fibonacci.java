import java.util.Scanner;

public class LoopQ_Fibonacci {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n= in.nextInt();
        in.close();
        // printFibonacci(n);


        //Print the nth Fibonacci Number

        int a=0,b=1,count=2; 

        while(count<=n){ //For count=2 , we are getting the 2nd number. So, we need to run the loop till count=n for the nth Fibonacci Number.
            int temp=b; //initial value of b is stored in temp
            b+=a; //b gets updated with the new value
            a=temp; // a retains the initial value of b 
            count++;
        }
        System.out.println(b);
    }

    static void printFibonacci(int n){ //Print the first n numbers of Fibonacci series 
        int a=0,b=1,count=0;
        System.out.print(a+" ");
        while(count<n){
            System.out.print(b+" ");
            int temp=b;
            b+=a;
            a=temp;
            count++;
        }
    }
    
}
