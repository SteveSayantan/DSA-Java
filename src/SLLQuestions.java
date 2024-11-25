class ListNode {    // For leetcode questions
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

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

    public void deleteNode(SLLNode node) {
        /* 
            Intuition: 
            From the given node, we copy the value of the next node in the current node and move ahead. This continues until we reach
            the penultimate node. 
            
            When we reach the penultimate node, we break out of the loop. Copy the value of the final node to the penultimate node and
            make the penultimate node point to null.
        */

        while(node.getNext().getNext()!=null){    // since, the given node is not a tail node, node.next can't be null

            node.setVal(node.getNext().getVal());
            node=node.getNext();

        }

        node.setVal(node.getNext().getVal());
        node.setNext(null);
    }

    public SLLNode mergeLL(SLLNode head1,SLLNode head2){        //https://leetcode.com/problems/merge-two-sorted-lists/description/

        if(head1==null) return head2;
        if(head2==null) return head1;

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

        return res.getHead();
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

            If the node next to Fast is null, we have to stop checking as it is the end of the LL. Hence the second check. 
         */
        while(fast!=null && fast.getNext()!=null){     
            

            fast=fast.getNext().getNext();      // moving by two steps. For this we need the second check of while.
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

            Refer to Detect_Entry_Point-Explanation.png in asset.

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

        // ref: https://youtu.be/pNTc1bM1z-4?si=61L2MALDVGgaCiXj


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

        // Though 'slow' contains the middle node of the linked list, we can't include 'slow' in our left half as it produces erronious results for LL of size 2.
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {         // an efficient approach to merge two sorted LL

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode res=null;
        ListNode tailPtr=res;    // it points to the last node of our resultant LL
    

        while(list1!=null && list2!=null){

            if(list1.val<list2.val){
                tailPtr=insertAtLast(tailPtr,list1.val);
                if(res==null) res=tailPtr;
                list1=list1.next;
            }
            else{
                tailPtr=insertAtLast(tailPtr,list2.val);
                if(res==null) res=tailPtr;
                list2=list2.next;
            }
        }

        // at this point, we can just attach the remaining portion with our resultant LL
        if(list1!=null){
            tailPtr.next=list1;
        }

        if(list2!=null){
            tailPtr.next=list2;
        }

        return res;
    }

    public ListNode insertAtLast(ListNode tailPtr, int val){
        if(tailPtr==null){
            return new ListNode(val);
        }

        return tailPtr.next=new ListNode(val);
        
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

    public SLLNode iterativeReverse(SLLNode node){
        /* 
            Here, we would use two pointers (basically three) to reverse the connections between the nodes
        */

        SLLNode prev=null,current=node;     // 'prev' points to a previous node, 'current' points to the current node

        while(current!=null){

            SLLNode next=current.getNext(); // before altering the connection, we must preserve the next node

            if(prev==null) tail=current;    // adjusting the tail

            current.setNext(prev);

            prev=current;                   

            current=next;
        }

        head=prev;                         // adjusting the head
        return prev;    
    }

    public SLLNode rangedReverse(SLLNode node,int left,int right){  // https://leetcode.com/problems/reverse-linked-list-ii/description/

        // ref: https://youtu.be/GSJuwQzKSnI?si=hh0iQxXviJpbXVe-

        if(node==null) return node;

        SLLNode prev=null, current=node;

        while(left>1){

            // moving to the position to start the reversal
            prev=current;
            current=current.getNext();
            left--;
            right--;
        }
        
        // here, 'current' will point to the node at the first node in the range and 'prev' will point to the previous last node outside the range

        SLLNode connection=prev, left_end=current;

        while(right>0){
            SLLNode next=current.getNext();
            current.setNext(prev);
            prev=current;
            current=next;
            right--;
        }

        // at this point, current points to the next first node outside the range and prev points to the last node in the range

        // properly connecting the reversed part with the original part
        if(connection!=null){
            connection.setNext(prev);
        }
        else{
            node=prev;
            head=prev;      // adjusting the head
        }

        left_end.setNext(current);

        if(current==null) tail=left_end;    // adjusting the tail

        return node;
        
    }

    public boolean isPalindrome(SLLNode node ){ // https://leetcode.com/problems/palindrome-linked-list/

        /* 
            1. Find the middle node of the linked list

            2. Reverse the right part of linked-list from the middle node. Check palindrome-ll.png (important !!)

            3. Traverse the linked-list for comparison.

            4. Revert the linked-list to its original config.
        */

        if (node==null) return false;
        if(node.getNext()==null) return true;

        SLLNode slow=node,fast=node;

        while(fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();

        }

        // now slow is standing at the middle node

        // reverse the right part from the middle and store the updated head in slow
        slow=recursiveReverse(slow);

        // preserve the slow for future use
        SLLNode preservedHead=slow;

        tail=fast;      // reverting the tail to its previous value as recursiveReverse modifies the tail

        fast=node;      // placing the fast pointer to the start

        boolean res=true;
        while(slow!=null){  // In case of even no. of nodes, the slow pointer will reach NULL before fast. Hence, we choose it as termination condition instead of fast. Otherwise, the code won't work properly.

            if(fast.getVal()!=slow.getVal()) {
                res=false;
                break;
            };
            fast=fast.getNext();
            slow=slow.getNext();

        }
        // revert the list to its original form (no need to adjust tail here)
        recursiveReverse(preservedHead);
    
        return res;
    }
    
    public void reorderList(SLLNode node){      // https://leetcode.com/problems/reorder-list/description/
        
        if(node.getNext()==null||node.getNext().getNext()==null) return;


        /* 
          Basically, we are taking the first node and the last node, the second node and the penultimate node... like this to get the answer.

          To achieve this, 

          1. Find the middle of the ll.

          2. Reverse the right portion of the ll starting from the middle.

          3. Now, we can use two pointers to make connections between the left half and the reversed right half to get our answer.
        */
        SLLNode slow=node,fast=node;

        while(fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();

        }

        // now slow is standing at the middle node

        // reverse the right part from the middle and store the updated head in slow
        slow=recursiveReverse(slow);

        tail=fast;      // reverting the tail to its previous value as recursiveReverse modifies the tail

        fast=node;      // placing the fast pointer to the start

        while(slow.getNext()!=null){            // stop the loop when the slow pointer reaches the last node of the right half (as that is already connected with the last node of the left half )

            SLLNode tempFNext=fast.getNext();   // preserve the next node of the fast pointer
            fast.setNext(slow);                 // connect the fast to slow
            fast=tempFNext;                     // update the fast

            SLLNode tempSNext=slow.getNext();   // preserve the next node of the slow pointer
            slow.setNext(fast);                 // connect the slow to fast
            slow=tempSNext;                     // update the slow

        }

        tail=slow;      // adjusting the tail

    }

    public SLLNode reverseKGroup(SLLNode node,int k){   // https://leetcode.com/problems/reverse-nodes-in-k-group
        
        SLLNode temp= node;     // this is for traversing the list
        
        SLLNode prevNode=null;  // this tracks the last node of the previous group

        while(temp!=null){

            SLLNode KthNode=getKthNode(temp,k);  // Get the Kth node of the current group

            if(KthNode==null){         // // If the Kth node is NULL i.e. not a complete group

                if(prevNode!=null){    // If there was a previous group, link the last node to the current node
                    prevNode.setNext(temp);
                }

                break;
            }

            SLLNode nextNode=KthNode.getNext(); // Store the next node after the Kth node

            KthNode.setNext(null);      // Disconnect the Kth node to prepare for reversal
            
            recursiveReverse(temp); // Reverse the nodes from temp to the Kth node

            if(node==temp){     // if we are dealing with the very first group, we need to update the original head
                node=KthNode;
            }
            else{
                prevNode.setNext(KthNode); // Link the last node of the previous group to the reversed group
            }

            prevNode=temp;  // Update the pointer to the last node of the previous group
            temp=nextNode;  // Move to the next group
        }

        return node;


    }
    SLLNode getKthNode(SLLNode ptr,int k){

        k--;

        while(ptr!=null && k>0){
            ptr=ptr.getNext();
            k--;
        }

        return ptr;
    }


    public ListNode rotateRight(ListNode head, int k) {         //https://leetcode.com/problems/rotate-list/

        if(head==null || head.next==null) return head;

        /* 
            1. First, we connect the last node with the head. 

            2. If the length of the LL is l and we need to rotate it k times, we will have our new head at (l-k) index.

            3. We store the referece to our new head and make the element at index (l-k-1) point to null.

            4. Return the stored reference.

        */


        int len=1;
        ListNode temp=head;

        while(temp.next!=null){
            temp=temp.next;
            len++;
        }

        temp.next=head; // connecting the last node with head

        int rotationCount=k%len;
        int skip= len-rotationCount;    

        temp=head;      // reusing this variable

        for(int i=0;i<skip-1;i++){      // we go to the previous node of our new head
            temp=temp.next;
        }

        head=temp.next;    
        temp.next=null;

        return head;

        
    }
 

    public static void main(String[] args) {
        SLLQuestions list1= new SLLQuestions();
        // SLLQuestions list2= new SLLQuestions();

        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(3);
        list1.insertAtEnd(4);
        list1.insertAtEnd(5);

        // list2.insertAtEnd(1);
        // list2.insertAtEnd(3);
        // list2.insertAtEnd(4);

        // SLLQuestions list3= list1.mergeLL(null,list2);
        list1.displayLL();

        // System.out.println(list1.isHappy(2));
        
        // list1.head=list1.sortList(list1.head);

        list1.reorderList(list1.head);
        System.out.println(list1.tail.getVal());
        list1.displayLL();

    }
}
