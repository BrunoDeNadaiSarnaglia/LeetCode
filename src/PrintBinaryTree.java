import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarnaglia on 9/23/17.
 */
public class PrintBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {
        int maxDepth = depth(root);
        int len = 1;
        for (int i = 1; i < maxDepth; i++) {
            len += (len + 1);
        }
        List<List<String>> l = new ArrayList<>();
        for (int i = 0; i < maxDepth; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                row.add("");
            }
            l.add(row);
        }
        printTree(root, 0, 0, len, l);
        return l;
    }

    private void printTree(TreeNode root, int level, int i, int j, List<List<String>> l) {
        if(root == null)    return;
        l.get(level).set((i + j) / 2, root.val + "");
        printTree(root.left, level + 1, i, (i + j) / 2 - 1, l);
        printTree(root.right, level + 1, (i + j) / 2 + 1, j, l);
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
