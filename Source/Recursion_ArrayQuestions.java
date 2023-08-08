public class Recursion_ArrayQuestions {
    public static void main(String[] args) {
        int[] unsortedArr={2,3,5,4,6};
        // System.out.println(isSorted(unsortedArr, 0));
        // System.out.println(isPresent(unsortedArr, 2,0)); 
        int [] rotatedSortedArr={5,4,1,2,3};
        System.out.println(rotatedBinarySearchRecursive(0, rotatedSortedArr.length-1, 2, rotatedSortedArr));

    }

    static boolean isSorted(int [] arr,int ind){
        if(ind>=arr.length-1) return true;

        if(arr[ind]>arr[ind+1]) return false;

        return isSorted(arr, ind+1);

    }
    static boolean isPresent(int [] arr,int target,int ind){
        if(ind>=arr.length) return false;

        if(arr[ind]==target) return true;

        return isPresent(arr, target,ind+1);

    }

    static int rotatedBinarySearchRecursive(int start,int end,int target,int[] arr){

        // Same logic of rotatedBinarySearch is applied 

        if(start>end) return -1;

        int mid=start+(end-start)/2;

        if (arr[mid]==target) return mid;

        if(arr[mid]>=arr[start]){

            if(arr[start]<=target && arr[mid]>target){
                return rotatedBinarySearchRecursive(start, mid-1, target, arr);
            }
            else{
                return rotatedBinarySearchRecursive(mid+1, end, target, arr);
            }
        }
        else{
            if(arr[end]>=target && arr[mid]<target){
                return rotatedBinarySearchRecursive(mid+1, end, target, arr);
            }
            else{
                return rotatedBinarySearchRecursive(start, mid-1, target, arr);
            }
        }
    }
}
