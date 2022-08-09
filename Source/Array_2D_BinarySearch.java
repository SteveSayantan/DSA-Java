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
    static int[] search(int[][] arr,int target ){ //Given matrix is row wise and column wise sorted

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



    static int[] sortedSearch(int[][] arr,int target){ //Given matrix is strictly sorted, we shall have two rows when this function is over

        int rStart=0,rEnd=arr.length-1,cMid=arr[0].length/2; //Column wise we are considering the middle coulmn

        while(rStart<(rEnd-1)){ //In case of rStart<rEnd, rStart will be equal to rEnd when the loop breaks. But in this case, rStart will be greater than rEnd (rStart>rEnd) when the loop breaks, i.e. rStart=rEnd+1;

            int mid= rStart+(rEnd-rStart)/2; //Row wise, we are considering the middle row while starting

            if(arr[mid][cMid]==target){
                return new int[] {mid,cMid};
            }
            else if(arr[mid][cMid]<target){ //If the element is less than target,the previous row should be discarded (But the other elements in the current row might contain the target)
                rStart=mid;
            }
            else{   //If the element is greater than target, next rows should be discarded (But the other elements in the current row might contain the target)
                rEnd=mid;
            }
            
        }

        //Now we have two rows, apply BS accordingly

        if(target>=arr[rStart+1][0]){
            return binarySearch(target, arr, rStart+1);
        }
        else{
            return binarySearch(target, arr, rStart);
        }
    }
    static int[] binarySearch(int target,int[][] arr,int row){
        int start=0,end=arr[row].length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(arr[row][mid]==target){
                return new int[]{row,mid};
            }
            else if(arr[row][mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
