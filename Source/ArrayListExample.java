import java.util.ArrayList;

public class ArrayListExample{
    public static void main(String[] args) {
        //We need array list when we do not know the size of the Array and we want to input as much as we want . It is included in Java Collection Framework

        //Syntax of Arraylist
        /**
         * 
         * ArrayList <Wrapper_Class> ref_variable_name = new ArrayList <>(Initial_Size)
         * 
         * Internally, the memory allocation for arraylist works the same way as arrays.
         * 
         **/
        ArrayList<Integer> list= new ArrayList<>(10); // (Integer is the wrapper class for int, 10 is the initial size of the ArrayList)

        //We can add more than 10 elements. In that case, the arraylist creates a new arraylist of greater capacity and stores the elements in the new arraylist, deleting the old one. 

        list.add(67);
        list.add(68);
        list.add(60);
        list.add(69);
        list.add(100);
        

        System.out.println(list); //Arraylist can be directly printed

        System.out.println(list.contains(60)); //true

        list.set(2, 45); //Updates the value of the second index to 45

        list.get(3); //Shows the element at 3rd index, list[index] won't work

        list.remove(4); //removes the element at 4th index

        System.out.println(list);


    }
}