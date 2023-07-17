import java.util.ArrayList;
import java.util.Arrays;

public class BS_Assignments {
    public static void main(String[] args) {
        int[] nums={5,6,7,8,9,1,2,3,4};
        // System.out.println(isPerfectSquare(40401));
        // System.out.println(reachNumber(5));
        System.out.println(divideChocolate(nums, 8)); 

        
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
        
        if(x==0) return 0;
        if(x<=3) return 1;

        // Now that we have handled all the cases upto 3, let us start checking from 4 i.e. start can be initialized with 2  

        int start=2,end=x/2;    // The sqrt of a number <=number/2
        int ans=0;
         
        while(start<=end){
            int mid=start+(end-start)/2;
            
            long product= ((long)mid*mid);

            if(product==x){
                return mid;
            }
            
            else if(product>x){
                end=mid-1;
            }
            else{
            ans=mid;            
            start=mid+1;             
            }
            
        }
         
         return ans;
        
       }
       
    static int[] twoSumII(int[] arr, int target) {

        int start=0,end= arr.length-1;

        
        while(start<end){

            int s= arr[start]+arr[end];

            if(s==target) return new int[]{start+1,end+1};

            else if(s>target){
                end--;
            }
            else{
                start++;
            }
        }
        return new int[]{-1,-1};
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
               
        if(num==1) return true;
        if(num<=3) return false;

        int start=2, end= num/2;

        while(start<=end){

            int mid= start+(end-start)/2;

            long product= ((long)mid*mid);

            
            if(product==num) return true;

            if(product<num){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;   
    }


    static int arrangeCoins(int n) {

        int start=1,end=n,ans=0;

        while(start<=end){

            int mid=start+(end-start)/2;

            long sum= ((long)mid*(mid+1))/2;

            if(sum==n) return mid;

            if(sum>n){
                end=mid-1;
            }
            else{
                ans=mid;
                start=mid+1;
            }
        }
        return ans;
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

    static int findMin(int[] arr){
        // Reference: https://youtu.be/nhEMDKMB44g (Striver's version)

        /* 
            Intuition:
            ----------
            In a rotated sorted array, both the left and right side elements of the pivot are sorted.
            
            But even if we figure out in which sorted part (left or right) the mid is lying, we can not say that part contains the min element.

            Hence, we shall pick min element from each sorted part and eleminate it.
        */

        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;

    }

    static int findMinII(int[] arr) {
        /* 
            Here, the intuition is quite similar to the previous question. However, if we encounter some situation
            where the low, mid and high elements are equal, we can not determine the sorted half.

                Therefore, we need to trim down this condition by skipping those elements
         */
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                ans= Math.min(ans,arr[mid]);        // Compare with ans, as these might be the smallest 
                low++;
                high--;
                continue;
            }
            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }

    static int aggressiveCows(ArrayList<Integer> stalls,int k){
    // https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559

    // Approach: https://youtu.be/wSOfYesTBRk

        stalls.sort(null);
        int start=1,max=stalls.get(stalls.size()-1) ,min=stalls.get(0),end=max-min,ans=-1;
 
        while(start<=end){
            int mid= start+(end-start)/2;
 
            int cowCount=1,cowPosition=stalls.get(0);
 
            for (int num : stalls) {
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
                ans=mid;
                start=mid+1;    // we can not do start=mid, as it will cause an infinite loop
            }
            /* 
            As neither 'start' nor 'end' can store the mid, we must write start<=end i.e. the loop
            should run for start==end to check if the last number is a possible answer. 
            */
        }
        return ans;

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

    static int shipWithinDays(int[] weights, int days) {

        int max_Capacity=0;
        int min_Capacity=0;

        for(int w:weights){
            max_Capacity+=w;
            min_Capacity=Math.max(min_Capacity,w);
        }

        int start= min_Capacity, end=max_Capacity;

        while(start<end){

            int mid= start+(end-start)/2; 

            int reqDays=1, totalWeight=0;

            for(int w:weights){         

                if(totalWeight+w>mid){
                    reqDays++;
                    totalWeight=w;
                }
                else{
                    totalWeight+=w;
                }
                
            }

            if(reqDays>days){
                start=mid+1;
            }
            else{
                end=mid;
            }

        }
        return  start;
    }
    
    static int reachNumber(int target){

    /* 
        1. We need to find a number such that, the difference between distance covered by that number and our target is zero or even.

        2. E.g., to reach 4 we need 3 numOfSteps because the difference between 6 (distance covered by 3) and 4 (target) is 2 (Even).

        3. With the help of B.S. we find a number which covers a distance >= target. If the difference is between this target and distance is even or zero, this number is our ans.

        4. If the difference is odd, we have to check the number. 

            q) If the number is even, in that case,to make the difference even, we consider the next number (Add 1 to get the ans). (Draw a number line for clarification) 

            b) If the number is odd, we take two more jumps to make the difference even. (Add 2 to get the ans)
    
        Ref:https://youtu.be/frjYWZRs624
    
    */
    target=Math.abs(target);

    int start=0, end= target, moves=0;

    while(start<=end){     
        int steps= start+(end-start)/2;
        long calculatedDistance= ((long)steps*(steps+1))/2;

        if(calculatedDistance==target){
            return steps;
        }
        else if(calculatedDistance<target){
            start=steps+1;
        }
        else{
            moves=steps;
            end=steps-1;        // as we are moving away from the possible answer, we need to run the loop for start==end also, i.e. start<=end is the condition for while loop.
        }
    }
    long actualDistance=((long)moves*(moves+1))/2;      // calculate the distance outside the loop 
    if((actualDistance-target)%2==0) return moves;
    if(moves%2==0) return ++moves;
    return moves+2;
    }


    static int minCostToMoveChips(int[] positions) {
        // Read the approach https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/solutions/398342/python-simple-odd-even-approach-with-explanation/

        int odd_chips=0,even_chips=0;
        for(int position:positions){
            if(position%2==0){
                even_chips++;
            }
            else{
                odd_chips++;
            }
        }
        /*   
        if(odd_chips>even_chips){   
            // then move all the odd chips to an odd position and the cost incurred will be due to the even_chips
            return even_chips;
        }
        return odd_chips; // then move all the even_chips to an even position and the cost incurred will be due to the odd_chips
        */
        
        //or,
        return Math.min(odd_chips,even_chips);    
    }

    static int divideChocolate(int [] sweetness, int k){

        int minSweetness_Max= 0, minSweetness_Min=Integer.MAX_VALUE, ans=0;

        for (int sweet : sweetness) {
            minSweetness_Max+=sweet;
            if(sweet<minSweetness_Min){
                minSweetness_Min=sweet;
            }
          
        }
        
        int start=minSweetness_Min,end=minSweetness_Max;
        while (start<=end) {

            int mid= start+(end-start)/2;

            int split=0;            // If minimum sweetness is not reached, we can not perform any split, hence it is initialized with 0
            int totalSweetness=0;

            for(int item:sweetness){
                
                totalSweetness+=item;
                if(totalSweetness>=mid){
                    // If minimum sweetness is reached, then we can perform a split and reset the count
                    split++;
                    totalSweetness=0;
                }
            }
            
            if(split>k+1){      // we have to make k+1 pieces using k cuts
                start=mid+1;
            }
            else if(split==k+1){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }

    static int findPages(int[]A,int N,int M){
        if(M>N) return -1;
        int MaxPage_min=Integer.MIN_VALUE;
        int MaxPage_max= 0;
        
        for(int page:A){
            MaxPage_max+=page;
            if(page>MaxPage_min){
                MaxPage_min=page;
            }
        }
      
        int start= MaxPage_min, end= MaxPage_max;
        // System.out.printf("%d %d",start,end);
        int ans= -1;
        
        while(start<=end){
            
            int mid= start+(end-start)/2;
            int pagesAlloted=0,split=1;
            
            for(int page:A){
                
                if(pagesAlloted+page>mid){
                    split++;
                    pagesAlloted=page;
                }
                else{
                    pagesAlloted+=page;
                }
            }
            // System.out.printf("%d %d %d %d%n",start,mid,end,split);
            
            if(split>M){
                start=mid+1;
            }
            else{
                ans= mid;
                end=mid-1;

                /* 
                Intuition behing not including the case when `split==M`:
                ------------------------------------------------------
                Even if we allocate books to less number of students for a particular value of 'mid' , that might be a possible answer as we can always reduce the number of *books* received by one student and
                 allocate that to someone else (as 'mid' indicates the maximum number of  *pages* to be allocated per head, allowing us to allocate any number of pages less than 'mid') .

                Therefore, we are doing  end=mid to preserve this value of mid , when the number of allocation is less than (or equal) the required value.

                Check testcase, Array:[15,10,19,10,5,18,7], K= 5

                The correct answer will be 25, splitted like --> [15], [10], [19], [10,5], [18,7]

                Our code willl split like this --> [15,10], [19], [10,5], [18,7] . But to get 5 splits, we have to reduce the number of books received by the first student. Reason explained above.
             */
            }
         
        }
        return ans;
    }


    static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Reference: https://youtu.be/NTop3VTjmxk

        int m= nums1.length, n= nums2.length;

        int low=0,high=m;

        // Calculating the number of elements on each side of the partition
        
        int medianPos=((m+n)+1)/2;          // Remember this, irrespective of even or odd total length (i.e. m+n ), we know the smaller part will always contain (m+n+1)/2 elements

        if(m>n) return findMedianSortedArrays(nums2,nums1);     // Always apply BS on the small array to avoid index overflow while calculating l1,l2 and r1,r2

        while(low<=high) {

            int cut1 = (low+high)>>1;           // No of elements to be taken from the first array

            int cut2 = medianPos - cut1;        // No of elements to be taken from the second array

            
            int l1 = (cut1 == 0)? Integer.MIN_VALUE:nums1[cut1-1];  // If no elements are to be taken from first array, set l1 as INT_MIN. Otherwise, set is as the element just before cut  
            int l2 = (cut2 == 0)? Integer.MIN_VALUE:nums2[cut2-1];

            int r1 = (cut1 == m)? Integer.MAX_VALUE:nums1[cut1];    // If all the elements are taken from the first array, set l2 as INT_MAX. Otherwise, set is as the element just before cut
            int r2 = (cut2 == n)? Integer.MAX_VALUE:nums2[cut2];

            if(l1<=r2 && l2<=r1) {
                if((m+n)%2 != 0)
                    return Math.max(l1,l2);         // For odd length, we do not need to worry about r1 & r2
                else 
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2) high = cut1-1;

            else low = cut1+1;
        }
        return 0.0;

    }

    static ArrayList<Integer> countSmaller(int [] nums){
       // This is problem is based on merge sort, will see it later on.
       // similar problem https://youtu.be/AseUmwVNaoY and chekcout leetcode solution section
       ArrayList<Integer> temp = new ArrayList<>();
       return temp;
    }

    
}

