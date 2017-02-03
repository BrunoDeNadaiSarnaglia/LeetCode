import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        Stack<TreeNode> pPath = pathToRoot(root, p);
        Stack<TreeNode> qPath = pathToRoot(root, q);
        TreeNode ancestor = root;
        while (!qPath.isEmpty() && !pPath.isEmpty() && pPath.peek() == qPath.peek()){
            ancestor = pPath.pop();
            qPath.pop();
        }
        return ancestor;
    }

    private Stack<TreeNode> pathToRoot(TreeNode root, TreeNode p){
        if(root == null)   return null;
        if(root == p) return new Stack<>();
        Stack<TreeNode> leftPath = pathToRoot(root.left, p);
        if(leftPath != null){
            leftPath.add(root.left);
            return leftPath;
        }
        Stack<TreeNode> rightPath = pathToRoot(root.right, p);
        if(rightPath != null){
            rightPath.add(root.right);
            return rightPath;
        } else {
            return null;
        }
    }
}
