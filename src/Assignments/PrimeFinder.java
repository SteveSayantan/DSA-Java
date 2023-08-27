package Assignments;

public class PrimeFinder {
    public static void main(String[] args) {
        PrintPrime(4,5);
    }

    static void PrintPrime(int num1,int num2){

      if(num1<0||num2<0||num1+1>=num2) {
          System.out.println("Invalid Range");
          return;
        }

      for (int i = num1+1; i < num2; i++) {
         if(PrimeOrNot(i)) System.out.print(i+" ");
      }
        
    }

    static boolean PrimeOrNot(int num){ //Check if the number is a Prime Number
        if(num==0||num==1)return false;

        int c=2;
          while(c*c<=num){
              if(num%c==0) return false;
              c++;
          }
          return true;

    }
}
