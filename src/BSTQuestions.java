public class BSTQuestions {
    
    public TreeNode searchBST(TreeNode root, int val) {   // https://leetcode.com/problems/search-in-a-binary-search-tree/  
        if(root == null) return null;

        if(root.val > val) return searchBST(root.left,val);
        if(root.val < val) return searchBST(root.right,val);
        return root;

    }
}
