import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sarnaglia on 7/11/17.
 */
public class AverageLevelsBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer, Double> nodesPerLevel = nodesPerLevel(root);
        HashMap<Integer, Double> sumPerLevel = sumPerLevel(root);
        List<Double> averages = new ArrayList<>();
        int i = 0;
        while (nodesPerLevel.containsKey(i)){
            averages.add((double)sumPerLevel.get(i) / (double) nodesPerLevel.get(i));
            i++;
        }
        return averages;
    }

    private HashMap<Integer, Double> nodesPerLevel(TreeNode root) {
        HashMap<Integer, Double> cache = new HashMap<Integer, Double>();
        nodesPerLevel(root, 0, cache);
        return cache;
    }

    private void nodesPerLevel(TreeNode root, int level, HashMap<Integer, Double> cache) {
        if(root == null)    return;
        cache.put(level, cache.getOrDefault(level, 0.0) + 1);
        nodesPerLevel(root.left, level + 1, cache);
        nodesPerLevel(root.right, level + 1, cache);
    }


    private HashMap<Integer, Double> sumPerLevel(TreeNode root) {
        HashMap<Integer, Double> cache = new HashMap<Integer, Double>();
        sumPerLevel(root, 0, cache);
        return cache;
    }

    private void sumPerLevel(TreeNode root, int level, HashMap<Integer, Double> cache) {
        if(root == null)    return;
        cache.put(level, cache.getOrDefault(level, 0.0) + root.val);
        sumPerLevel(root.left, level + 1, cache);
        sumPerLevel(root.right, level + 1, cache);
    }
}
