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

        pascalsTriangle(6);
    }

    public static void pattern1(int n){
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

    static void pascalsTriangle(int height){

        /* 
            Using the nCr formula, the representation for Pascal's triangle becomes:

                       0C0
                    1C0   1C1
                2C0   2C1   2C2
             3C0   3C1   3C2   3C3   
            ...
        */
        for (int i = 0; i < height; i++) {
            
            for (int j = 0; j < height-i-1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k <=i; k++) {
                int factorial= getCombinatorial(i, k);
                System.out.print(factorial+" ");
            }

            System.out.println();
        }
    }

    private static int getCombinatorial(int n, int r){      // gives the nCr value
        
        int nPr= getFactorial(n)/getFactorial(n-r);

        return nPr/getFactorial(r);
    }

    private static int getFactorial(int n){

        if(n==0) return 1;

        if(n<3) return n;

        return n*getFactorial(n-1);
    }
}
