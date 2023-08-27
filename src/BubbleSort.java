import java.util.Arrays;

public class BubbleSort {
    //This algorithm is also known as Sinking Sort and Exchange Sort. It is an Inplace sorting algorithm and Stable in nature.

    //Space complexity of this algorithm is constant and Time Complexity in the best case (when the array is already sorted) is O(N) and in the worst case (When the array is sorted in descending order) is O(N^2)

    //Stable sorting: If the original order of the duplicates is maintained in the sorted array, is known as Stable sorting.

    //Unstable sorting: If the original order of the duplicates is not maintained in the sorted array, is known as Unstable sorting.

    //Though the time complexity of BubbleSort and SelectionSort is the same, for larger input size the latter one takes less CPU time as no of swaps is less.

    public static void main(String[] args) {
        int[] nums={3,1,5,4,2};
        Bubble(nums);
        System.out.println(Arrays.toString(nums));
    }

    //For detailed working principle check out the video lecture
    static void Bubble(int[]arr){
        for (int i = 0; i < arr.length-1; i++) { //Run the outer loop for N-1 times.

            boolean isSwapped=false;

            for (int j = 1; j < arr.length-i; j++) {  

                //Swap if the item is smaller than the previous item

                if(arr[j-1]>arr[j]){
                    int temp= arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    isSwapped=true;
                }
            }
            if(!isSwapped){ //For any value of i, if no swapping occurs that means the array is sorted, so break the loop
                break;
            }
        }
    }

}
