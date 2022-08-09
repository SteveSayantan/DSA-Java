public class Array_FindMaxWealth{

    //Q: https://leetcode.com/problems/richest-customer-wealth/
    public static void main(String[] args) {

        int[][] input= {{1,2,3},{9,1,6},{3,3,7}}; 
       System.out.println(MaxWealth(input)); 
    }

    static int MaxWealth(int[][] arr){
        int maxW=0;
       for (int row = 0; row < arr.length; row++) {
           int sum=0;
           for (int col = 0; col < arr[row].length; col++) {
               sum+=arr[row][col];
           }
           if(sum>maxW){
               maxW=sum;
           }
       }
       return maxW;
    } 
}