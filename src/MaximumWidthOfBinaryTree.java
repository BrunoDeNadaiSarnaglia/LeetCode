import java.util.LinkedList;

/**
 * Created by Sarnaglia on 9/24/17.
 */
public class MaximumWidthOfBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int depth = depth(root);
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        int max = 1;
        for (int i = 0; i < depth - 1; i++) {
            LinkedList<TreeNode> nextL = new LinkedList<>();
            for (TreeNode node: l) {
                l.add(node == null ? null : node.left);
                l.add(node == null ? null : node.right);
            }
            max = Math.max(trim(nextL), max);
            l = nextL;
        }
        return max;
    }

    private int trim(LinkedList<TreeNode> l) {
        while (l.getFirst() == null) l.removeFirst();
        while (l.getLast() == null) l.removeLast();
        return l.size();
    }

    private int depth(TreeNode node) {
        return node == null ? 0 : Math.max(depth(node.left), depth(node.right)) + 1;
    }


}
