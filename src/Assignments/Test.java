package Assignments;

import java.util.ArrayList;
import java.util.Arrays;


public class Test {
    public static void main(String[] args) {
        // PTriplet(1, 2, 3);
        
        // Factorial(2);

        // LeapYear(2020);

        // Table(19);
        int[] arr = {2,4,1,5};
        ArrayList<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        ArrayList<Integer> list2= new ArrayList<>();
        
        list2.add(4);
        list2.add(5);
        list2.add(8);
        list2.add(9);
        list2.add(10);

        // System.out.println(findArrayIntersection(list1, 7, list2, 5));
            
        // System.out.println(Arrays.toString(shuffle(arr,3)));
        

        int[][] nums1={{2,3,1},{3,2,1}}, nums2={{1,2},{2,1},{1,2}};
        // MultiplyArray(nums2, nums1);

        // System.out.println(countZeros(1000000,100));


        System.out.println(Arrays.toString(arr));


    }

    static void PTriplet(int num1,int num2,int num3){
        int max= Math.max(num1,(Math.max(num2,num3)));

        int min= Math.min(num1,(Math.min(num2,num3)));

        int last= num1+num2+num3-max-min;

        if(max*max-min*min==last*last){
            System.out.println("Given triplet is Pythagorean");
            return;
        }
        System.out.println("Given triplet is not Pythagorean");
    }

    static void Factorial(int num){
        int ans=1;
        while(num>1){
            ans*=num;
            num--;
        }
        System.out.println(ans);
    }

    static void LeapYear(int year){
        if(year%4!=0)  {
            System.out.println("Not a Leap Year");
            return;
        }
        if(year%100 ==0 && year%400!=0){
            System.out.println("Not a Leap Year");
            return;
        }
        System.out.println("Leap Year");
    }

    static void Table(int n){
        int i=1;
        while(i<=10){
           System.out.printf("%d X %d = %d%n",n,i,n*i);
           i++;
        }
    }
    
    static void ReverseTable(int n){
        int i=10;
        while(i>=1){
           System.out.printf("%d X %d = %d%n",n,i,n*i);
           i--;
        }
    }

    static int[] swapAlternate(int[] arr){
        int fPointer=0, sPointer=1;
        while(fPointer<arr.length&&sPointer<arr.length){
            int temp= arr[fPointer];

            arr[fPointer]=arr[sPointer];
            arr[sPointer]=temp;

            fPointer+=2;
            sPointer+=2;
        }
        return arr;
    }

    static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m){
		// Write Your Code Here.
          int i=0,j=0;
        ArrayList<Integer> newArray= new ArrayList<>() ;
        
        while(i<n&&j<m){
            if(arr2.get(j)==arr1.get(i)){
               newArray.add(arr1.get(i));
                i++;
                j++;
                
            }
            else if(arr2.get(j)>arr1.get(i)){
               i++;
    }
            else{
                j++;
}
        }
        return newArray;
	} 

    static void MultiplyArray(int[][] arr1, int [][] arr2 ){

        if(arr1[0].length!=arr2.length){
            System.out.println("Invalid Array");
            return;
        }
        for (int row = 0; row < arr1.length; row++) {

            for (int colArr2 = 0; colArr2 < arr2[0].length; colArr2++) {
                
                int sum=0;

                for (int numArr2 = 0; numArr2 < arr2.length; numArr2++) {

                   sum+= arr1[row][numArr2]*arr2[numArr2][colArr2]; 
                }
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }

    static void getAllPermutations(String ans,String original){
        if(original.length()==0){
            System.out.println(ans);
            return;
        }
        
        for(int i=0;i<ans.length()+1;i++){
            
            char item= original.charAt(0);
            
            String firstSegment=ans.substring(0,i);
            String lastSegment=ans.substring(i,ans.length());
            
            getAllPermutations(firstSegment+item+lastSegment,original.substring(1));
            
            
        }
    }

    static int countZeros(int L,int K){ //https://prepinsta.com/tcs-codevita/python-code-for-zero-count-tcs-codevita-prepinsta/

        if(L==K || K==0) return L-K;

        int start=1, end= L-K;      // At lest we can have 1 zero and at max we can have L-K zeros consecutively

        while(start < end){

            int mid=start+(end-start)/2;

            int strLen=0;           // it counts the length of the string being constructed
            int oneCounter=0;       // counts the number of ones req. to make the string
            int consecutiveZeroCounter=mid;     // it places consecutive zeros in the string

            while(strLen<L){

            /* 
                Until the length of the string reaches L:

                    1. If consecutiveZeroCounter can place Zeros:

                        i. Add a zero to the string (i.e. decrement consecutiveZeroCounter).

                        otherwise,

                        i. Add a one to the string (i.e. increment oneCounter).
                        ii. Make consecutiveZeroCounter equals to mid (so that, it can again place zeros)

                    2. Increment the length
            */
                if(consecutiveZeroCounter>0){
                    consecutiveZeroCounter--;
                }
                else{
                    oneCounter++;
                    consecutiveZeroCounter=mid;
                }
                strLen++;
            }

            if(oneCounter>K){       // If we need more 1s than allowed, we need to increase the number of consecutive 0s.
                start=mid+1;
            }
            else{                   // Otherwise, check if we can minimize the number of 0s.
                end=mid;
            }
        }

        return start;
    }

    
    static long minTime(String s){  // https://leetcode.com/discuss/interview-question/1263982/thomson-reuters-oa-circular-printer

        long counter=0L;

        int curPos=1;

        for (int i = 0; i < s.length(); i++) {
            
            int destPos = s.charAt(i)-'A'+1;

            // this is to calculate the clockwise distance
            int cwDist= destPos>=curPos? 
            destPos-curPos : 
            26+destPos-curPos;  
            
            // this is to calculate the anti-clockwise distance
            int acwDist= 26- cwDist;
            
           
            // System.out.println(cwDist + " " + acwDist);
            
            counter+=Math.min(cwDist,acwDist);
            
            curPos=destPos;
            
        }
        return counter;
    }

}




