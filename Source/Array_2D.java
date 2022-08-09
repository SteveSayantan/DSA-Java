import java.util.Arrays;
import java.util.Scanner;

public class Array_2D {
    public static void main(String[] args) {

        /**
         //Syntax of a 2D array (Array of arrays)

         *  datatype [][] ref_variable_name= new int[3][4]; (Two [] are required to represent 2D array, the [3] represents the number of rows i.e. the number of element arrays. [4] represents number of columns i.e. number of element in each row)
         * 
         *  Example:
         * 
         *  int [][] arr1= new int [5][]; (The number of rows (number of element arrays) is mandatory, but the number of cols (length of each element array) is optional)
         * 
         * The ref_variable is stored in the stack memory. The heap memory stores references each pointing towards an element array.
         * 
         */


        int[][] arr= {{1,3,4},{4,3},{4,6,7,8} }; //We can directly write like this too

        System.out.println(Arrays.toString(arr[2])); //[4,6,7,8]
        System.out.println(arr[2][1]); //6
        System.out.println(arr.length); //3

        //Taking Input 

        Scanner in = new Scanner(System.in);

        int[][] arr2= new int[4][5];

        for (int row = 0; row < arr2.length; row++) {
            //for each col in a row
            for (int col= 0; col < arr2[row].length; col++) {
                arr2[row][col]= in.nextInt();
            }
        }

        //Displaying the Output

        for (int[] ele : arr2) {
            for (int is : ele) {
                System.out.print(is+" ");
            }
            System.out.println();
        }

        /**
         
        for (int row = 0; row < arr2.length; row++) {
            //for each col in a row
            for (int col= 0; col < arr2[row].length; col++) {
                System.out.print(arr2[row][col]+" ");
            }
            System.out.println();
        }
        
        **/  



       
        
    }
}
