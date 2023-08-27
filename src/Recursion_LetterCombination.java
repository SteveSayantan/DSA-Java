import java.util.ArrayList;
import java.util.List;

public class Recursion_LetterCombination {

    public static void main(String[] args) {

        List<String> temp= new ArrayList<>();
        System.out.println(letterCombinationMaker("", "625",temp));
        
    }
    static List<String> letterCombinationMaker(String ans,String digits,List <String> result){

        if(digits.length()==0){
            result.add(ans);
            return result;
        }
        String [] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};    // This is a map for the alphabets associated with a digit

        int digit= digits.charAt(0)-'0';    //Storing the digit as an int (it will be always in the range of 2-9 )


        for (int i=0;i<map[digit].length();i++) {  // Getting the alphabet string associated with that digit and iterating over it

            char letter= map[digit].charAt(i);  // pick each letter of the alphabet string

            letterCombinationMaker(ans+letter, digits.substring(1),result);  // add that to the answer string while calling the next function
        }

        return result;

        /* 
            Time Complexity:
            ---------------
            
            Suppose the input given is "23"

            Here, for "2" we have 3 choices, and for "3" we have 3 choices, i.e. 3C1*3C1 = 3^2 

            Suppose the input given is "456"

            Here, for "4" we have 3 choices, for "5" we have 3 choices and same goes for 6 also i.e. 3C1*3C1*3C1 = 3^3 

            Suppose the input given is "7896"

            Here, for "7" we have 4 choices, same goes for 9 also and for "8" and "6" we have 3 choices each and i.e. 4C1*3C1*4C1*3C1 = 4^2 * 3^2 

            From the above discussion we can conclude that the T.C. for the code is 3^M * 4^N , where M= number of input digits having 3 alphabets associated with it,
            N=number of input digits having 4 alphabets associated with it


         */
    }
}
