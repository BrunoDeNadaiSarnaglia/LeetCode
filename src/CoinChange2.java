/**
 * Created by Sarnaglia on 2/11/17.
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] numCombinations = new int[amount + 1];
        numCombinations[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 0; j + coin <= amount; j++) {
                numCombinations[j + coin] += numCombinations[j];
            }
        }
        return numCombinations[amount];
    }
}
