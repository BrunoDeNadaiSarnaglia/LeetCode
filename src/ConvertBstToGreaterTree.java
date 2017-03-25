/**
 * Created by Sarnaglia on 3/25/17.
 */
public class ConvertBstToGreaterTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Pair {
        int sum;
        TreeNode node;

        public Pair(int sum, TreeNode node) {
            this.sum = sum;
            this.node = node;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        return helper(root, 0).node;
    }

    private Pair helper(TreeNode node, int sum){
        if(node == null) return new Pair(sum, null);
        Pair pr = helper(node.right, sum);
        TreeNode node2 = new TreeNode(pr.sum + node.val);
        node2.right = pr.node;
        Pair pl = helper(node.left, pr.sum + node.val);
        node2.left = pl.node;
        return new Pair(pl.sum, node2);
    }

}
