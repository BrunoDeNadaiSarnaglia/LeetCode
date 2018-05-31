public class MinimumAsciiDeleteSum {
  public int minimumDeleteSum(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int j = 0; j < s2.length(); j++) {
      dp[0][j + 1] = dp[0][j] + s2.charAt(j);
    }
    for (int i = 0; i < s1.length(); i++) {
      dp[i + 1][0] = dp[i][0] + s1.charAt(i);
    }
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        if(s1.charAt(i) == s2.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j];
        } else {
          dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + s2.charAt(j), dp[i][j + 1] + s1.charAt(i));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }
}
