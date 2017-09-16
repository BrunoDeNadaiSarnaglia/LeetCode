import java.util.HashSet;

/**
 * Created by Sarnaglia on 9/16/17.
 */
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int duplicated = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            } else {
                duplicated = nums[i];
            }
        }
        return new int[]{duplicated, sum - ((1 + nums.length) * nums.length) / 2 + duplicated};
    }
}
