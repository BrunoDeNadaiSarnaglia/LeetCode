import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Sarnaglia on 2/7/17.
 */
public class MostFrequentSubtreeSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Pair {
        int sum;
        HashMap<Integer, Integer> countSubsumMap;

        public Pair(int sum, HashMap<Integer, Integer> countSubsumMap) {
            this.sum = sum;
            this.countSubsumMap = countSubsumMap;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Pair pair = findFrequentTreeSubsum(root);
        int max = 0;
        ArrayList<Integer> array = new ArrayList<>();
        HashMap<Integer, Integer> map = pair.countSubsumMap;
        for (Integer sum: map.keySet()) {
            if(max < map.get(sum)){
                max = map.get(sum);
                array.clear();
            }
            if(map.get(sum) == max){
                array.add(sum);
            }
        }
        int[] asd = new int[array.size()];
        for (int i = 0; i < asd.length; i++) {
            asd[i] = array.get(i);
        }
        return asd;
    }


    private Pair findFrequentTreeSubsum(TreeNode node) {
        if(node == null){
            return new Pair(0, new HashMap<>());
        }
        Pair leftPair = findFrequentTreeSubsum(node.left);
        Pair rightPair = findFrequentTreeSubsum(node.right);
        HashMap<Integer, Integer> mergeMap = mergeMap(leftPair.countSubsumMap, rightPair.countSubsumMap);
        int sum = leftPair.sum + rightPair.sum + node.val;
        mergeMap.put(sum, mergeMap.getOrDefault(sum, 0) + 1);
        return new Pair(sum, mergeMap);
    }

    private HashMap<Integer, Integer> mergeMap(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        if(map1.size() < map2.size())   return mergeMap(map2, map1);
        for (Integer key : map2.keySet()) {
            map1.put(key, map1.getOrDefault(key, 0) + map2.get(key));
        }
        return map1;
    }

}
