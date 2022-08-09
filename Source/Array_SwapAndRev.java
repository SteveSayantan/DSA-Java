import java.util.Arrays;

public class Array_SwapAndRev{
    public static void main(String[] args) {
        int[] arr= {12,34,45,56,23};
        int[] arr2= {12,34,45,56,23,56};

        //Swap

        /**
         Swap(arr, 3, 1);
         System.out.println(Arrays.toString(arr));

         **/


        //Reverse (Works for both even and odd arrays)
        
        Reverse(arr2);
        System.out.println(Arrays.toString(arr2));
        
    }
    
    static void Swap(int[] array,int ind1,int ind2){
        int temp= array[ind1];
        array[ind1]=array[ind2];

        array[ind2]=temp;
    }

    static void Reverse(int[] arr){
        int start= 0;
        int end= arr.length-1;

        while (start<end) {
            Swap(arr, start, end);
            start++;
            end--;
        }
    }
}