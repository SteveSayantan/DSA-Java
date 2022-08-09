import java.util.Arrays;

public class Array2D_LinearSearch {
    public static void main(String[] args) {
        int[][] arr2D= {
            {12,34,45},
            {45,56,67,34},
            {56,108,11,56}
        };

        
        System.out.println(Arrays.toString(findIndex(arr2D, 23)));
        System.out.println(findMax(arr2D));

        

    }

    static int[] findIndex(int[][] arr,int ele){ //Finds the index of the given element
        for (int row = 0; row < arr.length; row++) {

            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col]==ele){
                    return new int[]{row,col}; //{row,col} will not work as we have to initialize the array to be returned using new keyword
                }
            }
        }
        return new int[]{-1,-1};

    }

    static int findMax(int[][] arr){ //Finds the max value 
        int max= arr[0][0];

       for (int[] eleArr : arr) {
            
          for (int ele : eleArr) {
              if(ele>max){
                  max= ele;
              }
          }
    
       }
        return max;
    }
}
