import java.util.HashMap;

/**
 * Created by Sarnaglia on 6/24/17.
 */
public class LongestHarmoniusSubSeq {

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        int max = 0;
        for (Integer key: map.keySet()) {
            if(map.containsKey(key + 1)){
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }

}
