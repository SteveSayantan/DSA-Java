import java.util.ArrayList;
import java.util.List;

public class CycleSort_Questions {
    public static void main(String[] args) {
       int[] arr={3,0,1};
       System.out.println(missingNumber(arr));
       
    }

    // https://leetcode.com/problems/missing-number/
    static int missingNumber(int[] nums){
       int i=0;
       while(i<nums.length){

        // 1.As the given numbers are in the range of 0 to N, index=nums[index] i.e., the index and the value at that index should be equal 

        // 2.If a value is equal to or greater than the length of the array, ignore that. As it can not be put at the correct index.

            int correct=nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct] ){  
               swap(nums, i, correct);
            }
            else{
               i++;
            }

       } 

       for (int j = 0; j < nums.length; j++) { //Return the index which stores a dissimilar value
           if(nums[j]!=j) return j;
       } 
       return nums.length; //If nothing is returned, i.e., all the elements are at particular index, return the the length of the array as that number is missing.
    }
    static void swap(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }


    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    static List<Integer> findDisappearedNumbers(int[] nums){
        int i=0;
        while(i<nums.length){
 
         // 1.As the given numbers are in the range of 1 to N, index=nums[index]-1 
 
            int correct=nums[i]-1;

            if(nums[i]!=nums[correct] ){ //This check can handle duplicates too.  
                swap2(nums, i, correct);
            }
            else{
                i++;
            }

        }
        List<Integer> newList= new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(j!=nums[j]-1){
                newList.add(j+1);
            }
        }
        return newList;
    }   
    static void swap2(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }


    
    // https://leetcode.com/problems/find-the-duplicate-number
    static int findDuplicate(int[] nums){

    //The solution is quite similar to the other ones, to avoid the for loop to detect the duplicate, some changes has been made.
        int i=0;
        while(i<nums.length){
 
           
            if(nums[i]!=i+1){
                int correct=nums[i]-1;
                
                if(nums[i]!=nums[correct] ){ 
                swap3(nums, i, correct);
                }
                else{
                   return nums[i];
                } 
                    
            }
            else{
                i++;
            }
           
    }
        
      return -1;  
    }
    static void swap3(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }


    // https://leetcode.com/problems/find-all-duplicates-in-an-array/
    static List<Integer> findDuplicates(int[] nums){
        int i=0;
        while(i<nums.length){ 
 
            int correct=nums[i]-1;

            if(nums[i]!=nums[correct] ){
                swap4(nums, i, correct);
            }
            else{
                i++;
            }
           
    }

         List<Integer> newArray= new ArrayList<>();
         
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                newArray.add(nums[j]);
            }
        }
         
    return newArray; 
    }
    static void swap4(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }



    // https://leetcode.com/problems/set-mismatch/
    static int[] findErrorNums(int[] nums){
        int i=0;
        while(i<nums.length){    
 
            int correct=nums[i]-1;

            if(nums[i]!=nums[correct] ){
                swap5(nums, i, correct);
            }
            else{
                i++;
            }
        }
        /* 
            In this problem, we have to find the duplicate element, as well as the correct element. 
            Even though we can find the duplicate element using the 'findDuplicate' strategy, we can not find the correct number with that approach. 
            Hence we must use this for loop approach. 
        */
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return new int[]{nums[j],j+1};
            }
        }
        return new int[]{-1,-1};


    }
    static void swap5(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }


    static int firstMissingPositive(int[] nums){
        int i=0;
        while(i<nums.length){

        // 1. The question asks to use O(N) time, that is a hint for cycle sort 

        // 2. Only sort the elements that are less than N,ignore negatives

        // 3. Using the for loop, start checking which index contains wrong value (As we have sorted the array, the positive numbers less than N will be at their proper index ). index+1 will be the answer. Otherwise return N+1

        // 4. Check out the video for any doubt.

            int correct=nums[i]-1;
            if(nums[i]>0 && nums[i]<nums.length && nums[i]!=nums[correct] ){  
               swap6(nums, i, correct);
            }
            else{
               i++;
            }

        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }
    static void swap6(int[]arr,int first,int second){
        int temp= arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

}
