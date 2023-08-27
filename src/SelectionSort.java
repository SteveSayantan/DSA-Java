import java.util.Arrays;

public class SelectionSort {
    //Time Complexity for the Selection Sort in the best case is O(N^2).

    //Time Complexity for the Selection Sort in the worst case is O(N^2), as in any situation, it looks for the max element in the array.

    //It is an unstable sorting operation.
    
    //It works well for small lists.
    public static void main(String[] args) {

        int[] nums={5,4,3,2,1};
        System.out.println(Arrays.toString(Sort(nums)));

    }

    //For detailed working principle check out the video lecture


    
    // With each iteration, the max element is placed at the last index.
   
    static int[] Sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) { //The outer loop will run for N-1 times, as it is futile to run all these for a single element

            int lastIndex= arr.length-i-1; // For reducing the search space with each iteration
            int maxIndex= findMaxIndex(arr,lastIndex);
            swap(arr, maxIndex, lastIndex);
            
        }
        return arr;
    }
    static int findMaxIndex(int [] nums,int end){
        int max= 0;
        for (int i = 0; i <=end; i++) {
            if(nums[i]>nums[max]){
                max= i;
            }
        }
        return max;
    }
    static void swap(int[] nums,int firstIndex,int secondIndex){
       int temp= nums[firstIndex];
       nums[firstIndex]=nums[secondIndex];
       nums[secondIndex]=temp;
    }
}
