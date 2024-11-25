import java.util.HashMap;
import java.util.Map;


public class Hashmaps {
    
    /* 
        Hashmaps store data in key-value pair. It provides a way to store and search for a value in constant time.

            First, the provided data is converted into +ve integers using hashCode function. This function uses some formula to calculate the value.
            Then, we need to reduce the hashcode to a size m via hashing. The reduced hashcode works as the key and the original data is the value.

            While retrieving data, it again does the same process on the data to be searched and gets the hashed value (i.e. key). Using that hashed value
            it can retrieve the data from the table in constant time.

        If at any point, we get two similar keys for different data, it is called collision. To deal with collision, we use
         - chaining
         - open addressing

        In chaining, each key holds a linked list of the values, i.e. multiple values can be present under a key. 
            The size of the hashmap doubles or shrinks automatically based on the number of elements (like arraylist). Chaining is not sensitive to hash functions.

        In open addressing, only one value is stored per key. It gives better cache performance.
        
    */

    public static void main(String[] args) {
        
        HashMap<String,Integer> map = new HashMap<>();

        // Mapping string values to int keys
        map.put("hello", 0);
        map.put("bye", 1);

        System.out.println(map);

        //Iterating over the items in map
        for(Map.Entry<String,Integer> item:map.entrySet()){
            System.out.println("Key: "+item.getKey()+", Value: "+item.getValue());
        }
    }

 
    

    


}
