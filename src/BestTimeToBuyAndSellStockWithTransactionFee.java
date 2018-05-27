class Solution {

  public int maxProfit(int[] prices, int fee) {
    int havingStock = -prices[0];
    int havingNoStock = 0;
    for (int i = 1; i < prices.length; i++) {
      int tmp = havingNoStock;
      havingNoStock = Math.max(havingNoStock, havingStock - prices[i]);
      havingStock = Math.max(havingStock, tmp + prices[i] - fee);
    }
    return havingStock;
  }
}
