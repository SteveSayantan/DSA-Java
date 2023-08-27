package Assignments;

public class Patterns_Assignment {
    public static void main(String[] args) {
        pattern12(10);
    }

    static void pattern6(int n){
        for (int row = 0; row < n; row++) {
            for (int space = 0; space < n-row-1; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col <=row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern12(int n){
        for (int row = 0; row < 2*n; row++) {

            int actualSpaces= row>=n? 2*n-row-1:row;

            for (int spaces = 0; spaces < actualSpaces; spaces++) {
                System.out.print(" ");
            }
            for (int col = 0; col < n-actualSpaces; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern18(int n){ //Only works for multiples of 10
        for (int row = 0; row < n; row++) {

            int actual= row>=n/2? n-row-1:row;

            for (int fCol = 0; fCol < n/2-actual; fCol++) {
                System.out.print("*");
            }
            for (int space = 0; space < 2*actual; space++) {
                System.out.print(" ");
            }
            for (int sCol = n/2+actual; sCol < n; sCol++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern108(int n){
        for (int row = 1; row <=n; row++) {
           
            int actualCol= row>n/2 ? n-row+1:row;

            for (int col = 1; col <=n; col++) {

                if((col==actualCol||col==n-actualCol+1) && actualCol!=n/2+1){
                    System.out.print("  ");
                }
                else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
    
}
