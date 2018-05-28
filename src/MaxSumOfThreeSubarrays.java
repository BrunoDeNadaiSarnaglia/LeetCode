public class MaxSumOfThreeSubarrays {
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int[] acc = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      acc[i + 1] = acc[i] + nums[i];
    }
    int[] dp1 = new int[nums.length + 1];
    int[] dp2 = new int[nums.length + 1];
    int[] dp3 = new int[nums.length + 1];
    dp1[k] = k;
    for (int i = k + 1; i <= nums.length; i++) {
      dp1[i] = acc[dp1[i - 1]] - acc[dp1[i - 1] - k] < acc[i] - acc[i - k] ? i : dp1[i - 1];
    }
    dp2[2 * k] = 2 * k;
    for (int i = 2 * k + 1; i <= nums.length - k; i++) {
      dp2[i] = acc[dp2[i - 1]] - acc[dp2[i - 1] - k] + acc[dp1[i - k - 1]] - acc[dp1[i - k - 1] - k] < acc[i] - acc[i - k] + acc[dp1[i - k]] - acc[dp1[i - k] - k] ? i : dp2[i - 1];
    }
    dp3[3 * k] = 3 * k;
    for (int i = 3 * k + 1; i <= nums.length; i++) {
      dp3[i] = acc[dp3[i - 1]] - acc[dp3[i - 1] - k] + acc[dp2[i - k - 1]] - acc[dp2[i - k - 1] - k] < acc[i] - acc[i - k] + acc[dp2[i - k]] - acc[dp2[i - k] - k] ? i : dp3[i - 1];
    }
    return new int[]{dp1[dp2[dp3[nums.length] - k] - k] - k, dp2[dp3[nums.length] - k] - k, dp3[nums.length] - k};
  }
}
