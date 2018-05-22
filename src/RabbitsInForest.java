import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RabbitsInForest {
  public int numRabbits(int[] answers) {
    HashMap<Integer, Integer> set = new HashMap<>();
    for (int i = 0; i < answers.length; i++) {
      set.put(answers[i], set.getOrDefault(answers[i], 0) + 1);
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : set.entrySet()) {
      count += (entry.getKey() + 1)* (entry.getValue() / (entry.getKey() + 1)) + ((entry.getValue() % (entry.getKey() + 1)) > 0 ? entry.getKey() + 1 : 0);
    }
    return count;
  }
}
