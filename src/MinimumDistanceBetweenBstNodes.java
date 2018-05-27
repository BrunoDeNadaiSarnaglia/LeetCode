

class Solution {

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  private class Pair {
    public Integer minimumValue;
    public Integer previousValue;

    public Pair(Integer minimumValue, Integer previousValue) {
      this.minimumValue = minimumValue;
      this.previousValue = previousValue;
    }
  }

  public int minDiffInBST(TreeNode root) {
    Pair p = minDiffInBSTHelper(root, new Pair(null, null));
    return p.minimumValue;
  }

  private Pair minDiffInBSTHelper(TreeNode node, Pair upperPair) {
    if(node == null) {
      return upperPair;
    }
    Pair leftPair = minDiffInBSTHelper(root.left, upperPair);
    Pair updatedPair = resolvePair(upperPair, leftPair, node.val);
    return minDiffInBSTHelper(root.right, updatedPair);
  }

  private Pair resolvePair(Pair upperPair, Pair leftPair, Integer nodeValue) {
    Integer minimumValue  = resolveMinimumValue(upperPair, leftPair);
    Integer previousValue = resolvePreviousvalue(upperPair, leftPair);
    Integer updatedMinimumValue = null;
    if(previousValue != null) {
      updatedMinimumValue = nodeValue - previousValue;
      if(minimumValue != null) {
        updatedMinimumValue = Math.min(updatedMinimumValue, minimumValue);
      }
    }
    return new Pair(updatedMinimumValue, nodeValue);
  }

  private Integer resolvePreviousvalue(Pair upperPair, Pair leftPair) {
    if(leftPair.previousValue != null) return leftPair.previousValue;
    return upperPair.previousValue;
  }

  private Integer resolveMinimumValue(Pair upperPair, Pair leftPair) {
    Integer minimumValueUpper = upperPair.minimumValue;
    Integer minimumValueLeft = leftPair.minimumValue;
    if(minimumValueUpper == null) return minimumValueLeft;
    if(minimumValueLeft == null) return minimumValueUpper;
    return Math.min(minimumValueUpper, minimumValueLeft);
  }
}
