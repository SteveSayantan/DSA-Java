public class Array_BinarySearch {
    public static void main(String[] args) {
        /** 
         *  Rules of Binary Search:
         * 
         *  1. Find the middle element ( (start index+end index)/2 )
         *  2. If target ele > mid ele --> search right part
         *  3. If target ele < mid ele --> search left part
         *  4. If target ele = mid ele --> ans 
         *  5. Repeat the steps from 1 to 5 till the ans is not found
         *  6. If start index > end index --> element not found
         * 
         */

         // In the best case scenario (When the target item is the middle element of the original array), it will make only one comparison. Hence the time complexity is constant and does not depend on the length of the array.

         //In the worst case scenario the number of comparisons made is log N (N is the length of the array)

        int [] arr={2,3,4,5,7,8,9,21,23,34,45,67};
        System.out.println(AscendingBinarySearch(arr, 45));



    }


    static int AscendingBinarySearch(int[] arr, int target){ //Returns the index of the target element
        
        //Suppose the array is sorted in ascending order

        int start=0,end=arr.length-1;

        while(start<=end){ //There might be some cases, where the start index and the end index become the same i.e.,during the last possible comparison. That is why <= is used instead of <
            

            // int mid= (start+end)/2;    //This formula might cause memory overflow 

            int mid= start+(end-start)/2;   //Gives the same result but does not cause memory overflow.

            if(target>arr[mid]){
                start= mid+1;  //end index will remain the same
            }
            else if(target<arr[mid]){
                end=mid-1; //start index will remain the same
            }
            else{
                return mid;
            }
        }

        return -1; //If none of the above conditions met during the entire loop, it returns -1.
    }

    static int DescendingBinarySearch(int[] arr,int target){

        //Suppose the array is sorted in descending order

        int start=0,end=arr.length-1;

        while(start<=end){ 
            

            int mid= start+(end-start)/2;   

            if(target>arr[mid]){
                end=mid-1;  //start index will remain the same
            }
            else if(target<arr[mid]){
                start= mid+1; //end index will remain the same
            }
            else{
                return mid;
            }
        }
        
        return -1;
    }
}
