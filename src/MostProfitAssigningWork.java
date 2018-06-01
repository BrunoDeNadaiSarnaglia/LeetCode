import java.util.HashMap;
import java.util.Map;

public class MostProfitAssigningWork {
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < difficulty.length; i++) {
      map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
    }

  }
}
