public class Patterns {
    public static void main(String[] args) {
        /* 
        Steps to solve any Pattern Question:

        1. No of lines = No. of rows = No. of times outer loop will run

        2. For each row, identify:
            a. No. of columns
            b. Type of element in column

        3. Try to find the formula relating rows and columns 

        4. Print the element
        
        */
        pattern31(4);
    }

    static void pattern1(int n){
        for (int row = 0; row < n; row++) {
            //For each row, run the col
            for (int col = 0; col <n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int row = 0; row < n; row++) {
            //For each row, run the col
            for (int col = 0; col <=row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int row = 0; row < n; row++) {
            //For each row, run the col
            for (int col = 0; col <n-row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int row = 0; row < n; row++) {
            //For each row, run the col
            for (int col = 0; col <=row; col++) {
                System.out.print(col+1+" ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n){
        for (int row = 0; row <2*n-1; row++) {
            //For each row, run the col
             
            int totalColsInRows= row>=n ? 2*n-row-2 : row;

            for (int col = 0; col <=totalColsInRows; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n){
        for (int row = 0; row <2*n-1; row++) {
            //For each row, run the col
             
            int totalColsInRows= row>=n ? 2*n-row-2 : row;

            int noOfSpaces= n-totalColsInRows-2;
             
            for (int s = 0; s <=noOfSpaces; s++) {
                System.out.print(" ");
            }

            for (int col = 0; col <=totalColsInRows; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern30(int n){
        for (int i = 1; i <=n; i++) {
            for (int space = 1; space <= n-i; space++) {
                System.out.print("  ");
            }
            for (int j = i; j >=1; j--) {
                System.out.print(j+" ");
            }
            for (int k = 2; k <=i; k++) {
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n){
        for (int row = 1; row < 2*n; row++) {

            int c= row > n ? 2*n-row:row;

            for (int space = 1; space <= n-c; space++) {
                System.out.print(" ");
            }
            for (int j = c; j >=1; j--) {
                System.out.print(j);
            }
            for (int k = 2; k <=c; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    static void pattern31(int n){
        for (int row = 0; row < 2*n-1; row++) {
            for (int col = 0; col < 2*n-1; col++) {
               int atEachIndex= n-Math.min(Math.min(row,col),Math.min(2*n-2-row,2*n-2-col)); 
               System.out.print(atEachIndex+" ");
            }
            System.out.println();
        }
    }
}
