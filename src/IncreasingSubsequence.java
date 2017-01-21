import java.util.*;

/**
 * Created by Sarnaglia on 1/21/17.
 */
public class IncreasingSubsequence {


    public List<List<Integer>> findSubsequences(int[] nums) {
        TreeMap<Integer, HashSet<List<Integer>>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            HashSet<List<Integer>> set = new HashSet<>();
            for (Integer key : map.keySet()) {
                if(key > nums[i])   break;
                HashSet<List<Integer>> itSet = map.get(key);
                addAll(set, itSet, nums[i]);
                set.add(Arrays.asList(key, nums[i]));
            }
            map.put(nums[i], set);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            HashSet<List<Integer>> set = map.get(nums[key]);
            ans.addAll(set);
        }
        return ans;
    }

    private void addAll(HashSet<List<Integer>> mutableSet, HashSet<List<Integer>> set, Integer num){
        for (List<Integer> list : set) {
            mutableSet.add(add(list, num));
        }
    }

    private List<Integer> add(List<Integer> list, Integer num){
        ArrayList<Integer> addedList = new ArrayList<>();
        addedList.addAll(list);
        addedList.add(num);
        return addedList;
    }
}
