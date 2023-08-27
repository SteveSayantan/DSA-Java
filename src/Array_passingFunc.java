import java.util.Arrays;

public class Array_passingFunc {
    public static void main(String[] args) {
        int[] nums= {45,56,67,78}; //nums point towards this array


        System.out.println(Arrays.toString(nums)); //[45, 56, 67, 78]
        
        changeVal(nums); //a copy of the value of the nums is sent to arr

        System.out.println(Arrays.toString(nums)); //[45, 56, 34, 78]
    }

    static void changeVal(int[] arr){ //Now arr point towards the same array
        arr[2]=34; //Any change via arr will be reflected in the original array
    }
}
