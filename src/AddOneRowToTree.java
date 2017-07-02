/**
 * Created by Sarnaglia on 7/2/17.
 */
public class AddOneRowToTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return null;
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        else if(d != 2) {
            root.left = addOneRow(root.left, v, d - 1);
            root.right = addOneRow(root.right, v, d - 1);
            return root;
        } else {
            TreeNode node = new TreeNode(v);
            node.left = root.left;
            root.left = node;
            node = new TreeNode(v);
            node.right = root.right;
            root.right = node;
            return root;
        }
    }

}
