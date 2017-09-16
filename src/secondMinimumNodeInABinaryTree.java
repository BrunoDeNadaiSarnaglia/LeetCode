/**
 * Created by Sarnaglia on 9/16/17.
 */
public class secondMinimumNodeInABinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int findSecondMinimumValue(TreeNode root) {
        int secondMinimumValue = findSecondMinimumValue(root, root.val);
        return secondMinimumValue == Integer.MAX_VALUE ? -1 : secondMinimumValue ;
    }
    public int findSecondMinimumValue(TreeNode node, int rootVal) {
        if(node == null)    return Integer.MAX_VALUE;
        if(node.left == null || node.right == null) return node.val == rootVal ? Integer.MAX_VALUE : rootVal;
        if(node.val != rootVal) return node.val;
        int minimumLeft = findSecondMinimumValue(node.left, rootVal);
        int minimumRight = findSecondMinimumValue(node.right, rootVal);
        return Math.min(minimumLeft, minimumRight);
    }

}
