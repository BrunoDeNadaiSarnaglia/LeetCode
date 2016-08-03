import java.util.Arrays;

/**
 * Created by Bruno on 8/3/2016.
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return 0;
        int[] values = new int[target + 1];
        values[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && i - nums[j] >= 0; j++) {
                values[i] += values[i - nums[j]];
            }
        }
        return values[values.length - 1];
    }
}
