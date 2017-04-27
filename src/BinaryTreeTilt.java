/**
 * Created by Sarnaglia on 4/26/17.
 */
public class BinaryTreeTilt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Pair {
        int sum;
        int tilt;
        int sumTilt;

        public Pair (int sum, int tilt, int sumTilt) {
            this.sum     = sum;
            this.tilt    = tilt;
            this.sumTilt = sumTilt;
        }
    }

    public int findTilt(TreeNode root) {
        return helper(root).sumTilt;
    }

    private Pair helper(TreeNode root) {
        if(root == null)  return new Pair(0,0,0);
        Pair pl = helper(root.left);
        Pair pr = helper(root.right);
        return new Pair(
                pl.sum + pr.sum + root.val,
                Math.abs(pl.sum - pr.sum),
                pl.sumTilt + pr.sumTilt
        );
    }

}
