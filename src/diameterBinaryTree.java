/**
 * Created by Sarnaglia on 3/25/17.
 */
public class diameterBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Pair {
        int maxLen;
        int diameter;

        public Pair(int maxLen, int diameter) {
            this.maxLen = maxLen;
            this.diameter = diameter;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diameter;
    }

    private Pair helper(TreeNode root) {
        if(root == null)    return new Pair(0,0);
        Pair pl = helper(root.left);
        Pair pr = helper(root.right);
        return new Pair(
                Math.max(pl.maxLen, pr.maxLen) + 1,
                Math.max(pl.diameter, Math.max(pr.diameter, pl.maxLen + pr.maxLen + 1)));
    }
}
