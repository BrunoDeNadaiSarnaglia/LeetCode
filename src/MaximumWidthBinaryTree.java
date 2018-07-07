import java.awt.List;
import java.util.Deque;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class MaximumWidthBinaryTree {
  public int widthOfBinaryTree(TreeNode root) {
    return widthOfBinaryTree(root, 0, 0, new  ArrayList<Integer>());
  }

  private int widthOfBinaryTree(TreeNode node, int level, int idx, List<Integer> leftMost) {
    if(node == null)  return 0;
    if(leftMost.size() <= level) {
      leftMost.add(idx);
    }
    int max = idx - leftMost.get(level) + 1;
    max = Math.max(max, widthOfBinaryTree(node.left, level + 1, 2 * idx, leftMost));
    max = Math.max(max, widthOfBinaryTree(node.right, level + 1, 2 * idx + 1, leftMost));
    return max;
    leftMost.
  }

  public int widthOfBinaryTree(TreeNode root) {
    int max = 0;
    if(root == null) return max;
    Deque<TreeNode> lvl = new LinkedList<TreeNode>();
    lvl.add(root);
    while(lvl.size() != 0) {
      max = Math.max(max, lvl.size());
      lvl = nextLevel(lvl);
    }
    return max;
  }

  private Deque<TreeNode> nextLevel(Deque<TreeNode> stk) {
    Deque<TreeNode> stkNextLevel = new LinkedList<TreeNode>();
    for(TreeNode node : stk) {
      if(node != null) {
        stkNextLevel.addLast(node.left);
        stkNextLevel.addLast(node.right);
      } else if(node == null && !stk.isEmpty()) {
        stkNextLevel.addLast(null);
        stkNextLevel.addLast(null);
      }
    }
    while(!stkNextLevel.isEmpty() && stkNextLevel.getLast() == null) {
      stkNextLevel.removeLast();
    }
    return stkNextLevel;
  }
}
