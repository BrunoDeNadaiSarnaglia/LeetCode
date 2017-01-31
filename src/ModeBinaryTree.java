import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sarnaglia on 1/30/17.
 */
public class ModeBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        int max = 0, previous = Integer.MIN_VALUE, count = 0;
        List<Integer> modes = new ArrayList<>();
        putLeftBranch(stk, root);
        while (!stk.isEmpty()){
            TreeNode node = stk.pop();
            if(previous == node.val){
                count++;
            } else  {
                count = 1;
                previous = node.val;
            }
            if(count > max){
                modes.clear();
            }
            if(count >= max){
                modes.add(node.val);
                max = count;
            }
            putLeftBranch(stk, node);
        }
        int[] ans = new int[modes.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = modes.get(i);
        }
        return ans;
    }

    private void putLeftBranch(Stack<TreeNode> stk, TreeNode node){
        while (node != null){
            stk.push(node);
            node = node.left;
        }
    }

}
