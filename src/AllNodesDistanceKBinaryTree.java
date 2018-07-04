import java.util.HashSet;

public class AllNodesDistanceKBinaryTree {
  private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  private class Node {
    Node left;
    Node right;
    Node parent;
    int val;
    public Node(int val) {
      this.val = val;
    }
  }

  private Node beginNode = null;

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    graph(root, null, target);
    HashSet<Node> kDistanceNodes = dfs(beginNode, K);
    return kDistanceNodes.stream().map(node -> node.val).collect(Collectors.toList());
  }

  private HashSet<Node> dfs(Node node, int K) {
    HashSet<Node> kDepthNodes = new HashSet<>();
    dfs(node, 0, new HashSet<>(), K, kDepthNodes);
    return kDepthNodes;
  }

  private void dfs(Node node, int depth, HashSet<Node> visited, int K, HashSet<Node> kDepthNodes) {
    if(node == null)  return;
    if(visited.contains(node))  return;
    visited.add(node);
    if(depth == K) {
      kDepthNodes.add(node);
      return;
    }
    dfs(node.left, depth + 1, visited, K, kDepthNodes);
    dfs(node.right, depth + 1, visited, K, kDepthNodes);
    dfs(node.parent, depth + 1, visited, K, kDepthNodes);
  }

  private Node graph(TreeNode treeNode, Node parent, TreeNode target) {
    if(treeNode == null)  return null;
    Node node   = new Node(treeNode.val);
    node.parent = parent;
    node.left   = graph(treeNode.left, node, target);
    node.right  = graph(treeNode.right, node, target);
    if(target == treeNode)  { beginNode = node; }
    return node;
  }

}
