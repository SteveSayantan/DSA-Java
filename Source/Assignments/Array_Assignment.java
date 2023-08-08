import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array_Assignment {
    public static void main(String[] args) {
        int[] num= {1,2,3,4};
        // int[][] arrays={{0,0,0},{0,1,0},{1,1,1}};
        // int[][] another={{1,1,1},{0,1,0},{0,0,0}};
        rotate(num,2);

        System.out.println(Arrays.toString(num));

        // System.out.println(Arrays.toString(twoSum(num, 6)));
        // System.out.println(Arrays.toString(sumZero(8)));
        

        // System.out.println(findRotation(arrays, another));
        
        // System.out.println(Arrays.toString(getConcatenation(num)));

        // System.out.println(Arrays.toString(RunningSum(num))); 
        // System.out.println(Arrays.toString(flipAndInvertImage(arrays)[0])); 
        
        // System.out.println(numIdenticalPairs(num));
      

        
    }

    static int[] Permutation(int[] arr){
    //https://leetcode.com/problems/build-array-from-permutation/

        int[] arr1= new int[arr.length]; //Creating a new array because the function will not work properly if the original array is changed 
        for (int i = 0; i < arr.length; i++) {
            arr1[i]=arr[arr[i]];
        }
        return arr1;
    }

    static int[] getConcatenation(int[] nums){
    // https://leetcode.com/problems/concatenation-of-array/
        int [] newArray= new int[2*nums.length];

        for (int i = 0; i < nums.length; i++) {
            newArray[i]=newArray[nums.length+i]=nums[i]; //Putting the numbers at specific index
        }
        return newArray;
    }

    static int[] RunningSum(int[] arr){
    // https://leetcode.com/problems/running-sum-of-1d-array/

        int sum=0;
        for (int i = 0; i < arr.length; i++) {
          arr[i]=sum+=arr[i];  //Adding a number in the sum variable and setting it in the array
        }
        return arr;
    }

    static int[] shuffle(int[] nums,int n){
    //https://leetcode.com/problems/shuffle-the-array/

        int [] newArray=new int[2*n]; //Created a new Array
        for (int i = 0; i < n; i++) {
            newArray[2*i]=nums[i]; //The ith terms would be placed at 2i th position
            newArray[2*i+1]=nums[n+i]; //The n+i th terms would be placed at 2i+1th position
        }
        return newArray;

    

    }

    static int numIdenticalPairs(int[] nums){
    // https://leetcode.com/problems/number-of-good-pairs/
        int count=0;
        for (int i = 0; i < nums.length; i++) { //This for loop traverses through each element
            for (int j = i+1; j < nums.length; j++) { //This for loop compares and updates the count if match is found
                if(nums[i]==nums[j]) count++;
            }
        }
        return count;
    } 

    static int [] smallerNumbersThanCurrent(int[] nums){
    //https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/    

    /*  Brute Force Approach

        int[] newArray= new int[nums.length];
        for (int i = 0; i < nums.length; i++) { //This travers through each element in the array
            int count=0;
            for (int j = 0; j < nums.length; j++) { //This for loop compares each element to other elements
                if(nums[i]>nums[j]) count++;
            }
            newArray[i]= count;
        }
        return newArray;
    */

    //https://www.youtube.com/watch?v=eHqwoWiMDfY
    
    int[] smaller= new int[101];
    for(int i=0;i<nums.length;i++){
        smaller[nums[i]]++;
    }
       
    for(int j=1;j<smaller.length;j++){
        smaller[j]+=smaller[j-1];
    }
        
        
    for(int k=0;k<nums.length;k++){
        if(nums[k]==0) continue;

        nums[k]=smaller[nums[k]-1];
    }
        return nums;
}

 
    static int[] createTargetArray(int[] nums,int[] index){

    // https://leetcode.com/problems/create-target-array-in-the-given-order/
        
        ArrayList <Integer> list= new ArrayList<>();
        int [] newlist= new int[nums.length];
        for(int i=0; i<nums.length;i++){
            list.add(index[i],nums[i]);
        }
        
        for(int i=0; i<nums.length;i++){
            newlist[i]=list.get(i);
        }
        return newlist;
    }

    static boolean checkIfPangram(String sentence){

    // https://leetcode.com/problems/check-if-the-sentence-is-pangram/
        
        ArrayList <Character> arr= new ArrayList<>();

        for (int i = 0; i < sentence.length(); i++) {
            if(!arr.contains(sentence.charAt(i)) ){
                arr.add(sentence.charAt(i));
            }
        }
        if(arr.size()==26) return true;
        return false;
    }

    static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        //https://leetcode.com/problems/count-items-matching-a-rule/

        int searchVal=0,count=0;
        switch(ruleKey){ //Implementing index values as per value of ruleKey
            case "type" ->  searchVal=0;   
            case "color" ->  searchVal=1;   
            case "name" ->  searchVal=2;   
        }
        for (List<String> list : items) { //Performing search w.r.t the index and the ruleValue
            
            if(list.get(searchVal).equals(ruleValue)) count++;
            
        }
        return count;
    }

    static int largestAltitude(int[] gain){

        //https://leetcode.com/problems/find-the-highest-altitude/

        int[] newArray= new int[gain.length+1];
        newArray[0]=0; //Hard coded as it is always going to be 0
        int max=0;

        for (int i = 0; i < gain.length; i++) {
            newArray[i+1]=newArray[i]+gain[i]; //Putting the values
            if(newArray[i+1]>max){ //Checking for max
                max=newArray[i+1];
            }
        }
        return max;
    }

    static int[][] flipAndInvertImage(int[][] image){

    //https://leetcode.com/problems/flipping-an-image/

       for (int[] ele : image) {
           for (int i = 0; i < ele.length; i++) {
                if(ele[i]==0){
                    ele[i]=1;
                }
                else{
                    ele[i]=0;
                }
           }
           int startInd=0,endInd=ele.length-1;
           while(startInd<endInd){
               int temp= ele[startInd];
               ele[startInd]=ele[endInd];
               ele[endInd]=temp;
               startInd++;
               endInd--;
           }
       } 
       return image;
    }

    static int oddCells(int m,int n,int[][] indices){

    //https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

        int[][] newArray= new int[m][n];
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArray[i][j]=0;
            }
        }
        for (int[] ele : indices) {
           
            for (int i = 0; i < n; i++) {
                newArray[ele[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                newArray[i][ele[1]]++;
            }

            
        }
        for (int[] ele : newArray) {
                for (int num : ele) {
                    if(num%2!=0)count++;
                }
            }
            
        return count;

        
    }

    static int diagonalSum(int[][] mat){

    // https://leetcode.com/problems/matrix-diagonal-sum/

        int sumOfPrimary=0,sumOfSecondary=0;

        for (int i = 0; i < mat.length; i++) {
            sumOfPrimary+=mat[i][i];
            sumOfSecondary+=mat[i][mat.length-i-1];
        }
        if(mat.length%2!=0){
            return sumOfPrimary+sumOfSecondary-mat[mat.length/2][mat.length/2];
        }
        return sumOfPrimary+sumOfSecondary;
            
    }

    static int findNumbers(int[] nums){

    // https://leetcode.com/problems/find-numbers-with-even-number-of-digits/   
        int count=0;
        for (int ele : nums) {
            int eleCount=0;
            while(ele>0){
                ele/=10;
                eleCount++;
            }
            if(eleCount%2==0)count++;
        }
        return count;
    }

    static int[][] transpose(int[][] matrix){
        // https://leetcode.com/problems/transpose-matrix/
        int[][] transposedMat=new int[matrix[0].length][matrix.length];

        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMat[j][i]=matrix[i][j];
            }
        }
        return transposedMat;
    }

    static List<Integer> addToArrayForm(int[] num,int k){
    //https://leetcode.com/problems/add-to-array-form-of-integer/  
        int ans=k;
        List<Integer> newList= new ArrayList<Integer>();

        int i=num.length-1;
        while(i>=0 || ans>0) { //If ans is >0 , the loop should run
            if(i>=0) ans+= num[i]; //If any real value of i exists, this line will execute
            newList.add(ans%10); 
            ans/=10;
            i--;
        }
        Collections.reverse(newList); //reverses the entire list
        return newList;
    }


    static boolean findRotation(int[][] mat,int[][] target){
        boolean ans=false;

        int [][] rotatedArr=mat;

        if(isEqual(mat, target)) return true;

        for (int i = 0; i < 3; i++) {
            rotatedArr= rotation(rotatedArr);            
           if(isEqual(rotatedArr, target)) {
               ans=true;
               break;
           } 
        }
        return ans;
    }
    static int[][] rotation(int[][]arr){ //This returns the rotated matrix
        
        int[][] newArray= new int[arr.length][arr.length];
    
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArray[j][arr[i].length-1-i]=arr[i][j]; //In the rotated matrix, the position of element [i][j] will be [j][array.length-1-i]
            }
        }
        return newArray;
    }
    static boolean isEqual(int[][]arr1,int[][] arr2){  //This checks if the rotated matrix is same as the target matrix
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if(arr1[i][j]!=arr2[i][j]) return false;
            }
        }
        return true;
    }

    
    static int[] twoSum(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target) return new int[] {i,j};
            }
        }
        return null;
    }

    static int[] sumZero(int n){
        ArrayList <Integer> newArray= new ArrayList<>();
        int ans[] = new int[n];

        for (int i = -n/2; i <=n/2; i++) {
            if(n%2==0){
                if(i==0) continue;
            }
           newArray.add(i); 
        }
        for (int i = 0; i < newArray.size(); i++) {
            ans[i]=newArray.get(i);
        }
        return ans;

       
    }

    static List<Integer> findDuplicates(int[] nums){

    // https://leetcode.com/problems/find-all-duplicates-in-an-array/

    //https://www.youtube.com/watch?v=aMsSF1Il3IY Solution

    /* 
        1. Each element-1 gives a valid index
        2. For every element we go that particular index (element-1) and make it negative.
        3. If an element occurs twice, it is obvious that it will refer to the same index which is already marked negative.
        4. In that case, we include that element in the List. 
    */

        List<Integer> newList= new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index= Math.abs(nums[i])-1;
            if(nums[index]<0)newList.add(Math.abs(nums[i]));
            nums[index]*=-1;
        }
        return newList;
        }
    

    static void setZeros(int[][] matrix){
    // https://leetcode.com/problems/set-matrix-zeroes

    /* 
        1. Take a dummy column matrix of length equal to the number of columns in the matrix.

        2. Take a dummy row matrix of length equal to the number of rows in the matrix.

        3. Traverse the given 2D array linearly, and for each 0, set the corresponding element in both the dummy matrices to 1.

        4. Again traverse the given 2D array linearly. For every index, check if any of the dummy matrices contain 1. If yes, change that particular element in the given array to zero.

        5. For further optimised sol, checkout https://www.youtube.com/watch?v=M65xBewcqcI
    
    */

        int[] colDummy= new int[matrix[0].length];
        int[] rowDummy= new int[matrix.length];
        
        
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                if(matrix[row][col]==0){
                    rowDummy[row]=1;
                    colDummy[col]=1;
                }
            }
        }
        
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                if(rowDummy[row]==1 || colDummy[col]==1){
                    matrix[row][col]=0;
                }
            }
        }

    }

    
    static int[] productExceptSelf(int[] nums){
    // https://leetcode.com/problems/product-of-array-except-self/
        /* 
            1. For an element , if we multiply the elements to the right and left of that particular element, we get the desired product.

            2. To perform this, we create two arrays, one contains the product of the elements to the left and the other ones contain the product of elements to the right.

            3. For the first element, the product of the elements at its left is 1.

            4. For the last element, the product of the elements at its right is 1.

            5. Finally, we multiply the corresponding elements in these two arrays, to get our result.

            6. For further optimised code, checkout https://www.youtube.com/watch?v=tSRFtR3pv74

        */

        int [] leftProducts=new int[nums.length];
        int [] rightProducts=new int[nums.length];
        int [] ans= new int[nums.length];

        leftProducts[0]=1; //Set the first element as 1
        rightProducts[nums.length-1]=1; //Set the last element as 1

        for (int i = 1; i < nums.length; i++) {
            leftProducts[i]= leftProducts[i-1]*nums[i-1];
        }

        for (int j = nums.length-2; j >=0; j--) {
            rightProducts[j]=nums[j+1]*rightProducts[j+1];
        }

        for (int k = 0; k < ans.length; k++) {
            ans[k]=leftProducts[k]*rightProducts[k];
        }
        return ans;

    }


    static void rotate(int[]nums,int k){
        // https://leetcode.com/problems/rotate-array/
        
       k%=nums.length;          // If k>nums.length, this will adjust k (As rotating multiples of K times will bring back the original array)
       reverse(nums,0,nums.length-1); //reverse all the numbers

       reverse(nums,0,k-1); //reverse the first K numbers
       
       reverse(nums,k,nums.length-1); //reverse last n-k numbers (the remaining portion)
    }
    static void reverse(int[] arr,int start,int end){
        while (start<end) {
            int temp= arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        
    }
    

    static int[] plusOne(int[] digits) {
        List<Integer>newList= new ArrayList<Integer>();
        
        int num=1, n=digits.length,count=0;
        while(count<n){
            
            newList.add(0,(digits[n-1-count]+num)%10);
            if(num!=0){
                num=(digits[n-1-count]+1)/10; 
            }
            count++;
        }
        
        if(num>0){
          newList.add(0,num);  
        }
        
        int[] ans= new int[newList.size()];
        
        for(int i=0;i<newList.size();i++){
            ans[i]=newList.get(i);
        }
        return ans;
    }

   static int removeDuplicates(int[] nums){
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    int fPointer= 0, sPointer= 1;
        while(sPointer<nums.length){
            
            if(nums[sPointer]>nums[fPointer]){ 
            // When we find unique element
            
                if(sPointer-fPointer>1){    // only swap when they are not adjacent
                    swap(nums,fPointer+1,sPointer);
                }
                fPointer++;         // increment the fPointer 
            }
            // increment the sPointer in each iteration
            sPointer++;            
            
        }
        return fPointer+1;
   } 
   static void swap(int [] arr, int index1, int index2){
    int temp= arr[index1];
    arr[index1]=arr[index2];
    arr[index2]=temp;
}

    static int[][] matrixReshape(int[][] mat, int r, int c){

    // https://leetcode.com/problems/reshape-the-matrix/

        if(r*c!=mat.length*mat[0].length) return mat;
        
        int [][] newMatrix= new int[r][c];
        
        int row_Num=0;
        int col_Num=0;
        
        for(int row=0;row<mat.length;row++){
            for(int col=0;col<mat[row].length;col++){
                newMatrix[row_Num][col_Num]=mat[row][col];
                col_Num++;
                if(col_Num>c-1){
                 row_Num++;
                 col_Num=0;
                } 
            }
        }
        return newMatrix;  
    } 
    
    /* Striver's A2Z Course */ 

    // Array Easy
    static int[] getSecondOrderElements(int n, int []a) {
        // https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960

        return new int []{getSecondLargest(a),getSecondSmallest(a)};

    }
    static int getSecondLargest(int [] a){
        int max= a[0];
        int sLargest=Integer.MIN_VALUE;

        for (int i=1;i<a.length;i++){

            if(a[i]>max ){
                sLargest=max; // Whenever we find new max, store the old max in sLargest
                max=a[i];
            }
            else if(sLargest<a[i]){ // The current element might be smaller than max, but it could be greater than current sLargest
                sLargest=a[i];
            }
        }
        return sLargest;
    }
    static int getSecondSmallest(int [] a){
        int min= a[0];
        int sSmallest=Integer.MAX_VALUE;

        for (int i=1;i<a.length;i++){

            if(a[i]<min){
                sSmallest=min;  // Whenever we find new min, store the old max in sSmallest
                min=a[i];
            }
            else if (sSmallest>a[i]){   // The current element might be greater than min, but it could be smaller than current sSmallest
                sSmallest=a[i];      
            }
        }
        return sSmallest;
    }
    

    public void moveZeroes(int[] nums) {
        // https://leetcode.com/problems/move-zeroes/description/
        
        if(nums.length==1){
            return;
        }
        int fPointer=-1;

        for(int i=0;i<nums.length;i++){
            // find the first index of 0
            if(nums[i]==0){
                fPointer=i;
                break;
            }
        }

        if (fPointer==-1) return;   // If not found, array does not contain any zero

        // start a pointer from the next index and search for the immediate non-zero element
        for(int j=fPointer+1;j<nums.length;j++){
            if(nums[j]!=0){
                swap(nums,fPointer,j);      // swap it
                fPointer++;                 // increase the fPointer and repeat the process
            }
        }

    }


     static List< Integer > sortedArray(int []a, int []b) {
        
        int i=0,j=0;

        List<Integer> ans= new ArrayList<>();
        
        while(i<a.length && j<b.length){

            if(a[i]<b[j]){

                if(ans.size()==0 || a[i]>ans.get(ans.size()-1)){    // If the array is empty or current element is greater than the last element inserted
                    ans.add(a[i]);      // add it
                }
                i++;

            }

            else if(a[i]>b[j]){

                if(ans.size()==0 || b[j]>ans.get(ans.size()-1)){
                    ans.add(b[j]);
                }
                j++;
            }
            else{
                 if(ans.size()==0 || a[i]>ans.get(ans.size()-1)){
                    ans.add(a[i]);
                }
                i++;
                j++;
            }
            
        }

        // if one of the arrays is still not exhausted, 

        while(i<a.length){
            if(a[i]>ans.get(ans.size()-1)){
                ans.add(a[i]);
            }
            i++;
        }
        while(j<b.length){
            if(b[j]>ans.get(ans.size()-1)){
                ans.add(b[j]);
            }
            j++;
        }
        
        return ans;
    }
    
    // Array Hard

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // sort the numbers first
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){     // This for loop will run for n times

            if(i>0 && nums[i]==nums[i-1]) continue;     // If the current element is same as the previous, skip it

            // Otherwise, start searching for valid triplets
            int j=i+1;
            int k=nums.length-1;

            while(j<k){

                int sum= nums[i]+nums[j]+nums[k];

                // Since the search space is sorted..

                if(sum>0){
                    k--;        // reduce the sum
                }
                else if(sum<0){
                    j++;        // Increase the sum
                }
                else{
                    // We found a valid triplet
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;k--;

                    // after finding a valid triplet, if we encounter duplicates, we have to skip those
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
       return ans;
    } 



}

