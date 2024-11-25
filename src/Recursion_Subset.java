import java.util.ArrayList;
import java.util.Arrays;

public class Recursion_Subset {
    
    /* 
        Subset approach is specifically useful to solve Permutation and Combinations problem.
    */
    public static void main(String[] args) {
        // stringSubset("", "abc");

        // System.out.println(stringSubsetArrayList("", "abcd"));

        // stringSubsetAscii("", "ab");
        
        ArrayList<ArrayList<Integer>> ans= subsequenceIterative(new int[]{1,1});
        for (ArrayList<Integer> ele: ans ){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    static void stringSubset(String ans,String original){   // Printing all the subset of the characters in a given string
        // Taking one element and removing some other elements can be solved by Subset pattern.

        /* At every step,
        -------------------
            1. we take out the first character of the string.

            Now, there are be two outcomes,

            2. We add it to our answer string .

            3. We do not add it to our answer string .

            Repeat the process till the original string becomes empty.
         */
        if(original.length()==0){
            System.out.println(ans);
            return;
        }

        char ch= original.charAt(0);        // Taking the first character
        stringSubset(ans+ch, original.substring(1));    // calling the next function with the character appended to 'ans'
        stringSubset(ans, original.substring(1));       // calling the next function without the character appended to 'ans'
    }


    static ArrayList<String> stringSubsetArrayList(String ans,String original){   // Storing all the substrings of a given string in an arraylist
        /* 
            1. Here, the idea is quite same as the previous.

            2. Additionally, we are storing the answers of the left and right subtree in two different arraylists.

            3. After that we combine them and return it to the parent function call.
        */
        if(original.length()==0){
            ArrayList<String> temp= new ArrayList<>(1);
            temp.add(ans);
            return temp;
        }

        char ch= original.charAt(0);
        ArrayList<String> left= stringSubsetArrayList(ans+ch, original.substring(1));
        ArrayList<String> right= stringSubsetArrayList(ans, original.substring(1));
        
        left.addAll(right);

        return left;
    }


    static void stringSubsetAscii(String ans,String original){ 
        
        /* At every step,
        -------------------
            1. we take out the first character of the string.

            Now, there are three possible outcomes,

            2. We add it to our answer string .

            3. We add its ascii value to our answer string. ( However, a character and its ascii value can't be present in answer simultaneously )

            4. We add nothing to our answer string .

            Repeat the process till the original string becomes empty.
        */
        if(original.length()==0){
            System.out.println(ans);
            return;
        }

        char ch= original.charAt(0);        // Taking the first character
        stringSubsetAscii(ans+ch, original.substring(1));    // calling the next function with the character appended to 'ans'

        stringSubsetAscii(ans+(ch+0), original.substring(1));    // calling the next function with the character appended to 'ans'

        stringSubsetAscii(ans, original.substring(1));       // calling the next function without the character appended to 'ans'
    }

    
    static ArrayList<ArrayList<Integer>> subsequenceIterative(int [] arr){
        /* 
            Suppose, we are given an empty array -> [ ] . What are the possible subsets of it?
            Ans. [ ]

            Now, What are the possible subsets of [ 1 ] ?
            Ans. 
                1. We make a copy our previous answer i.e. [ ]

                2. Now, we have two empty arrays like [ ] [ ] ( Taking the previous answer in consideration also )

                3. We add 1 to any of the copies, and our answer looks like [ ] [ 1 ]


            Next, What are the possible subsets of [ 1,2 ] ?
            Ans. 
                1. We make a copy our previous answer i.e. [ ] [ 1 ]

                2. Now, we have two sets each containing two empty arrays like [ ][ 1 ]  [ ][ 1 ] ( Taking the previous answer in consideration also )

                3. We add 2 to any of the sets, and our answer looks like [2][ 1,2 ]  [ ][ 1 ]
            
            With this approach, we shall solve this problem

            T.C. O(N*2^N)   here, N is the number of elements in our array

            S.C. O(N*2^N)   here, N is the number of elements in each of 2^N subsets .
        */

        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();        // This will contain the all the subsets

        outer.add(new ArrayList<Integer>());    // Initially, adding an empty arraylist

        for(int num: arr){      // from the above explanation, it is clear that we need to run the steps for each element in the array
            
            int n=outer.size(); // For making copies of each subset, we need to traverse the entire outer arraylist, hence we need the size

            for (int i = 0; i < n; i++) {    
                
                ArrayList<Integer> internal= new ArrayList<>(outer.get(i));     // create a copy of subset at index i
                internal.add(num);      // add the current element to that copy
                outer.add(internal);    // add the copy to the outer arraylist
            }

        }
        return outer;

    }

    
    static ArrayList<ArrayList<Integer>> subsetDuplicate(int[] arr) {
        /* 
            Suppose, we want to get all the subsets of the array [1,1].

               - Ideally, the answer should be [ [ ], [ 1 ] , [ 1,1 ] ], but with the previous approach the answer will be [ [ ], [1], [1], [1, 1] ] i.e. we get duplicate subsets.

               - This is due to the fact that , 

                        in the second iteration when we copy the set [ [ ] , [ 1 ] ] and make [ [ ] , [ 1 ] , [ ], [ 1 ] ]
                        
                        now when we try to add next 1 to the copied set, we basically again add 1 to [ ] ( in the first iteration we did that already )

                        that causes the duplicate subset.
                
                - To avoid this, in this approach we shall use two pointers, start and end.
         */
        Arrays.sort(arr);   // First, the array has to be sorted, otherwise the duplicates can't be detected easily

        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {  // Instead of the for-each loop, we are using traditional for loop

            start = 0;              // If there is no duplicate, the start should be 0, hence it is important to reset its value 

            
            if (i > 0 && arr[i] == arr[i-1]) {  // if current and previous element is same, s = e + 1 . 
                start = end + 1;           // Now, start holds the first index from where the new part began, in the previous iteration.
            }

            end = outer.size() - 1;     // end holds the last index of the outer arraylist
            
            for (int j = start; j <= end; j++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

    
}
