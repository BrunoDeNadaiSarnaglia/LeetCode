/**
 * Created by Sarnaglia on 6/24/17.
 */




public class SubtreeOfAnotherTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(isEqual(s, t))   return true;
        if(s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    private boolean isEqual(TreeNode s, TreeNode t) {
        if(s == t)  return true;
        if(s == null || t == null) return false;
        if(s.val != t.val)  return false;
        if(!isEqual(s.left, t.left) || !isEqual(s.right, t.right))    return false;
        return true;
    }
}
