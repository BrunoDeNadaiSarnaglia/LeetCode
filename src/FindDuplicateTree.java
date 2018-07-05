import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateTree {

  private class Node {
    public Node left;
    public Node right;
    public int val;
    public TreeNode tn;

    private Node() { }

    public Node(int val, TreeNode tn) {
      this.val = val;
      this.tn = tn;
    }

    @Override
    public int hashCode() {
      int left = this.left == null ? 0 : this.left.hashCode();
      int right = this.right == null ? 0 : this.right.hashCode();
      return (31 * left + 17 * right + 47 * (this.val + 31034)) % 128373;
    }

    public HashMap<TreeNode, Boolean> cache = new HashMap<>();

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o == this) return true;
      if (!(o instanceof Node)) {
          return false;
      }
      Node node = (Node) o;
      if(cache.containsKey(node.tn)) return cache.get(node);
      if(node.val != this.val)  return false;
      boolean left = false;
      boolean right = false;
      if(node.left == null && this.left == null) {
        left = true;
      }
      if(node.right == null && this.right == null) {
        right = true;
      }
      if(node.left != null && this.left != null) {
        left = this.left.equals(node.left);
      }
      if(node.right != null && this.right != null) {
        right = this.right.equals(node.right);
      }
      cache.put(node.tn, left && right);
      return left && right;
    }
  }

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Node node = constructTree(root);
    Map<Node, Integer> map = new HashMap<>();
    preOrder(node, map);
    return map.keySet().stream().filter(k -> map.get(k) > 2).map(n -> n.tn).collect(Collectors.toList());
  }

  private void preOrder(Node node, Map<Node, Integer> map) {
    if(node == null)  return;
    map.put(node, map.getOrDefault(node, 0) + 1);
    preOrder(node.left, map);
    preOrder(node.right, map);
  }

  private Node constructTree(TreeNode treeNode) {
    if(treeNode == null) return null;
    Node node = new Node(treeNode.val, treeNode);
    node.left = constructTree(treeNode.left);
    node.right = constructTree(treeNode.right);
    return node;
  }
}
