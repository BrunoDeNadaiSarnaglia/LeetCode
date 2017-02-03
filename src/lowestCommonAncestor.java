import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sarnaglia on 2/2/17.
 */



public class lowestCommonAncestor {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q)  return p;
        LinkedList<TreeNode> pPath = pathToRoot(root, p);
        LinkedList<TreeNode> qPath = pathToRoot(root, q);
        int i = 0;
        while (i + 1 < pPath.size() && i + 1 < qPath.size() && pPath.get(i + 1) == qPath.get(i + 1)){
            i++;
        }
        return pPath.get(i);
    }

    private LinkedList<TreeNode> pathToRoot(TreeNode root, TreeNode p){
        if(root == null)   return null;
        if(root == p){
            LinkedList<TreeNode> path = new LinkedList<>();
            path.add(root);
            return path;
        }
        LinkedList<TreeNode> leftPath = pathToRoot(root.left, p);
        if(leftPath != null){
            leftPath.addFirst(root);
            return leftPath;
        }
        LinkedList<TreeNode> rightPath = pathToRoot(root.right, p);
        if(rightPath != null){
            rightPath.addFirst(root);
            return rightPath;
        } else {
            return null;
        }
    }
}
