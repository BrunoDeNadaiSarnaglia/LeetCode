import java.util.HashMap;

/**
 * Created by Sarnaglia on 4/30/17.
 */
public class SubarraySumsEqualk {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.putIfAbsent(sum, 0);
            map.put(sum, map.get(sum) + 1);
        }
        return count;
    }

}
