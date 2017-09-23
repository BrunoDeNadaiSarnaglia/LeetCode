/**
 * Created by Sarnaglia on 9/23/17.
 */
public class MaximumBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int i, int j) {
        if(i > j)   return null;
        int idxMax = idxMax(nums, i, j);
        TreeNode root = new TreeNode(nums[idxMax]);
        root.left = constructMaximumBinaryTree(nums, i, idxMax - 1);
        root.right = constructMaximumBinaryTree(nums, idxMax + 1, j);
        return root;
    }

    private int idxMax(int[] nums, int i, int j) {
        int idxMax = i;
        for (int k = i + 1; k <= j; k++) {
            idxMax = nums[k] > nums[idxMax] ? k : idxMax;
        }
        return idxMax;
    }
}
