import java.util.Arrays;

public class VariableArgs {
    public static void main(String[] args) {
        fun(4,5,6,9,8); //This can also be called without any args which will print an empty array.

        multiple(12, 23, "Steve","Sweetu","Hello");
    }
    
    static void fun(int ...any){ //This function takes any number of args from 0 to n. In case of int, it will take integers, in case of String it will take strings as input and so on. 
        
        //Basically, it implicitly stores the args into any as an int array (rest syntax)
        
        System.out.println(Arrays.toString(any));
        
    }
    
    static void multiple(int a, int b, String ...arr){ //This way we can also use this. But the variable length arg must be given as the last argument
        System.out.println(Arrays.toString(arr));
    }
}
