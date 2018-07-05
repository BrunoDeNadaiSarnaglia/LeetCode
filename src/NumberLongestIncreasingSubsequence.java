import java.util.Arrays;

public class NumberLongestIncreasingSubsequence {
  public int findNumberOfLIS(int[] nums) {
    int[][] dp = new int[nums.length][nums.length];
    Arrays.fill(dp[0], 1);
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        for (int k = 1; k <= j; k++) {
          dp[i][j] += nums[j] > nums[j - k] ? dp[i - 1][j - k] : 0;
        }
      }
      if(IntStream.of(dp[i]).sum() == 0) return IntStream.of(dp[i - 1]).sum() == 0;
    }
    return 1;
  }
}
