import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeQuestions {
    public static void main(String[] args) {
        
    }
    public List<Integer> iterativePreorderTraversal(TreeNode root) { 

        // ref: https://youtu.be/Bfqd8BsPVuw?si=Mpy_JH2GxI95PQCW
        
        List<Integer> l= new ArrayList<Integer>();

        if(root == null) return l;

        Stack<TreeNode> s= new Stack<>();

        s.push(root);       // first, we push the root in the stack

        while(!s.isEmpty()){   

            TreeNode temp= s.pop();     // pop a node

            // stack is a LIFO datastructure, hence we push the right child before pushing the left one
            if(temp.right!=null)s.push(temp.right); 
            if(temp.left!=null)s.push(temp.left);

            l.add(temp.val);
        }

        return l;
    }


    public List<Integer> iterativeInorderTraversal(TreeNode root) {      
        
        // ref: https://youtu.be/lxTGsVXjwvM?si=GvDvbjS3Od89r-Ie

        /* 
            Intuition:
            ---------
            1. A pointer `ptr` is initialized with the given root.

            2. Keep repeating the following steps:

                i. if `ptr` points to null:

                    - if the stack is empty, break the loop.

                    - otherwise, pop from a node from the stack, add its value to the list and assign its right child to `ptr` .

                ii. Otherwise,

                    - push the node in stack.

                    - Assign the its left child to the `ptr` .

            3. return the list.

        */

        TreeNode ptr= root;
        List<Integer> l= new ArrayList<>();

        Stack<TreeNode> s= new Stack<>();

        while(true){

            if(ptr==null){
                if(s.isEmpty()) break;
                TreeNode temp= s.pop();
                l.add(temp.val);
                ptr=temp.right;
            }
            else{
                s.push(ptr);
                ptr=ptr.left;
            }

        }

        return l;

    }


    public List<Integer> iterativePostorderTraversal(TreeNode root) {

        // ref: https://youtu.be/2YBhNLodD8Q?si=hL8zK9QcaYd4tGUL

        /* 
            Pre-order traversal looks like Root --> Left --> Right

            If we swap Left and Right, we get Root --> Right --> Left.

            Now, if we reverse this entirely, we get Left --> Right --> Root (i.e. Post-order traversal). To perform this reversal, we use the second stack.

            So the intuition is:
            
                1. We perform pre-order traversal but we insert the Left child in the stack first.

                2. Whenever we pop anything from the stack, we push it inside the second stack.

                3. Finally, we empty the second stack to get the Post-order traversal.


        */
        List<Integer> l=new ArrayList<>();

        if(root == null) return l;

        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){

            TreeNode temp= s1.pop();

            if(temp.left!=null)s1.push(temp.left);
            if(temp.right!=null)s1.push(temp.right);

            s2.push(temp);
        }

        while(!s2.isEmpty()){
            l.add(s2.pop().val);
        }

        return l;


    }


    public List<Integer> allTraversals(TreeNode root){

        // ref: https://youtu.be/ySp2epYvgTE?si=xisIai52SS0qJxYy

        /* 
            Perform in-order, pre-order and post-order traversal using a single stack.

            Here, instead of inserting a node, we always insert a tuple (node,num) in the stack. For a particular node, 'num' is always
                initialized with 1. Checkout the class Pair below.
                
            S:1 - Push (root,1) in the stack.

            S:2 - Perform the following steps until the stack is empty:

                    - Peek the topmost element.

                    - if 'num' is 1

                        - Add the corresponding node in Pre-order.
                        - Increment the 'num' by 1.
                        - Push (left_child,1) in stack.

                    - if 'num' is 2

                        - Add the corresponding node in In-order.
                        - Increment the 'num' by 1.
                        - Push (right_child,1) in stack.

                    - Otherwise,

                        - Add the corresponding node in Post-order.
                        - Pop this node from the stack
 
        */
        List<Integer> post =new ArrayList<>();  
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        if(root == null) return pre;

        Stack<Pair> s = new Stack<>();

        s.push(new Pair(root));

        while(!s.isEmpty()){

            Pair temp= s.peek();

            if(temp.num==1){
                pre.add(temp.node.val);
                temp.num++;
                if(temp.node.left!=null) s.push(new Pair(temp.node.left));
            }
            else if(temp.num==2){
                in.add(temp.node.val);
                temp.num++;
                if(temp.node.right!=null) s.push(new Pair(temp.node.right));
            }
            else{
                post.add(temp.node.val);
                s.pop();
            }

        }

        return in;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        // ref: https://youtu.be/EoAsWbO7sqg?si=R69pKtLkiWSotiXM

        
        List<List<Integer>> res= new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> q= new LinkedList<>();

        // Initially, we insert the root in the queue
        q.offer(root);      // offer() inserts an element in the queue

        while(!q.isEmpty()){    // In each iteration,we take out all the elements off the queue and insert their corresponding left and right child 

            int nodeCount = q.size();

            List<Integer> subList= new ArrayList<>(nodeCount);

            for(int i=0; i<nodeCount; i++){
                TreeNode temp= q.remove();  // remove() removes the first element of the queue
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
                subList.add(temp.val);
            }

            res.add(subList);
        }

        return res;
    }

    
    public int maxDepth(TreeNode root) {    // https://leetcode.com/problems/maximum-depth-of-binary-tree/

        // Here, we are counting the no. of nodes from from the root to its deepest leaf, including the root.
        if(root== null) return 0;
 
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right)); 
    }


    public boolean isBalanced(TreeNode root) {      // https://leetcode.com/problems/balanced-binary-tree/

        /* 
            Here, instead of calculating the balance factor on each node, we try to find imbalance while calculating the height ( same as prev. one). 
            
            When an imbalance is found there is no need to calculate further.

            Using this strategy, we can check the balance in a single parse.
            
        */

        return calculateHeight(root)!=-1;

    }

    int calculateHeight(TreeNode root){

        if(root ==null) return 0;

        int lHeight=calculateHeight(root.left);

        if(lHeight == -1) return -1;

        int rHeight= calculateHeight(root.right);

        if(rHeight == -1) return -1;

        if(Math.abs(lHeight-rHeight)>1) return -1;  // if imbalance is found , we return -1

        return 1+Math.max(lHeight,rHeight);
    }




    public int diameterOfBinaryTree(TreeNode root) {      // https://leetcode.com/problems/diameter-of-binary-tree/
        /* 
            To calculate the diameter for a particular node, we just need to add the height of both the subtrees of that node.
            
            First, we calculate the height of both the subtrees starting from the root. We calculate the height applying the previous strategy.

            But while calculating height, we also store the max of sum of both the heights in a global variable. Hence, we find the diameter only
             in a single parse.

        */
        int [] dia = new int[1];    // we take this array as global variable to store the max (lHeight + rHeight)
        findHeight(root, dia);
        return dia[0];
    }
    int findHeight(TreeNode root, int [] buffer){

        if(root == null) return 0;

        int lHeight= findHeight(root.left,buffer);

        int rHeight= findHeight(root.right,buffer);

        buffer[0]=Math.max(buffer[0], lHeight+rHeight);

        return 1+Math.max(lHeight, rHeight);

    }



    public boolean isSameTree(TreeNode p, TreeNode q) {  // https://leetcode.com/problems/same-tree/

        // Here, we use the idea of pre-order traversal

        if(p == null || q == null) return p==q; // if both are null return true, otherwise return false

        if(p.val != q.val) return false;
        
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }



    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

        /* 
            This is quite similar to level-order traversal. Here, to achieve the zigzag traversal, we use a flag variable. Its value is
                altered at the end of each iteration.

            Whenever the flag is false, we reverse the subList and add it to the list.
         */
        List<List<Integer>> res = new ArrayList<>();
        
        if(root== null) return res;

        Queue <TreeNode> q = new LinkedList<>();

        q.offer(root);

        boolean flag = true;

        while(!q.isEmpty()){

            int nodeCount= q.size();

            List<Integer> subList = new ArrayList<>(nodeCount);

            for(int i=0;i<nodeCount;i++){
                TreeNode temp= q.remove(); 
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
                subList.add(temp.val);
            }

            if(!flag){
                Collections.reverse(subList);
            }

            res.add(subList);
            flag=!flag;
        }

        return res;
    }



}
class Pair{
    TreeNode node;
    int num;

    Pair(TreeNode node){
        this.node=node;
        this.num=1;
    }
   
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

