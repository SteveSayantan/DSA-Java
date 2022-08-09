import java.util.Arrays;

public class CycleSort {

    
        // 1. When given numbers in the array are from range 1 to N or 0 to N-1 (N is the length of the array, given numbers are continuous ) ==> use Cyclic Sort
        // 2. The time complexity of Cycle sort is O(N).  
   
    public static void main(String[] args) {
        int[] nums={3,5,2,1,4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] arr){
        //For detailed working principle, check out the video
        
        int i=0;
        while(i<arr.length){ //In case of cycle sort, the loop must run N times, otherwise it will not work properly
            int correct= arr[i]-1;
            if(arr[i]!=arr[correct]){   //Check if the element at the current index is same as the element at the correct index. This check can handle duplicates too.
               swap(arr,i,correct) ;
            }
            else{
                i++;
            }
        }
    }

    static void swap(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
