public class BST {

    TNode head;

    void createBST(int [] nodeArr){

        if(nodeArr!=null && nodeArr.length>0){
            head=new TNode(nodeArr[0]);

            for (int i = 1; i < nodeArr.length; i++) {
                insertBSTNode(head, nodeArr[i]);
            }
        }
    }

    private TNode insertBSTNode(TNode node, int val){

        if(node==null){
            return new TNode(val);
        }

        if(node.x>val){
            node.left=insertBSTNode(node.left, val);
        }

        if(node.x<val){
            node.right=insertBSTNode(node.right, val);
        }

        return node;

    }

    public static void main(String[] args) {
        BST b= new BST();
        b.createBST(new int[]{5,4,2,1,10});
        BinaryTree.preOrderTraversal(b.head);
    }
    
}
