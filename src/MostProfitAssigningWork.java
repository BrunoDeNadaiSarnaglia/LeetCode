import java.util.HashMap;
import java.util.Map;

public class MostProfitAssigningWork {
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    Map<Integer, Integer> difficultyToProfit = dToP(difficulty, profit);
    Arrays.sort(difficulty);
    Arrays.sort(worker);
    int[] maxProfitsPerDifficulty = maxProfitBelowDifficulty(difficulty, difficultyToProfit);
    int maxP = 0;
    for (int i = 0, j = 0; i < worker.length; i++) {
      while(j + 1 < difficulty.length && worker[i] >= difficulty[j + 1]) {
        j++;
      }
      maxP += j != -1 ? maxProfitsPerDifficulty[j] : 0;
    }
    return maxP;
  }

  private Map<Integer, Integer> dToP(int[] difficulty, int[] profit) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < difficulty.length; i++) {
      map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], Integer.MIN_VALUE), profit[i]));
    }
    return map;
  }

  private int[] maxProfitBelowDifficulty(int[] difficulty, Map<Integer, Integer> difficultyToProfit) {
    int[] maxProfitPerDifficulty = new int[difficulty.length];
    maxProfitPerDifficulty[0] = difficultyToProfit.get(difficulty[0]);
    for (int i = 1; i < difficulty.length; i++) {
      maxProfitPerDifficulty[i] = Math.max(maxProfitPerDifficulty[i - 1], difficultyToProfit.get(difficulty[i]));
    }
    return maxProfitPerDifficulty;
  }
}
