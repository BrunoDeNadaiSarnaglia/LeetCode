import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;

/**
 * Created by Bruno on 7/16/2016.
 */
public class MinimumAdjustmentCost {

    private int MAX_NUM = 100;

    public int MinAdjustmentCost(ArrayList<Integer> A, int target){
        int[][] dp = new int[A.size() + 1][MAX_NUM];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                dp[i + 1][j] = Integer.MAX_VALUE;
                for (int k = -target; k <= target; k++) {
                    if(j + k < 0 || j + k >= MAX_NUM)   continue;
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j + k] + Math.abs(A.get(i) - j));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < MAX_NUM; j++) {
            min = Math.min(min, dp[A.size()][j]);
        }
        return min;
    }

}
