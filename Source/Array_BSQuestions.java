public class Array_BSQuestions {
    public static void main(String[] args) {
        int[] array= {1,3,4,5,6,12,23,34,45,67,78,80};
        char[] cArr={'a','b','d','e','f','g'};
        // System.out.println(FloorOfNumber(array,47));
        // System.out.println(nextGreatestLetter(cArr,'f'));
        // System.out.println(ans(array,4));

        


    }

    static int CeilingOfNumber(int[] arr,int target){
        //Ceiling= smallest element in array greater or equal to target

        //The code will be entirely like BS. Just, instead of returning -1 if target not found, we need to return the start.

        int start=0,end=arr.length-1;

        if(target>arr[arr.length-1]) return Integer.MAX_VALUE;  //If the target is greater than the greatest number present in the array, return Max value of Integer.

        while(start<=end){ 
            

            // int mid= (start+end)/2;    
            int mid= start+(end-start)/2; 

            if(target>arr[mid]){
                start= mid+1;  
            }
            else if(target<arr[mid]){
                end=mid-1; 
            }
            else{
                return arr[mid];
            }
    }
        return arr[start]; //In this case,when while loop is over and the target is still not found, start becomes greater than end which causes the while loop to break. As this is a sorted array, the start will be the smallest number greater than the target i.e. our ans. Watch the video in case of any doubt. 
}


    static int FloorOfNumber(int[] arr,int target){
        //Floor= greatest element smaller or equal to target

        //The code will be entirely like BS. Just, instead of returning -1 if target not found, we need to return the end.
        int start=0,end=arr.length-1;

        if(target<arr[0]) return Integer.MIN_VALUE;//If the target is smaller than the smallest number present in the array, return Min value of Integer.

        while(start<=end){ 
            

            // int mid= (start+end)/2;    
            int mid= start+(end-start)/2; 

            if(target>arr[mid]){
                start= mid+1;  
            }
            else if(target<arr[mid]){
                end=mid-1; 
            }
            else{
                return arr[mid];
            }
    }
        return arr[end]; //In this case,when while loop is over and the target is still not found, start becomes greater than end which causes the while loop to break. As this is a sorted array, the end will be the greatest number smaller than the target i.e. our ans. Watch the video in case of any doubt. 
    }

    
    static char nextGreatestLetter(char[] letters,char target){
        //https://leetcode.com/problems/find-smallest-letter-greater-than-target/
        
        
        int start=0,end=letters.length-1;   

        while(start<=end){ 
            
    
            int mid= start+(end-start)/2; 

            if(target<letters[mid]){
                end=mid-1;  
            }
            else{ //If target is greater or equal to the mid, increment the start
               start=mid+1;
            }
        
    }
        return letters[start%letters.length];
    }


    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ 
    static int[] searchRange(int[] nums,int target){

       int[] ans={-1,-1};
       ans[0]= search(nums, target, true); //Finds the start value
       ans[1]= search(nums, target, false); //Finds the end value

       return ans;

    }
    static int search(int[] nums,int target,boolean findStartIndex){ //This returns the index value of target
        int start=0,end=nums.length-1,ans=-1;

        while(start<=end){ 
            
            int mid= start+(end-start)/2;   

            if(target>nums[mid]){
                start= mid+1;  
            }
            else if(target<nums[mid]){
                end=mid-1; 
            }
            else{
                ans=mid; //If a possible answer is found, store it.
                if(findStartIndex){ //For searching the startIndex do this because the same might lie behind this element
                    end=mid-1;
                }
                else{
                    start=mid+1; //For searching the endIndex do this the same might lie after this element
                }
            }
        }
        return ans;

}



    // https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    static int ans(int[] arr,int target){
        //First search the range
        int start=0;
        int end=1;

        //condition for the target to lie in the range
        while(target>arr[end]){
            int temp= end+1; //This is my new start

            end= end+(end-start+1)*2;   // Increasing the number of elements in search space twice in each iteration
            start=temp;
        }
        return BinarySearch(arr, target, start, end);
    }
    static int BinarySearch(int arr[],int target,int start,int end){
        while(start <= end) {
            // find the middle element
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }


    static int peakIndexInMountainArray(int[] arr){

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    // https://leetcode.com/problems/find-peak-element/ 


        //Example of Mountain Array {1,2,3,4,3,1}  First increasing then decreasing. 4 is the peak

        int start = 0;
        int end = arr.length - 1;

        while (start < end) { //When start becomes equal to the end, we can not proceed further. So at this point the loop should break.
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in the desc part of the array but the previous element might not be greater than the mid element
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array, search the right part (if mid+1==mid, it will work also )
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end (This breaks the loop) and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        
        return start; // or return end as both are equal 
    }


    // https://leetcode.com/problems/find-in-mountain-array/
      
    static int findInMountainArray(int target, int[] arr){
        int peak= findPeakIndexInMountainArray(arr);
        int firstTry= orderAgnosticBS(arr, target, 0, peak);

        if(firstTry!=-1) return firstTry;
        
        return orderAgnosticBS(arr, target, peak, arr.length-1);
      }
    static int findPeakIndexInMountainArray(int[] arr){
                 
            int start = 0;
            int end = arr.length - 1;
    
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > arr[mid+1]) {
                    end = mid;
                } else {
                    // you are in asc part of array
                    start = mid + 1; // because we know that mid+1 element > mid element
                }
            }           
            return start; // or return end as both are = 
        }
    static int orderAgnosticBS(int[] arr, int target,int start,int end){   
            
            boolean isAsc=false;
            if(arr[start]<arr[end]) isAsc=true; 
    
            while(start<=end){
    
                int mid= start+(end-start)/2; 
                
                if(arr[mid]==target){
                    return mid;
                }
                if(isAsc){
    
                    if(target>arr[mid]){
                        start= mid+1;  
                    }
                    else {
                        end=mid-1; 
                    }
                }
                else{
                    if(target>arr[mid]){
                        end=mid-1;  
                    }
                    else {
                        start= mid+1; 
                    }
                }
               
            }
            return -1;
        }



   // https://leetcode.com/problems/search-in-rotated-sorted-array/ 
       
   static int search(int[] nums, int target) {
       int pivot = findPivot(nums);    
       // if you did not find a pivot, it means the array is not rotated
    if (pivot == -1) {
        // just do normal binary search
        return BiSearch(nums, target, 0 , nums.length - 1);
    }

    // if pivot is found, you have found 2 asc sorted arrays
    if (nums[pivot] == target) {
        return pivot;
    }

    if (target >= nums[0]) {
        return BiSearch(nums, target, 0, pivot - 1);
    }

    return BiSearch(nums, target, pivot + 1, nums.length - 1);
}    
   static int BiSearch(int arr[],int target,int start,int end){
    while(start <= end) {
        // find the middle element
        int mid = start + (end - start) / 2;

        if (target < arr[mid]) {
            end = mid - 1;
        } else if (target > arr[mid]) {
            start = mid + 1;
        } else {
            // ans found
            return mid;
        }
    }
    return -1;
}
   static int findPivot(int[] arr){
    int start = 0;
    int end = arr.length - 1;

    while (start < end) {

        int mid = start + (end - start) / 2;
        // 4 cases over here
        if (mid < end && arr[mid] > arr[mid + 1]) {     // As the while loop runs for start<end, mid will be always less than end, therefore the first check is unnecessary
            return mid;
        }
        if (mid > start && arr[mid] < arr[mid - 1]) {   // It might be possible that the mid is the first element in the array, therefore the first check is necessary
            return mid-1;
        }
        if (arr[mid] <= arr[start]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return -1;
   }

   
   // https://leetcode.com/problems/search-in-rotated-sorted-array/ (Striver's Version)    

   static int searchInRotatedSorted_unique(int start,int end,int target,int[] arr){
        /* 
            Here, instead of finding the pivot, we shall find in which sorted part the mid exists (i.e. left part or right part )
            And perform our BS according to that.
            Reference: https://youtu.be/5qGrJbHhqFs
         */
        while(start<=end){

            int mid= start+(end-start)/2;
    
            if(target==arr[mid]) return mid;
    
            if(arr[mid]>=arr[start]){

                // The mid is in the left sorted part
                if(target>=arr[start]&& target<arr[mid]){ // This is the condition for the target to be present within this range
                    end=mid-1;
                }
                else{
                    start=mid+1;           // Search the other part
                }
            }
            else{
                // The mid is in the right sorted part
                if(target>arr[mid]&& target<=arr[end]){     //This is the condition for the target to be present within this range
                    start=mid+1;
                }
                else{
                    end=mid-1;             // Search the other part
                }
            }
        }

    return -1;
   }

   //https://leetcode.com/problems/search-in-rotated-sorted-array-ii
   static boolean searchInRotatedSorted_duplicate(int[] arr,int target){
        /* 
            Here, the idea is same as the previous one. Only if duplicates occur at start,mid and end we shall discard that case.
            Reference: https://youtu.be/w2G2W8l__pc
         */
        int start=0,end= arr.length;
        while(start<=end){

            int mid= start+(end-start)/2;
    
            if(target==arr[mid]) return true;

            else if(arr[start]==arr[mid]&& arr[mid]==arr[end]){     // If duplicates occur, discard those
                start++;
                end--;
            }
    
            else if(arr[mid]>=arr[start]){

                // The mid is in the left sorted part
                if(target>=arr[start]&& target<arr[mid]){ // This is the condition for the target to be present within this range
                    end=mid-1;
                }
                else{
                    start=mid+1;           // Search the other part
                }
            }
            else{
                // The mid is in the right sorted part
                if(target>arr[mid]&& target<=arr[end]){     //This is the condition for the target to be present within this range
                    start=mid+1;
                }
                else{
                    end=mid-1;             // Search the other part
                }
            }
        }

    return false;
   }

   
   // https://leetcode.com/problems/split-array-largest-sum/
   static int splitArray(int[] nums, int m) {

    int start = 0;
    int end = 0;

    //When the value of m is min, the max sum is going to be the sum of all the elements in the array.
    //When the value of m is max, the max sum is equal to the largest element in the array.

    //So we can say, the max sum for a given value of m is going to lie between the above two numbers. In this space, we will apply BS.
    for (int i = 0; i < nums.length; i++) {
        start = Math.max(start, nums[i]);       //  this will contain the max item of the array
        end += nums[i];                         //  this will contain the sum of items in the array
    }

    // binary search
    while (start < end) {
        // try for the middle as potential ans
        int mid = start + (end - start) / 2;

        // calculate how many pieces you can divide this in with this max sum
        int sum = 0;
        int pieces = 1;
        for(int num : nums) {
            if (sum + num > mid) {
                // you cannot add this in this subarray, make new one
                // say you add this num in new subarray, then sum = num
                sum = num;
                pieces++;
            } else {
                sum += num;
            }
        }

        if (pieces > m) { //If pieces are greater than m, that means we need to reduce the pieces, we do that by increasing the sum of individual subarray (greater the individual sum, greater no of elements in each subarray, lesser the number of subarray)
            start = mid + 1;
        } 
        else { //If pieces are less than or equal to m, that means we need to increase the pieces, we do that by decreasing the sum of individual subarray(less the individual sum, less no of elements in each subarray, greater the number of subarray)

            end = mid;    

            // Here, the end carries the mid (which is a possible answer). That's why when start falls on end i.e. start==end we get our answer (this is also the reason we need not write start<=end )  

            /* 
                Intuition behing end=mid:
                ------------------------
                Even if we split the array, less than the required value for a particular value of 'mid' , that might be a possible answer as we can always reduce the number of items in one sub-array and
                 form another sub-array (as 'mid' indicates the maximum sum to be allowed per sub-array, enabling us to allocate any number of items having sum less than 'mid') .

                Therefore, we are doing  end=mid to preserve this value of mid , when the number of split is less than (or equal) the required value.

                Test for this testcase, Array:[15,10,19,10,5,18,7], K= 5

                The correct answer will be 25, splitted like --> [15], [10], [19], [10,5], [18,7]

                Our code willl split like this --> [15,10], [19], [10,5], [18,7] . But to get 5 splits, we can reduce the number of items in the first sub-array. Reason explained above.
             */
             
        }

    }
    return end; // here start == end

}

    static int countNegatives(int[][] grid) {
       int row=grid.length-1,col= 0,count=0; //We are starting the search with the element at left bottom

       while(row>=0 && col<grid[row].length){

           if(grid[row][col]<0){ //If the current element is less than zero , it is obvious that the next elements will be less than zero
                count+=grid[row].length-col; //Update the count as the remaining elements are less than zero
                row--; //Jump to the row above
           }
           else if(grid[row][col]>=0){ //If the current element is greater than zero
               col++; //Check the next column
           }

       } 
       return count;
}


}
