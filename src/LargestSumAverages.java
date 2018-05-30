public class LargestSumAverages {

  public double largestSumOfAverages(int[] A, int K) {
    double[] dp = new double[A.length];
    int[] sumAcc = new int[A.length + 1];
    for (int i = 0; i < A.length; i++) {
      sumAcc[i + 1] = sumAcc[i] + A[i];
    }
    for (int i = 0; i < dp.length; i++) {
      dp[i] = (sumAcc[i + 1] - sumAcc[0]) / (i + 1);
    }
    double max = dp[A.length - 1];
    for (int i = 1; i < K; i++) {
      for (int j = A.length - 1; j >= i; j++) {
        for (int k = i; k <= j; k++) {
          dp[j] = Math.max(dp[j], (sumAcc[j + 1] - sumAcc[i]) / (j - i + 1));
        }
      }
      max = Math.max(max, dp[A.length - 1]);
    }
    return max;
  }
}
