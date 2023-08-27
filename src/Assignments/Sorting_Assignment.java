package Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting_Assignment{

    public static void main(String[] args) {
        
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int nums1_ptr=0, nums2_ptr=0,k=0;
        int [] temp= new int[m+n];

        while(nums1_ptr<m && nums2_ptr<n){

            if(nums1[nums1_ptr] <= nums2[nums2_ptr]){
                temp[k]=nums1[nums1_ptr];
                k++;
                nums1_ptr++;
            }
            else{
                temp[k]=nums2[nums2_ptr];
                k++;
                nums2_ptr++;

            }
        }

        while(nums1_ptr<m){
            temp[k]=nums1[nums1_ptr];
            k++;
            nums1_ptr++;
        }
        while(nums2_ptr<n){
            temp[k]=nums2[nums2_ptr];
            k++;
            nums2_ptr++;
        }

        for(int i=0;i<temp.length;i++){
            nums1[i]=temp[i];
        }

    }

    static int missingNumber(int[] nums) {
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


    static int[] intersection(int[] nums1, int[] nums2) {
        int arr1Len= nums1.length;
        int arr2Len= nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> temp =new ArrayList<>();

        int ptr1=0,ptr2=0;
        while(ptr1<arr1Len && ptr2<arr2Len){        // If one array ends there's no point of continuing further

            if(nums1[ptr1]<nums2[ptr2]){
                ptr1++;
            }
            else if(nums1[ptr1]>nums2[ptr2]){
                ptr2++;
            }
            else{
                temp.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
                // If we get duplicate elements after getting one answer, we shall skip those
                while(ptr1<arr1Len && nums1[ptr1]==nums1[ptr1-1]) ptr1++;
                while(ptr2<arr2Len && nums2[ptr2]==nums2[ptr2-1]) ptr2++;
            }
        }
        
        // copying the ArrayList into an array
        int[] ans= new int[temp.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]= temp.get(i);
        }    
        return ans;
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        int arr1Len= nums1.length;
        int arr2Len= nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> temp =new ArrayList<>();

        int ptr1=0,ptr2=0;
        while(ptr1<arr1Len && ptr2<arr2Len){        // If one array ends there's no point of continuing further

            if(nums1[ptr1]<nums2[ptr2]){
                ptr1++;
            }
            else if(nums1[ptr1]>nums2[ptr2]){
                ptr2++;
            }
            else{
                temp.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
               
            }
        }
        
        // copying the ArrayList into an array
        int[] ans= new int[temp.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]= temp.get(i);
        }    
        return ans;
    }

    static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ptr1=0,ptr2=0;

        while(ptr1<g.length && ptr2<s.length){
            
            if(g[ptr1]<=s[ptr2]){
                ptr1++;
                ptr2++;
            }
            else{
                ptr2++;
            }
        }
        return ptr1;        
    }

    static int[] sortArrayByParity(int[] nums) {
        if(nums.length==1)  return nums;
 
         int ptr1=0, ptr2= nums.length-1;
 
         while(ptr1<ptr2){
 
            while( ptr1<ptr2 && nums[ptr2]%2!=0){
                ptr2--;
            }
            while(ptr1<ptr2 && nums[ptr1]%2==0){
                ptr1++;
            }

            swap(ptr1,ptr2,nums);
            ptr1++;
            ptr2--;
        }
        return nums;
     }
 
    static void swap(int ind1,int ind2, int [] arr){
         int temp= arr[ind1];
         arr[ind1]=arr[ind2];
         arr[ind2]=temp;
    }

    static int[] sortArrayByParityII(int[] nums) {
        int oddPtr=1;

        for(int i=0;i<nums.length;i+=2){    // i travels only the even indices and checks for odd integers

            if(nums[i]%2!=0){   // violation, hence

                while(nums[oddPtr]%2!=0){   // oddPtr starts checking the odd indices until it finds an even integer
                    oddPtr+=2;
                }
    
                swap(i,oddPtr,nums);    // swap those 
                oddPtr+=2;              // and increase oddPtr as now it holds an odd integer
            }
        }
        return nums; 
    }

    static int largestPerimeter(int[] nums) {

        // the sum of the two smallest sides should be greater than the third side

        Arrays.sort(nums);

        int c=nums.length-1;

        while(c>=2){ // Min value of c should be 2
            int b=c-1,a=b-1;
            if(nums[a]+nums[b]>nums[c]){
                return nums[a]+nums[b]+nums[c];
            }
            c--;
        }
        return 0;
    }

    static int[] sortedSquares(int[] nums) {
        int front=0,rear=nums.length-1;
        int [] newArray= new int[nums.length];
        int j=nums.length-1;

        while(front<=rear){

            if(Math.abs(nums[front])>Math.abs(nums[rear])){
                newArray[j]= nums[front]*nums[front];
                front++;              
            }
            else{
                newArray[j]= nums[rear]*nums[rear];
                rear--;
            }
            j--;
        }
        return newArray;
    }
}