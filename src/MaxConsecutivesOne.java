/**
 * Created by Sarnaglia on 1/15/17.
 */
public class MaxConsecutivesOne {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count = (nums[i] == 0 ? 0 : count++);
            max = Math.max(max, count);
        }
        return max;
    }

}
