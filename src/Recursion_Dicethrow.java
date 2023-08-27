import java.util.ArrayList;

public class Recursion_Dicethrow {
    
    public static void main(String[] args) {
        System.out.println(dice("", 4));
        
    }

    static ArrayList<String> dice(String answer,int target){
        /* 
            1. At every step, pick a number (less than or equal to the target) between  1 - 6
            
            2. We append it to our answer string or arraylist and reduce our target by that number.

            3. These steps are repeated until the target becomes zero.
        */
        if(target==0){
            ArrayList <String> temp= new ArrayList<>();
            if(answer.length()==0) return temp;     // If answer string is empty ,no need to add that in the arraylist
            temp.add(answer);
            return temp;
        }

        ArrayList<String> result= new ArrayList<>();

        for (int i = 1; i <=6 && i<=target; i++) {      // Here, 6 because we are considering a 6-faced dice, but it can be changed according to the problem

            result.addAll(dice(answer+i, target-i)) ;
        }
        return result;
    }
}
