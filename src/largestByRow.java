import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sarnaglia on 2/14/17.
 */
public class largestByRow {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> largestValues(TreeNode root) {
        if(root == null)    return null;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        List<Integer> maxPerLevel = new ArrayList<>();
        while (!stk.isEmpty()){
            Stack<TreeNode> nextLevelNodes = new Stack<>();
            int max = Integer.MIN_VALUE;
            while (!stk.isEmpty()) {
                TreeNode node = stk.pop();
                max = (max > node.val? max : node.val);
                if(node.left != null)   nextLevelNodes.push(node.left);
                if(node.right != null)   nextLevelNodes.push(node.right);
            }
            maxPerLevel.add(max);
            stk = nextLevelNodes;
        }
        return maxPerLevel;
    }
}
