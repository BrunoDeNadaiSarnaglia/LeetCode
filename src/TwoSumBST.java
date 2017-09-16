/**
 * Created by Sarnaglia on 9/16/17.
 */
public class TwoSumBST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }

    public boolean findTarget(TreeNode root, TreeNode node, int k) {
        if(node == null)    return false;
        int complement = k - node.val;
        if(contains(root, complement, node)) return true;
        return findTarget(root, node.left, k) || findTarget(root, node.right, k);
    }

    private boolean contains(TreeNode node, int num, TreeNode except) {
        if(node == null) return false;
        if(num < node.val) return contains(node.left, num, except);
        if(num > node.val) return contains(node.right, num, except);
        if(except == node) return contains(node.left, num, except) || contains(node.right, num, except);
        return true;
    }

}
