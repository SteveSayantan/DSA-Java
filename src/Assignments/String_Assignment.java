package Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class String_Assignment {
    public static void main(String[] args) {
        
    }

    static String restoreString(String s, int[] indices){ // https://leetcode.com/problems/shuffle-string/

        char[] chArray = s.toCharArray();
        int i = 0;
        while (i < indices.length){
            if(indices[i] != i){
                int index = indices[i];
                
                // swap characters
                char temp1 = chArray[index];
                chArray[index] = chArray[i];
                chArray[i] = temp1;
                
                // swap indexes
                int temp2 = indices[index];
                indices[index] = indices[i];
                indices[i] = temp2;
            }
            else
                i++;
        }   
        
        return new String(chArray);
    }

    static String defangIPaddr(String address) {

    // https://leetcode.com/problems/defanging-an-ip-address/
        address=address.replace(".","[.]");
        return address;
    }

    static String interpret(String command) { // https://leetcode.com/problems/goal-parser-interpretation/  

        command=command.replace("()","o");
        command=command.replace("(al)","al");
        return command;
    }

    static String sortSentence(String s) { // https://leetcode.com/problems/sorting-the-sentence/

        String[] strArray= s.split(" ");
        
            
        int i=0;
        while(i<strArray.length){

            int index=strArray[i].charAt(strArray[i].length()-1)-'0';

            if(!strArray[i].equals(strArray[index-1])){
                swap(i,index-1,strArray);
            }
            else{
                i++;
            }
        }
            
            
        StringBuilder build= new StringBuilder();
        
        for(String str: strArray){
            str= str.substring(0,str.length()-1);
            build.append(str);
            build.append(" ");
        }
        
        
        return build.toString().trim();
            
    }

    static void swap(int a,int b, String[] arr){
            
        String temp= arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
        
    
    public String reverseWords(String s) {

        Stack <String> stack= new Stack<>();

        StringBuilder str= new StringBuilder();

        // Remove the leading and trailing whitespaces and trim based on inner whitespaces ( Understand the working of split() !!! )

        String[] arr= s.trim().split(" ");     // "I$love$$$you" ==> ["I", "love", "" , "", "you"] when splitted based on "$" .

        for(String item: arr){
            if(item.length()>0)stack.push(item);    // Don't push the empty strings
        }

        while(!stack.isEmpty()){
            str.append(stack.pop());
            if(!stack.isEmpty()) str.append(" ");   // Append a space only if there is something remaining in the stack
        }

        return str.toString();
    }
}
