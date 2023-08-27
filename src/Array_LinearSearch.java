public class Array_LinearSearch {
    public static void main(String[] args) {
         
    //In linear search method we will search for an item in a collection from the 0th index till the item is not found.

    //Best Case: The target element is at the 0th index of the array. We find it in just one iteration. The time complexity is constant in this case and does not depend on the length of the array (Constant time complexity)

    //Worst Case: We search through the entire array but the element is not present in the array. The time-complexity is directly proportional with the length of the array (Linear time complexity)
    
    int[] array= {23,43,54,67,1,6};
    System.out.println(returnIndex(array, 108));

    String name= "Sweetu";
    System.out.println(searchStr(name, 'u'));

    System.out.println(findMin(array));


    }

    static int returnIndex(int[] arr,int target){ //Returns the index of the element
        if(arr.length==0){ 
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return i; 
            }
        }
        return -1; //If the element is not present in the array (index of an element can never be -1)
    }


    static int returnElement(int[] arr,int target){ //Returns the element if it is found
        if(arr.length==0){ 
            return -1;
        }
        for (int ele : arr) {
           if(ele==target){
               return ele;
           } 
        }
        return Integer.MAX_VALUE; //Not returning -1 because it might be an element
    }

    static boolean searchStr(String str, char target){ //It searches for a character in a given string and returns true or false
       
        if(str.length()==0){
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)==target){
                    return true;
                }
        }

        /** 
         * We may use a foreach loop instead
         * 
            for (char ch : str.toCharArray()) { //Foreach loops work on iterables such as arrays, so toCharArray method is used to make an array out of the string provided
                if(ch==target){
                    return true;
                }
            }
         * 
         */

        return false;
    }

    static int findMin(int[]arr){ //Finds the minimum value in an array
        int min= arr[0];
        for (int ele : arr) {
            if(ele<min){
                min=ele;
            }
        }
        return min;
    }

    
}
