/**
 * Created by Sarnaglia on 1/25/17.
 */
public class predictWinner {

    public boolean PredictTheWinner(int[] nums) {
        int[] accSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            accSum[i + 1] = accSum[i] + nums[i];
        }
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = nums.length; i >= 0; i--) {
            for (int j = i + 1; j <= nums.length; j++) {
                dp[i][j] = accSum[j] - accSum[i] - Math.min(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return 2 * dp[0][nums.length - 1] > accSum[nums.length] - accSum[0];
    }

}
