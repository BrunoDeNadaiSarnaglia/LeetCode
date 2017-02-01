import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sarnaglia on 1/30/17.
 */
public class ModeBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private class Pair {
        public int pivot;
        public int count;
        public int max;
        public List<Integer> l;

        public Pair() {
            pivot = 0;
            count = 0;
            max = 0;
            l = new ArrayList<>();
        }
    }

    public int[] findMode(TreeNode root) {
        Pair p = findMode(root, new Pair());
    }

    public Pair findMode(TreeNode node, Pair p) {
        if(node == null)    return p;
        Pair pl = findMode(node, p);
        int nextPivot = (pl.pivot != node.val? node.val : pl.pivot);
        int nextCount = (pl.pivot != node.val? 1 : pl.count + 1);
        if(nextCount > pl.max){
            pl.l.clear();
        }
        if(nextCount >= pl.max){
            pl.l.add(node.val);
            pl.max = nextCount;
        }
        pl.count = nextCount;
        pl.pivot = nextPivot;
        return findMode(node, pl);
    }





//    public int[] findMode(TreeNode root) {
//        Stack<TreeNode> stk = new Stack<>();
//        int max = 0, previous = Integer.MIN_VALUE, count = 0;
//        List<Integer> modes = new ArrayList<>();
//        putLeftBranch(stk, root);
//        while (!stk.isEmpty()){
//            TreeNode node = stk.pop();
//            if(previous == node.val){
//                count++;
//            } else  {
//                count = 1;
//                previous = node.val;
//            }
//            if(count > max){
//                modes.clear();
//            }
//            if(count >= max){
//                modes.add(node.val);
//                max = count;
//            }
//            putLeftBranch(stk, node);
//        }
//        int[] ans = new int[modes.size()];
//        for (int i = 0; i < ans.length; i++) {
//            ans[i] = modes.get(i);
//        }
//        return ans;
//    }
//
//    private void putLeftBranch(Stack<TreeNode> stk, TreeNode node){
//        while (node != null){
//            stk.push(node);
//            node = node.left;
//        }
//    }

}
