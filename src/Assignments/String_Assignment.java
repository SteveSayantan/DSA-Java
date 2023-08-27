package Assignments;

import java.util.ArrayList;
import java.util.List;

public class String_Assignment {
    public static void main(String[] args) {
        
    }

    static String restoreString(String s, int[] indices){

    // https://leetcode.com/problems/shuffle-string/
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
    
    static String interpret(String command) {

    // https://leetcode.com/problems/goal-parser-interpretation/  
        command=command.replace("()","o");
         command=command.replace("(al)","al");
         return command;
     }

    static String sortSentence(String s) {
    // https://leetcode.com/problems/sorting-the-sentence/
        String[] strArray= s.split(" ");
        
         
         int i=0;
         while(i<strArray.length){
              int index=(int)(strArray[i].charAt(strArray[i].length()-1)-'0');
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
     

}
