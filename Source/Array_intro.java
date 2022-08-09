import java.util.Arrays;

public class Array_intro {
    public static void main(String[] args) {
        
        /**Syntax for Creating Arrays
         *  
         * datatype[] ref_variable_name= new datatype[size];       (LHS part is declaration and RHS part is memory allocation.new is used to create an Object)
         * 
         * In case of Arrays, the declaration occurs during the compile time and the initialization(memory allocation) happens at the run time 
         * 
         * Unlike C or C++, the memory allocation of heap objects is not continuous and it depends on the JVM i.e., the cells in the memory are not allocated sequentially.
        */

        int[] arr= new int[5]; //As this array has not been initialized yet, each of the index contains 0. In case of String array it would contain null.
        
        arr[2]=45; //Now the second index contains 45.

        //or
        
        int [] arr2= {12,45,34,56};
        System.out.println(arr2[2]); //34

        //For Loop

        for (int i = 0; i < arr2.length; i++) { // arr2.length gives the length of the arr2
            System.out.println(arr2[i]); //prints all the elements of the array
        }
       
        //ForEach Loop

        for(int num: arr2){ // each element of arr2 is represented by num
            System.out.println(num); //prints all the elements of the array
        }

        String[] str= {"aa","bb","cc","dd"}; //Here, the str reference variable is stored in the stack memory and in the heap memory there is a array which consists of four references each pointing towards a string stored in the heap.
       
        str[1]= "Steve"; //Updating a value (As arrays are mutable)

        System.out.println(Arrays.toString(str)); //[aa, Steve, cc, dd]
       
    }
}
