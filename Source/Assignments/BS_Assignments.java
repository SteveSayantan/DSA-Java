import java.util.ArrayList;

public class BS_Assignments {
    public static void main(String[] args) {
        int[] nums={1,3,6,7,9,11,13,14,17};
        // System.out.println(isPerfectSquare(40401));
        System.out.println(reachNumber(5));
    }

    static int guessNumber(int n) {
        int start=1,end=n,ans=0;
        /*              //uncomment before using
        while(start<=end){
           int mid= start+(end-start)/2;
            if(guess(mid)==-1){
                end=mid-1;
            }
            else if(guess(mid)==1){
                start=mid+1;
            }
            else{
               ans=mid;
                break;
            }
        }
        */
        return ans;
    }

    static int mySqrt(int x){
        if(x==0||x==1) return x;
            
        int start=0,end=x,ans=0;
         
         while(start<=end){
             int mid=start+(end-start)/2;
             
              if(mid*mid==x){
                 return mid;
             }
             
             else if(mid*mid>x){
                 end=mid-1;
             }
             else{
                 ans=mid;            
                start=mid+1;             
             }
             
         }
         
         return ans;
        
       }
       

    static int firstBadVersion(int n) {
        int start=1,end=n,ans=0;
        /*             //uncomment before using
        while(start<=end){
           int mid= start+(end-start)/2;
            if(isBadVersion(mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            
            */
            return ans; 
        }
    
    static boolean isPerfectSquare(int num) {
               
            int start=1,end=num;
             
             while(start<=end){
                 int mid=start+(end-start)/2;
                 
                  if(mid*mid==num){
                     return true;
                 }
                 
                 else if(mid*mid>num){
                     end=mid-1;
                 }
                 else{            
                    start=mid+1;             
                 }
                 
             }
             
             return false;  
}


    static int arrangeCoins(int n) {

        long start=1,end=n,ans=0;
            while(start<=end){
                long mid=start+(end-start)/2;
                
                if(mid*(mid+1)/2==n){
                    
                    return (int)(mid);
                }
                else if(mid*(mid+1)/2>n){
                    
                    end=mid-1;
                }
                else{
                    ans=mid;
                    
                    start=mid+1;
                }
            }
     return (int)(ans);
}


    static int findKthPositive(int[] arr,int k){
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            int missing= arr[mid]-(mid+1); //To calculate number of missing items at any index: actualEle-expectedEle== arr[index]-(index+1);
            if(missing<k){
               start=mid+1;
            }
            else if(missing>=k){
                end=mid-1;
            }
        }
        if(end==-1) return k;
        return arr[end]-(arr[end]-(end+1))+k; // arr[end]+k-elements_missing_till_end

        //Instead of the two lines above
        // return start+k;    //As arr[end]-elements_missing_till_end gives the start index and as start>end we don't have to think of the edge case where end becomes -1


    }
    static int searchInsert(int[] nums, int target){
        int start=0,end=nums.length-1;

        while(start<=end){ 
            

            

            int mid= start+(end-start)/2;   

            if(target>nums[mid]){
                start= mid+1;  
            }
            else if(target<nums[mid]){
                end=mid-1; 
            }
            else{
                return mid;
            }  
    }
        return start;
 }

    static int specialArray(int nums[]){
        int count=0;
        while(count<=nums.length){
            int noOfEle=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=count) noOfEle++;
            
        }
            if(count==noOfEle) return noOfEle;
            count++;
            
        }
        return -1;
 }

    static int singleNonDuplicate(int[] nums){
        if(nums.length==1) return nums[0];
        int start = 0;
        int end = nums.length-1;
        
        /* 

            1. First, we divide the array in two halves on basis of mid
            2. If the element at mid and the next element are equal, we update mid to the next element so that two same elements stay in the same half.
            3. The half containing odd number of elements will contain the unique element.
            
        */
        while(start<end){
            int mid = start+(end-start)/2;      // divide the array
            
            if(nums[mid]==nums[mid+1]) mid = mid-1;      //two same elements should be in same half
            
            if((mid-start+1)%2!=0) end = mid;            // checking the length of left half. If its is odd then update ur right pointer to mid
            
            else start = mid+1;    // else your right half will be odd then update your left pointer to mid+1
        }
        
        return nums[start];     //left pointer will have the answer at last
    }
    
    static boolean checkIfExist(int[] arr){

        //First, sort the array in ascending order

        int start=0,end=1;
        while(start<=end){

            if(start<arr.length-1&&arr[start]*2<arr[end]){
                start++;
            }
            else if(end<arr.length-1&&arr[start]*2>arr[end]){
                end++;
            }
            else if(arr[start]*2==arr[end]){
                return true;
            }
            else{

                break;
            }
        }
        return false;
        
    }

    static int aggressiveCows(ArrayList<Integer> stalls,int k){
    // https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559

        sort(stalls);
        int start=1,max=stalls.get(stalls.size()-1) ,min=stalls.get(0),end=max-min;
 
        while(start<=end){
            int mid= start+(end-start)/2;
 
            int cowCount=1,cowPosition=stalls.get(0);
 
            for (Integer num : stalls) {
                 if(num-cowPosition>=mid){
                     cowCount++;
                     cowPosition=num;
                      if(cowCount==k){
                         break;
                     }
                 }
            }
 
            if(cowCount<k){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
 
        }
        return end;

    }
    static void sort(ArrayList<Integer> arr){
        for (int i = 0; i < arr.size()-1; i++) {
            boolean isSwapped=false;
            for (int j = 1; j < arr.size()-i; j++) {
                if(arr.get(j)<arr.get(j-1)){
                    int temp= arr.get(j-1);
                    arr.set(j-1, arr.get(j));
                    arr.set(j,temp);
                    isSwapped=true;
                }
            }
            if(!isSwapped) break;
        }
    }

    static int minEatingSpeed(int[] piles, int h){
    //https://leetcode.com/problems/koko-eating-bananas
        int maxRate=0, ans=0;
        
        for (int i = 0; i < piles.length; i++) {
            maxRate=Math.max(piles[i], maxRate);
        }
        
        int start=1,end=maxRate;
        
        while(start<=end){
            int mid= start+(end-start)/2;
           
            long hourCount=0L;
            for (int num : piles) {
                if(num%mid==0){
                    hourCount+=num/mid;
                }
                else{
                    hourCount+=num/mid+1;
                }
                
                             
            }            
            if(hourCount>h){
                start=mid+1;
            }
            else{
                ans=mid;
                 
                end=mid-1;
             
            }
        }
        return ans;
    }
    static int reachNumber(int target){

    /* 
        1. We need to find a number such that, the difference between distance covered by that number and our target is zero or even.

        2. E.g., to reach 4 we need 3 steps because the difference between 6 (distance covered by 3) and 4 (target) is 2 (Even).

        3. With the help of B.S. we find a number which covers a distance >= target. If the difference is between this target and distance is even or zero, this number is our ans.

        4. If the difference is odd, we have to check the number. If the number is even, in that case,to make the difference even, we consider the next number (Add 1 to get the ans). (Draw a number line for clarification) 

        5. If the number is odd, we take two more jumps to make the difference even. (Add 2 to get the ans)
    
    
    */
        long start=1L,end=Math.abs(target),dest=Math.abs(target);
        long dist=0L;
        long steps=0;
        while(start<=end){
            long mid= start+(end-start)/2;
        
            long distance=mid*(mid+1)/2;
        
            if(distance>=dest){
                dist=distance;
                steps=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        if((dist-target)%2==0) return (int)(steps);
        if(steps%2==0) return (int)(steps+1);
        return (int)(steps+2);
    }
}

