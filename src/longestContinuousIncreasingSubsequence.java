/**
 * Created by Sarnaglia on 9/16/17.
 */
public class longestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int longestIncreasingSubsequenceLength = 1;
        int longestIncreasingSubsequenceLengthEndingI = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                longestIncreasingSubsequenceLengthEndingI++;
            } else {
                longestIncreasingSubsequenceLengthEndingI = 1;
            }
            longestIncreasingSubsequenceLength = Math.max(longestIncreasingSubsequenceLength, longestIncreasingSubsequenceLengthEndingI);
        }
        return longestIncreasingSubsequenceLength;
    }
}
