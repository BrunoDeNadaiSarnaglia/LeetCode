/**
 * Created by Bruno on 12/12/2016.
 */
public class MinMoves {

    public int minMoves(int[] nums) {
        if(nums == null || nums.length <= 1)    return 0;
        int min = Integer.MIN_VALUE;
        for (Integer num : nums) {
            min = Math.min(min, num);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - min;
        }
        return sum;
    }
}
