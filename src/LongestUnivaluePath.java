public class LongestUnivaluePath {
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public int longestUnivaluePath(TreeNode root) {
    if(root == null)  return 0;
    return Math.max(logestUnivaluePathWithRoot(root), Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
  }

  private int logestUnivaluePathWithRoot(TreeNode root) {
    if(root == null) return 0;
    return longestBranch(root.left, root.val) + longestBranch(root.right, root.val);
  }

  private int longestBranch(TreeNode root, int val) {
    if(root == null || root.val != val) return 0;
    return Math.max(longestBranch(root.left, val), longestBranch(root.right, val));
  }
}
