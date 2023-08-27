public class Recursion_String {
    public static void main(String[] args) {
        String temp="sayantan";
        skipCharacterA( "",temp);
        System.out.println(skipCharacterA(temp));
        System.out.println(skipStringApple("eapple"));
        System.out.println(skipAppNotApple("this app is created by apple"));
        
    }

    static void skipCharacterA(String ans,String original){      

        /* 
            1. At each step, we take out the first character of 'original'

            2. If it is 'a', we do not add it.

            3. Otherwise, it is appended to the current 'ans' 

            4. Always remember, original string is not modified. New string is created and its reference is passed.
         */
        if(original.length()==0){
            System.out.println(ans);
            return;
        }

        char ele= original.charAt(0);
        if(ele=='a'){
           skipCharacterA(ans,original.substring(1)); 
        }
        else{
            skipCharacterA(ans+ele,original.substring(1));
        }
    }

    static String skipCharacterA(String original){      

        /*  Another version of the above program

            1. At each step, we take out the first character of 'original'

            2. If it is 'a', we just call the function without appending 'a' to the return value of the function.

            3. Otherwise, it is appended to the return value of the next function call. 

            4. Always remember, original string is not modified. New string is created and its reference is passed.
         */
        if(original.length()==0){
            return "";
        }

        char ele= original.charAt(0);
        if(ele=='a'){
           return skipCharacterA(original.substring(1)); 
        }
        else{
            return ele+skipCharacterA(original.substring(1));
        }
    }

    static String skipStringApple(String original){      

        /*  
            1. At each step, we check if the current string starts with 'apple'

            2. If so, we discard 'apple', and continue with the next function call .

            3. Otherwise, we take out the first character and append it to the return value of next function call. 

        */
        if(original.length()==0){
            return "";
        }
        
        if(original.startsWith("apple")){
            return skipStringApple(original.substring(5));    // We want to skip 'apple', hence discarding it.
        }
        else{
            char ele= original.charAt(0);
            return ele+skipStringApple(original.substring(1));
        }
    }

    static String skipAppNotApple(String original) {
        /* 
            1. At each step, we check if the current string starts with 'app' and not with 'apple'

            2. If so, we discard 'app' and continue with the next function call . 
            
            3. Otherwise, we take out the first character and append it to the return value of next function call. 
        */
        if (original.isEmpty()) {
            return "";
        }
        if (original.startsWith("app") && !original.startsWith("apple")) {
            return skipAppNotApple(original.substring(3));
        } else {
            return original.charAt(0) + skipAppNotApple(original.substring(1));
        }
    }


}
