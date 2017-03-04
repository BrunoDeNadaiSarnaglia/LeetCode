/**
 * Created by Sarnaglia on 3/4/17.
 */
public class MinimumAbsoluteDifferenceinBST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Pair {
        private TreeNode previous;
        private int min;

        public Pair(TreeNode previous, int min) {
            this.previous = previous;
            this.min = min;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        return inOrder(root, new Pair(null, Integer.MAX_VALUE)).min;
    }

    private Pair inOrder(TreeNode node, Pair p){
        if(node == null)   return p;
        Pair pl = inOrder(node.left, p);
        int min = Math.min(pl.previous != null ? node.val - pl.previous.val : Integer.MAX_VALUE, pl.min);
        return inOrder(node.right, new Pair(node, min));
    }
}
