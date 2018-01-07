/**
 * Created by Sarnaglia on 9/23/17.
 */
public class KeysKeyboard {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n / 2 ; i++) {
            for (int j = 2; j * i < n; j++) {
                dp[j * i] = Math.min(dp[j * i], dp[i] + j);
            }
        }
        return dp[n];
    }
}
