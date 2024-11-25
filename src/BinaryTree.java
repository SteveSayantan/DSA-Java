import java.util.Scanner;

class BinaryTree {

    TNode head;

    BinaryTree(int val){    // this will be the value of the root node
        head= new TNode(val);
    }
    
    private void insertNodes(TNode node,Scanner in){

        if(node ==null) return;
        
        System.out.printf("Do you want to insert in left of %d ? [y/n] : ",node.x);
        
            
        String response=in.nextLine().toLowerCase();

        if(response.startsWith("y")){
    
            System.out.printf("Enter the value for left child of %d : ",node.x);
            TNode lChild= new TNode(in.nextInt());
            node.left=lChild;
            in.nextLine();  // for clearing the i/p buffer
            insertNodes(lChild,in);
        }

        System.out.printf("Do you want to insert in right of %d ? [y/n] : ",node.x);
        response=in.nextLine().toLowerCase();
        

        if(response.startsWith("y")){
            System.out.printf("Enter the value for right child of %d : ",node.x);
            TNode rChild= new TNode(in.nextInt());
            node.right=rChild;
            in.nextLine();  // for clearing the i/p buffer
            insertNodes(rChild,in);
        }

    }

    TNode createBinaryTree(){
        Scanner in= new Scanner(System.in);
        insertNodes(this.head,in);
        in.close();
        return this.head;
    }

    static void preOrderTraversal(TNode node){
        if(node==null) return;
        System.out.print(node.x+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

}

/* 
    Use cases of different traversal techniques:
    ---------------------------------------------

    Pre-order:
    ---------
    1. To evaluate math expression.

    2. To make a copy of the binary tree.

    3. To make a binary tree from a string or array (Serialization).

    In-order:
    ---------
    1. In BST, it visits child nodes in a sorted manner.

    2. To make a copy of the binary tree.

    Post-order:
    ---------
    1. While performing deletion from binary tree.

    2. While performing bottom-up calculation.
 */

class TNode{
    int x;
    TNode left,right;

    TNode(int x){
        this.x=x;
    }

    TNode(int x, TNode left, TNode right){
        this(x);
        this.left=left;
        this.right=right;
    }
}
