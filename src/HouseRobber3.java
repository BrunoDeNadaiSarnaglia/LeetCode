import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by Bruno on 5/5/2016.
 */
public class HouseRobber3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Pair<K, T>{
        private K k;
        private T t;
        public Pair(K k, T t){
            this.k = k;
            this.t = t;
        }

        public K getFirst(){
            return this.k;
        }


        public T getSecond(){
            return this.t;
        }
    }

    public class Solution {

        HashMap<TreeNode, Integer> mapNodeIn = new HashMap<TreeNode, Integer>();

        HashMap<TreeNode, Integer> mapNodeOut = new HashMap<TreeNode, Integer>();

        public int rob(TreeNode root) {
            Pair<Integer, Integer> pair = robNode(root);
            return Math.max(pair.getFirst(), pair.getSecond());
        }

        private Pair<Integer, Integer> robNode(TreeNode node){
            if(node == null){
                return new Pair<Integer, Integer>(0, 0);
            }
            Pair<Integer, Integer> leftPair = robNode(node.left);
            Pair<Integer, Integer> rightPair = robNode(node.right);
            int withNode = leftPair.getSecond() + rightPair.getSecond() + node.val;
            int withoutNode = Math.max(leftPair.getFirst(), leftPair.getSecond()) + Math.max(rightPair.getFirst(), rightPair.getSecond());
            return new Pair<Integer, Integer>(withNode, withoutNode);
        }
    }
}
