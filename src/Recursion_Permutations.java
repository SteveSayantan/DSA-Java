import java.util.ArrayList;

public class Recursion_Permutations {

    public static void main(String[] args) {
        // permutations("", "abc");
        System.out.println(permutationsCount("", "abcd"));
       
    }
    
    static void permutations (String ans,String input){
        /* 
            Suppose, we have to find all the possible permutations of the string "ab" .
    
            - First, we take an empty string for storing the answer and the input string.
    
            - Now, at each step we pick the first character of the string, and add it to the answer string in every possible manner.
    
            - If at any instance, the size of the answer string is n, there are n+1 ways to add a character to the string.
    
        */
        if(input.length()==0) {
            System.out.println(ans);
            return;
        }

        char letter= input.charAt(0);
        int len= ans.length();

        for (int i = 0; i <= len; i++) {        // Since, we have len+1 possibilities to add the character
            
            String firstPart=ans.substring(0, i);   // If i=0, it will return empty string
            String secondPart=ans.substring(i, len);

            String newString= firstPart+letter+secondPart;     // Forming the next answer string

            permutations(newString, input.substring(1));

        }

    }

    static ArrayList<String> permutationsArrayList (String ans,String input){
        
        // Here, the approach is same as the previous, just the answers are to be stored in an arraylist.
    
       
        if(input.length()==0) {
            ArrayList<String> temp= new ArrayList<String>();
            temp.add(ans);
            return temp;
        }

        char letter= input.charAt(0);
        int len= ans.length();

        ArrayList<String> list= new ArrayList<String>();    // This will contain all the answers returned from all the function calls made by the following loop

        for (int i = 0; i <= len; i++) {        
            
            String firstPart=ans.substring(0, i);   
            String secondPart=ans.substring(i, len);

            String newString= firstPart+letter+secondPart;  

            list.addAll(permutationsArrayList(newString, input.substring(1)));  // Merging the returned arraylist 

        }

        return list;    // returning the local answer to the parent function call

    }
    static int permutationsCount (String ans,String input){
        
        // Here, the approach is same as the previous, just the total count of the permutations have to be returned 
    
       
        if(input.length()==0) {         
            return 1;
        }

        char letter= input.charAt(0);
        int len= ans.length();

        int count=0;    // This will contain all the answers returned from all the function calls made by the following loop

        for (int i = 0; i <= len; i++) {        
            
            String firstPart=ans.substring(0, i);   
            String secondPart=ans.substring(i, len);

            String newString= firstPart+letter+secondPart;  

            count+=permutationsCount(newString, input.substring(1));   

        }

        return count;    // returning the local answer to the parent function call

    }

}
