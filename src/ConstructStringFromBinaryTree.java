/**
 * Created by Sarnaglia on 7/1/17.
 */


public class ConstructStringFromBinaryTree {


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t) {
        if(t == null)   return "";
        String leftTree = tree2str(t.left);
        String rightTree = tree2str(t.right);
        if(!rightTree.equals("")) {
            return t.val + "(" + leftTree + ")(" + rightTree + ")";
        }
        if(!leftTree.equals("")) {
            return t.val + "(" + leftTree + ")";
        }
        return t.val + "";
    }

}
