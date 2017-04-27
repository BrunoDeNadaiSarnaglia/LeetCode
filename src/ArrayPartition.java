import java.util.Arrays;

/**
 * Created by Sarnaglia on 4/26/17.
 */
public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
