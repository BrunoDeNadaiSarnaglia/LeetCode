import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sarnaglia on 2/14/17.
 */
public class FindBottomLeftChild {



    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findBottomLeftValue(TreeNode root) {
        if(root == null)    return -1;
        LinkedList<TreeNode> l = new LinkedList<>();
        l.addFirst(root);
        int leftMost = 0;
        while (!l.isEmpty()){
            TreeNode node = l.pollFirst();
            if(node != null){
                leftMost = node.val;
                l.addLast(node.left);
                l.addLast(node.right);
            }
        }
        return leftMost;
    }


}
