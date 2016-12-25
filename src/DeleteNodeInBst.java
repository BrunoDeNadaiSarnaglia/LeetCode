/**
 * Created by Bruno on 12/25/2016.
 */
public class DeleteNodeInBst {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key > root.val) {
            root.right = deleteNode(root.right, key);
            return root.right;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
            return root.left;
        }
        if(root.right == null)  return root.left;
        if(root.left == null)  return root.right;
        TreeNode node = root.right;
        while (node.left != null){
            node = node.left;
        }
        node.left = root.left;
        return root.right;
    }

}
