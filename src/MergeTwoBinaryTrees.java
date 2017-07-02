/**
 * Created by Sarnaglia on 7/2/17.
 */
public class MergeTwoBinaryTrees {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode root;
        if(t1 == null) {
            root = new TreeNode(t2.val);
            leftChild = mergeTrees(null, t2.left);
            rightChild = mergeTrees(null, t2.right);
        }
        else if(t2 == null) {
            root = new TreeNode(t1.val);
            leftChild = mergeTrees(t1.left, null);
            rightChild = mergeTrees(t1.right, null);
        }
        else {
            root = new TreeNode(t1.val + t2.val);
            leftChild = mergeTrees(t1.left, t2.left);
            rightChild = mergeTrees(t1.right, t2.right);
        }
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
