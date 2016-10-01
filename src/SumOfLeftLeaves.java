/**
 * Created by Bruno on 10/1/2016.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(ConvertedSortedListToBinary.TreeNode root) {
        return sumOfLeftLeaves(root, true);
    }

    private int sumOfLeftLeaves(ConvertedSortedListToBinary.TreeNode root, boolean isLeftCall) {
        if(root == null){
            return 0;
        }
        if(isLeftCall && root.left == null && root.right == null) {
            return root.val;
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

}
