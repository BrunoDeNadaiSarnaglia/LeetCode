public class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    int sc = 0;
    int fc = 0;
    for (int i = 2; i <= cost.length; i++) {
      int temp = sc;
      sc = fc;
      fc = Math.min(fc + cost[i - 1], temp + cost[i - 2]);
    }
    return fc;
  }
}
