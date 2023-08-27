import java.util.Arrays;

public class Array_2D_BinarySearch {
    public static void main(String[] args) {
        
        int [][] arr={
                    {10,20,30,40},
                    {15,25,35,45},
                    {28,29,37,49},
                    {33,34,38,50}
                };


      

        int[][] sortedArr ={
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(Arrays.toString(sortedSearch(sortedArr, 1)));



    }
    static int[] search(int[][] arr,int target ){ //Given matrix is row wise and column wise sorted (But the last element in a row and the first element of the next row might not be sorted )

        /* The row pointer moves N times and the column pointer moves N times in the worst case, therefore the time complexity of this search is O(N+N)= O(2N)= O(N) */

        int r=0,c=arr.length-1; //We are starting the search from the element at top right corner. In case of rectangular (m*n) matrix, the r pointer will search from 0 till r<m and the c pointer will search from n-1 till c>=0. 

        while(r<arr.length && c>=0){
            if(arr[r][c]==target){
                return new int[]{r,c};
            }
            else if(arr[r][c]>target){ //If the element is greater than the target, the rest of the elements in that column will be greater than the target (because it is sorted), so discard that column.
                c--;
            }
            else{ //If the element is less than the target, the rest of the elements in that row will be less than the target (because it is sorted), so discard that row.
                r++;
            }
        }
        return new int[] {-1,-1};
    }



    static int[] sortedSearch(int[][] arr,int target){ //Given matrix is strictly sorted i.e. both row-wise and column wise such that the last element in a row is less than the first element of the next row .

        // Ref: https://youtu.be/ZYpYur0znng
        // Here, instead of considering the given 2D array as a matrix, we would consider it as a sorted array and apply BS as usual.

        if(arr.length==0) return new int[]{-1,-1};

        int start=0, end = arr.length*arr[0].length-1;  // index of last element= (total no. of elements-1)

        while(start<=end){
            int mid= start+(end-start)/2;

            int row= mid/arr[0].length;         // calculating the row index
            int col= mid%arr[0].length;            // calculating the column index

            if(arr[row][col]>target){
                end=mid-1;
            }
            else if (arr[row][col]<target){
                start=mid+1;
            }
            else{
                return new int[]{row,col};
            }
        }
        return new int[]{-1,-1};
    }
    
}
