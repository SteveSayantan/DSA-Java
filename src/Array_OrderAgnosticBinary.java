public class Array_OrderAgnosticBinary {
    public static void main(String[] args) {
       int[] arrAsc={2,3,4,5,7,8,9,21,23,34,45,67};
       int[] arrDsc={67,45,34,23,10,2,-2,-6};

       int ans= orderAgnosticBS(arrDsc, 8);

       System.out.println(ans);

    }

    static int orderAgnosticBS(int[] arr, int target){
        //First we are going to find if the provided array is sorted in ascending or descending order. Then we will apply the search based on that result.

        int start= 0;
        int end= arr.length-1;

        boolean isAsc=false;
        if(arr[start]<arr[end]) isAsc=true; //Checking the type of sorting (ascending or descending)

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
}
