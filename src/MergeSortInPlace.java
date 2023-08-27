import java.util.Arrays;

public class MergeSortInPlace {

    // For any doubt, refer to https://www.youtube.com/watch?v=1C6BCqehm-c&t=4s

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        mergeSortInPlace(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    static void mergeSortInPlace(int[] arr, int s, int e) {
    if (e==s) {
        return;
    }

    int mid = (s + e) / 2;                          // Take the middle element

    // Recursively solve the two parts including the middle element

    mergeSortInPlace(arr, s, mid);
    mergeSortInPlace(arr, mid+1, e);

    // Now, we have two sorted arrays to join together . This is done by mergeInPlace function
    mergeInPlace(arr, s, mid, e);
    }

    static void mergeInPlace(int[] arr, int s, int m, int e) {

        int[] mix = new int[e - s+1];               // Calculate the total number of elements and declare a new array for storing sorted data
        int k = 0;                                  // This will indicate the index of mix

        int i = s,j = m+1;                          // Take a pointer at start (it will travel till mid) and another one at mid+1 (it will travel till end)

        while (i <= m && j <= e) {

            if (arr[i] < arr[j]) {                  // If the element at i is smaller, include it in mix
                mix[k] = arr[i];
                i++;
            } else {                                // If the element at j is smaller, include it in mix
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete. In that case, copy the remaining elements

        while (i <= m) {                            // If the first array is incompletely traversed
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j <= e) {                            // If the second array is incompletely traversed
            mix[k] = arr[j];
            j++;
            k++;
        }

        // Now, just copy mix to the original array

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
}
