/**
 * Created by Bruno on 6/30/2016.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        int m = costs[0].length;
        int[] ithHouseCosts = new int[m];
        for (int i = 0; i < m; i++) {
            ithHouseCosts[i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            ithHouseCosts = nextHouseCosts(costs, ithHouseCosts, i);
        }
        int min = Integer.MAX_VALUE;
        for (Integer num : ithHouseCosts) {
            min = Math.min(min, num);
        }
        return min;
    }
    
    private int[] nextHouseCosts(int[][] costs, int[] ithHouseCost, int i){
        int[] ithPlusOneHouseCost = new int[ithHouseCost.length];
        for (int j = 0; j < ithHouseCost.length; j++) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < ithHouseCost.length; k++) {
                if(j == k)  continue;
                min = Math.min(ithHouseCost[k] + costs[i][j], min);
            }
            ithPlusOneHouseCost[j] = min;
        }
        return ithPlusOneHouseCost;
    }
}
