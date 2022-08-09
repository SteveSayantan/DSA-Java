import java.util.Arrays;

public class InsertionSort{
    /* 
        1. The time complexity for InsertionSort algorithm in worst case is O(N^2).

        2. The time complexity for InsertionSort algorithm in best case is O(N).

        3. It is adaptive in nature i.e., the number of steps gets reduced if the array is sorted.

        4. It is a stable sorting algorithm and it is used for smaller values of N.

        5. Works good when the array is partially sorted, it is also used in hybrid sorting algorithm.

    */

    //For detailed working principle check out the video lecture
    public static void main(String[] args) {
       int[] arr={5,3,4,1,2};
       Sort(arr);  
       System.out.println(Arrays.toString(arr));
    }

    static void Sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = i+1; j>0; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1); //If the previous element is smaller than the current one, swap those.
                }
                else{ //If an element is not smaller than its previous one, there is no need continue the check, as the left side of the array is sorted
                    break;
                }
            }
        }
    }
    static void swap(int[] nums,int firstIndex,int secondIndex){
        int temp= nums[firstIndex];
        nums[firstIndex]=nums[secondIndex];
        nums[secondIndex]=temp;
     }
     
}