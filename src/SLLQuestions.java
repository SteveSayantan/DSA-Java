public class SLLQuestions {

    private SLLNode head,tail;
    private int size;

    public int getSize(){
        return size;
    }

    public SLLNode getHead(){
        return head;
    }

    public void insertAtFirst(int val){     
        
        if(size==0){
            SLLNode temp= new SLLNode(val);
            head=tail=temp;
        }
        else{

            SLLNode temp= new SLLNode(val,head);
            head=temp;
        }
        size++;
    }

    public void displayLL(){

        if(size==0){
            System.out.println("Linked List is Empty!!");
            return;
        }

        SLLNode temp=head;

        while (temp!=null) {
            System.out.print(temp.getVal()+" --> ");
            temp=temp.getNext();
        }
        System.out.println("END");
    }

    public void insertAtEnd(int val){

        if(size==0){
            insertAtFirst(val);
            return;
        }
        
        SLLNode temp= new SLLNode(val);
        tail.setNext(temp);
        tail=temp;
        size++;

    }

    /* 
    ----------
    Questions
    ----------
    */

    public void recursiveInsert(int pos,int val){
        if(pos<=0 || pos> size+1){
            System.out.println("Invalid Position!!");
            return;
        }
        head=recInsert(pos, val, head);
    }

    private SLLNode recInsert(int pos,int val,SLLNode node){

        if(pos==1){
            SLLNode newNode= new SLLNode(val,node);
            size++;
            if(node==null) tail=newNode;        // if the value of node is null, that means it is the end node. Hence, 'tail' is assigned to it.
            return newNode;
        }

        node.setNext(recInsert(pos-1, val, node.getNext()));
        return node;

    }

    public void deleteContiguousDuplicates(){   //https://leetcode.com/problems/remove-duplicates-from-sorted-list/description

        if(size==0){
            System.out.println("Linked List is Empty!!");
            return;
        }

        SLLNode temp=head;

        while(temp.getNext()!=null){    // if it is the final node, no need to run the loop anymore

            SLLNode ptr= temp.getNext();

            while(ptr!=null && ptr.getVal()==temp.getVal()){   
                ptr=ptr.getNext();
            }

            temp.setNext(ptr);

            if(ptr!=null) temp=temp.getNext();  // sometimes 'ptr' may end up in null, we don't want our 'temp' to be null
        }

        tail=temp;

    }

    public SLLQuestions mergeLL(SLLQuestions list1,SLLQuestions list2){     //https://leetcode.com/problems/merge-two-sorted-lists/description/

        
        SLLNode head1=list1 == null? null:list1.head;
        SLLNode head2=list2 == null? null:list2.head;

        SLLQuestions res= new SLLQuestions();

        while(head1!=null && head2!=null){

            if(head1.getVal()>head2.getVal()){

                res.insertAtEnd(head2.getVal());
                head2=head2.getNext();
            }
            else{
                res.insertAtEnd(head1.getVal());
                head1=head1.getNext();
            }

        }

        while(head1!=null){
            res.insertAtEnd(head1.getVal());
            head1=head1.getNext();
        }
        while(head2!=null){
            res.insertAtEnd(head2.getVal());
            head2=head2.getNext();
        }

        return res;
    }

    public boolean hasCycle(SLLQuestions list){  // https://leetcode.com/problems/linked-list-cycle/description/


        /* 
            If any question deals with 'cycle', use the following approach, known as Fast and Slow Pointer (aka Tortoise and Hare algo). It is useful for cycle detection and finding a 
            particular node (may or may not involve cycle).
            
            Here, 
            
                # The Fast pointer will move two steps and the Slow pointer will move one step at a time.
                
                # Since, the speed of the Fast pointer is twice that of the Slow pointer, after some time they must meet together if there is a cycle present.

                # If no cycle is present, the Fast pointer will become null.

                # Time Complexity O(N) , irrespective of the presence of cycle.

            
        */

        SLLNode head=list==null? null:list.head;

        SLLNode fast=head;
        SLLNode slow=head;

        /* 
            Since, we are moving the Fast pointer by two steps, it might end up being null. So we might get NullPointerException if we omit the first check.

            If the node following Fast is null, we have to stop checking as it is the end of the LL. Hence the second check. 
         */
        while(fast!=null && fast.getNext()!=null){     
            

            fast=fast.getNext().getNext();      // moving by two steps
            slow=slow.getNext();

            // since, fast and slow point to the head initially, we can compare only after moving both of them. Otherwise, every time the result will be true.
            if(fast==slow){
                return true;
            }

        }

        return false;
    }

    public int lengthOfLoop(SLLQuestions list) { //https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455
        
        // Length of a loop can be defined as the number of edges involved in the cycle.

        // first detect the presence of a loop
        SLLNode head=list==null? null:list.head;

        SLLNode fast=head;
        SLLNode slow=head;

        while(fast!=null && fast.getNext()!=null){

            fast=fast.getNext().getNext();
            slow=slow.getNext();

            if(fast==slow){     // this means , we're inside a loop

            // Now, we again move the Fast pointer (or, the Slow one) until it meets the other one. We count each step taken.

               int count=0;

               do{
                   fast=fast.getNext();
                   count++;
               }
               while(fast!=slow);   // initially, fast is equal to slow, hence we need to use do-while loop

               return count;
            }

        }
        return 0;   // if no loop is present, return 0
    }

    public SLLNode detectCycleEntryPoint(SLLQuestions list){    //https://leetcode.com/problems/linked-list-cycle-ii/description

        /* 
            Ref: https://youtu.be/2Kd0KKmmHFc?t=937 , https://youtu.be/QfbOhn0WZ88?list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&t=629

            Understand how the distance from the head node to the entry node and the collision node to entry node is always the same.

         */
        SLLNode head=list==null? null:list.head;

        SLLNode fast=head;
        SLLNode slow=head;

        while(fast!=null && fast.getNext()!=null){

            fast=fast.getNext().getNext();
            slow=slow.getNext();

            if (fast==slow) {   // we are at the collision point. 
                
                slow=head; // Placing the Slow pointer at head. From the head, we will move the Slow pointer by one step.

                
                while(slow!=fast){
                    slow=slow.getNext();
                    fast=fast.getNext();    //From the collision point, we move the Fast pointer by one step.
                }

                // Since, the distance b/w head node to the entry node = the distance b/w collision node to entry node , Fast and Slow both meet at the entry point
                return slow;
            }

        }
        return null;

    }

    public boolean isHappy(int n){  //https://leetcode.com/problems/happy-number/description/
        /* 
            Check out the definition of Happy number.

            If a number is not happy and we keep squaring its digits, after a particular point we shall arrive at a previous result and this loop continues.
            e.g., 12 is not a happy number,

            Hence, 1^2 + 2^2 = 5
                   
                  5^2 = 25

                  2^2 + 5^2 = 29
                  2^2 + 9^2 = 85
                  8^2 + 5^2 = 89
                  ...
                  5^2 + 8^2 = 89
                  // same pattern keeps continuing

            We can relate this with a linked list which contains the sum of square of each digit in each node. If the number is not a Happy Number, the linked list
             contains a cycle (due to the repetition in pattern), otherwise the last node of the linked list contains 1.

            To detect the cycle we apply Hare and Tortoise algo.
        */

        int fast=n;
        int slow=n;

        do{
            slow=squareOfDigits(slow);                  // single square
            fast=squareOfDigits(squareOfDigits(fast));  // double square

            if(fast==1) return true;
        }
        while(fast!=slow);

        return false;
    }

    private int squareOfDigits(int n){
        int ans=0;

        while(n>0){
            int lastDigit=n%10;
            n/=10;
            ans+=lastDigit*lastDigit;
        }
        return ans;
    }
    
    public SLLNode middleNode(SLLQuestions list){

        /* 
            If a pointer travels twice as fast as another pointer , the latter will always cover the half of the distance covered by the former one.
            
            We apply this logic to find the middle node of a linked list. When the fast pointer becomes null, the slow one points to the middle node of the 
             linked list.
        */
        SLLNode slow=list.head;
        SLLNode fast=list.head;

        while(fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();

        }
        return slow;
    }
    

    public SLLNode sortList(SLLNode head){  // https://leetcode.com/problems/sort-list/description/
        
        if(head==null || head.getNext()==null){     // if list is empty or has a single node, return the head
            return head;
        }
        
        // find the middle and previous of the middle node of given linked list
        
        SLLNode slow=head;
        SLLNode fast=head;

        SLLNode temp=head;  // finally this pointer will point to the previous node of the middle node, thereby working as the tail of the left half

        
        while(fast!=null && fast.getNext()!=null){
            temp=slow;
            slow=slow.getNext();
            fast=fast.getNext().getNext();

        }

        // At this line, 'slow' contains the middle node of the linked list, 'temp' contains the previous node of the middle one (last node of the left part)

        temp.setNext(null);  // separating the left part from the right part

        // recursively, sort the both the left and right part
        SLLNode left_head=sortList(head);    
        SLLNode right_head=sortList(slow);
        
        return mergeLL(left_head, right_head);
    }
    
    public SLLNode mergeLL(SLLNode head1,SLLNode head2){  

        SLLQuestions res= new SLLQuestions();

        while(head1!=null && head2!=null){

            if(head1.getVal()>head2.getVal()){

                res.insertAtEnd(head2.getVal());
                head2=head2.getNext();
            }
            else{
                res.insertAtEnd(head1.getVal());
                head1=head1.getNext();
            }

        }

        while(head1!=null){
            res.insertAtEnd(head1.getVal());
            head1=head1.getNext();
        }
        while(head2!=null){
            res.insertAtEnd(head2.getVal());
            head2=head2.getNext();
        }

        return res.head;
    }

    public SLLNode bubbleSortLL(SLLNode head){

        // @ 1:36:30 come back after revising recursion
        return head;
    }

    public SLLNode recursiveReverse(SLLNode node){  //https://leetcode.com/problems/reverse-linked-list/description/

        if(node==null || node.getNext()==null){     // if the node is 'null' or the final node, just return the reference
    
            return node;
        }

        SLLNode head=recursiveReverse(node.getNext());  // This will get the last node which will be used as 'head'

        // adjusting the pointers
        SLLNode nextNode=node.getNext();    // node.getNext() will never be 'null' due to the check at the first line 
        nextNode.setNext(node);

        node.setNext(null);     // the current node could be the last node, hence setting its next as 'null'

        tail=node;      // update the tail

        return head;    // return the ref to head
    }

    // start from iterative reversal of linked list

    public static void main(String[] args) {
        SLLQuestions list1= new SLLQuestions();
        SLLQuestions list2= new SLLQuestions();

        list1.insertAtEnd(-1);
        list1.insertAtEnd(5);
        list1.insertAtEnd(3);
        list1.insertAtEnd(4);
        list1.insertAtEnd(0);

        list2.insertAtEnd(1);
        list2.insertAtEnd(3);
        list2.insertAtEnd(4);

        // SLLQuestions list3= list1.mergeLL(null,list2);
        list1.displayLL();

        // System.out.println(list1.isHappy(2));
        
        // list1.head=list1.sortList(list1.head);

        list1.head=list1.recursiveReverse(list1.head);
        list1.displayLL();

    }
}
