import java.util.Stack;

public class StackQueue_Questions {
    
    /* 
        Intuition for choosing Stack and Queue:
        ------------------------------------------------

        1. If we are storing some data in an order, and we want to retrieve the same in the same or opposite order

        2. Store a result temporarily and try out some other options.

        
    */


    public int largestRectangleArea(int [] heights){    // https://leetcode.com/problems/largest-rectangle-in-histogram/description/
        

        // reference: https://youtu.be/X0X6G-eWgQ8?si=QA_SevbigkwUBmsO

        /* 
            Brute-force solution:
            ---------------------

            For each element,

                1. find index of the right-most element smaller than it.

                2. find index of the left-most element smaller than it.

                3. calculate the width of the rectangle formed using ( right_index - left_index + 1 )

                4. multiply the width with the element to find the area.

            Now, compare these areas and find the largest one. T.C. O(N^2)


            Optimized Solution:
            -------------------

            In this approach, we create two arrays, one for storing the indices of left-smaller elements and another one for storing the indices of right-smaller elements.

            We also need a stack to store the indices in ascending order of their corresponding item-values .

            To find the index of the left-smaller element for each item :

                1. keep popping indices until an index with a smaller element (than current item) appears

                2. if the stack is / becomes empty, set 0 as left-smaller index for that item

                3. otherwise, set stack_top_item + 1 as left-smaller index 
                
                4. push the current index.


            To find the index of the right-smaller element for each item (starting from the last item):

                1. keep popping indices until an index with a smaller element (than current item) appears

                2. if the stack is / becomes empty, set n-1 as right-smaller index for that item (n is the length of the input array)

                3. otherwise, set stack_top_item - 1 as right-smaller index.

                4. push the current index.

            Now, calculate the area for each input-item using these two arrays and the aforementioned formula, to find the max area.

        */

        int n = heights.length;
        Stack < Integer > st = new Stack < > ();

        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }


    public boolean isValid(String s){

        Stack <Character> st= new Stack<>();

        for(int i=0;i<s.length();i++){

            char c= s.charAt(i);

            if( c=='(' || c=='{' || c=='[' ){
                st.push(c);
            }

            else{

                if(st.isEmpty()){
                    return false;
                }

                if( 
                    (st.peek() == '(' && c==')')||
                    (st.peek() == '{' && c=='}')||
                    (st.peek() == '[' && c==']')
                ){
                    st.pop();
                }
                else{
                    return false;
                }
            }

        }

        if(st.isEmpty()){
            return true;
        }
        return false;

    }


    public int minAddToMakeValid(String s) {    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

        Stack <Character> st= new Stack<>();

        /* 
            e.g. "()))((" needs 4 parentheses for validation.

            In this case, for each character,

                if it is '(', we push it into the stack.

                Otherwise, ( for ')' ) :

                    if the stack is not empty and the topmost element is '(' , we pop  that '(' .

                    Otherwise, we insert ')' in our stack.

            Finally, the size of the stack will indicate the no. of parenthesis required.
        */

        for(int i=0;i<s.length();i++){

            char c= s.charAt(i);

            if( c=='(' ){
                st.push(c);
            }

            else{

                if( !st.isEmpty() && st.peek() == '('){
                    st.pop();
                }
                else{   // if the stack is empty or the topmost element in the stack isn't an opening parenthesis
                    st.push(c);
                }
            }

        }

        return st.size(); 

    }


    public int minInsertions(String s){ //https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
    
        /* 
            Solution: https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/solutions/780199/java-c-python-straight-forward-one-pass


            Here, we treat '(' as an opening parenthesis and '))' as a closing parenthesis. left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.

            We use two variables,

                - 'right' : to store the no. of ')' required as we traverse the string

                - 'res' : to store the no. of '(' or ')' to be added to balance the string

            1. case ')'
                If we meet a right parentheses , right--.

                If right < 0, we need to add a left parentheses before it.

                Then we update right += 2 and res++


            2. case '('

                If we meet a left parentheses,
                we check if we have odd number ')' before.

                In 'right', we have odd ')' before,
                but we want right parentheses in pairs.
                So add one ')' in the string by updating right-- , res++ .

                Because we encountered ')', we update right += 2. 

        */

        int right=0, res=0;

        for (int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i)==')'){  
                
                right--;   // we encountered ')', hence we reduced the no. of ')' req.

                if(right<0){    // it means, no '(' before this. There's also no way it can be balanced in future. So,

                    res++;      // we increment 'res' that signifies we add a '(' at that location

                    right+=2;   // adding one '(' requires two ')', hence 'right' is incremented by 2.
                }
            }

            else{ // we encountered '('

                if(right%2!=0){     // if 'right' is not even, that means, there's a unpaired ')' at the left side. This unpaired ')' can not be balanced in future. 

                    res++;      // we increment 'res' that signifies we add another ')' at that location to make a pair.

                    right--;    // decremented 'right' as we just added '(' 
                }

                right+=2;   // since, we encountered '(', no. of ')' must be increased by 2.    
            }
        }

        return right+res;  

    }


    public int[] nextGreaterElements(int[] nums) {  // https://leetcode.com/problems/next-greater-element-ii/
        /* 

            ref: https://youtu.be/Du881K7Jtk8?si=9FSqhv6XzBiVyZmk

            Here, we start iterating from the right end of the array and use a stack to hold the items in descending order.

            Since, we need to assume given array is circular, we start iterating from index 2n-1 and use %-technique. If no next greater item exists, use -1.

            For each item,
                - we need to keep poping from the stack until the stack gets empty or a greater element is found.

                - if the stack is empty, set the next greater element as -1. 

                - otherwise, set the topmost element as next greater element.

                - push it into stack.
        */



        int n= nums.length;

        int [] ngeArr=new int[n];

        Stack<Integer> st= new Stack<>();

        for (int i = 2*n-1; i >=0 ; i--) {  // starting from 2n-1 and using %, we are basically iterating the i/p array twice
            
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }

            if(i<n){        // we write to the resultant array, when we are in the second half of iteration. This can be omitted but that would result in increased no. of overwrites to the o/p arr. 

                if(!st.isEmpty()) {
                    ngeArr[i%n]=st.peek();
                }
                else{
                    ngeArr[i%n]=-1;
                }

            }

            st.push(nums[i%n]);
        }
        
        return ngeArr;
    }


    public Stack<Integer> sort(Stack<Integer> s) {  // https://www.geeksforgeeks.org/problems/sort-a-stack/1
        
        // if there is only one element, it is already sorted
        if(s.size()==1) return s;
        
        // otherwise, pop an element
        int temp = s.pop();
        
        // call the function to sort the remaining elements
        s=sort(s);
        
        // now, we need to place 'temp' at the right position in stack
        
        Stack <Integer> aux= new Stack<>();     // initiating another stack
        
        // keep popping until we find an element less than or equal to temp
        while( !s.isEmpty() && s.peek()>temp){
            aux.push(s.pop());      // store popped items in second stack
        }
        
        s.push(temp);  
        
        while(!aux.isEmpty()){  // push back the popped items
            s.push(aux.pop());
        }
        
        return s;
    }

    static void reverse(Stack<Integer> s){ // https://www.geeksforgeeks.org/problems/reverse-a-stack/1

        if(s.size()==1){        // If the stack has only one element, no need to reverse it
            return;
        }
        
        int num= s.pop();       // pop an element
        reverse(s);             // recursively reverse the remaining part
        insertAtEnd(num,s);     // now, since the remaining stack is reversed, add the popped element to the end of it.
        
    }   
    static void insertAtEnd(int num, Stack<Integer> s){   // it adds num to the end of stack recursively  
        
        if(s.isEmpty()){    
            s.push(num);
            return;
        }
        
        int temp=s.pop();
        insertAtEnd(num,s);
        s.push(temp);
    }

}

class MyQueue{

    // We are implementing a queue using two stacks. 

    private Stack <Integer> first,second;    // 'first' is our main stack, 'second' being the auxiliary one

    MyQueue(){
        first=new Stack<>();
        second=new Stack<>();
    }

    /* 
        With this setup, push() takes constant time, while the pop() takes linear time. Hence, we call it 'Insert Efficient' Queue.

        However, in another scenario, push() could take linear time, while pop() could get away with constant time. Hence, it is called 'Remove Efficient' Queue.
        
        Steps for push() in 'Remove Efficient Queue':

            1. Pop all the elements from the main stack and store those in the auxiliary stack.

            2. Push in the main stack.

            3. Pop all the elements from the auxiliary stack and store those in the main stack.

        Steps for pop() in 'Remove Efficient Queue':

            1. Pop an element from the main stack.

     */
    void push(int x){
        first.push(x);
    }

    int pop(){
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        int res=second.pop();

        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return res;
    }

    int peek(){
        while(!first.isEmpty()){
            second.push(first.pop());
        }

        int res=second.peek();

        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return res; 
    }

    boolean empty(){
        return first.isEmpty();
    }

}









