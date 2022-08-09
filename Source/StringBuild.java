public class StringBuild {
    public static void main(String[] args) {

        StringBuilder builder= new StringBuilder(); //This is mutable type of string, so in case of any change, it modifies the original string object, instead of creating a new one each time.
        

        //If we use an empty string to store the resultant string (like usual), it would create new String objects each time. As a result, memory is wasted
        for (int i = 0; i < 26; i++) {
            char ch= (char)('a'+i);
            builder.append(ch);
        }

        System.out.println(builder);
        System.out.println(builder.reverse()); //reverses the string and modifies the original object
        System.out.println(builder.deleteCharAt(0)); // deletes the character at 0 index and modifies the original object

        System.out.println(builder); //yxwvutsrqponmlkjihgfedcba    as the orginal object has been modified
    }

    
}
