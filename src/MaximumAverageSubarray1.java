/**
 * Created by Sarnaglia on 9/3/17.
 */
public class MaximumAverageSubarray1 {

    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length < k)     return 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if(j >= k) {
                sum -= nums[j - k];
            }
            if(j >= k - 1 && maxSum < sum) {
                maxSum = sum;
            }
        }
        return ((double) maxSum / (double)k);
    }
}
