import java.awt.List;

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
  }
}
