import java.util.HashMap;
import java.util.Map;

public class DeleteEarn {
  public static int MAX_NUMBER = 10000;
  public int deleteAndEarn(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + nums[i]);
    }
    int included = map.getOrDefault(0, 0);
    int notIncluded = 0;
    for (int i = 2; i < MAX_NUMBER + 1; i++) {
      int aux = notIncluded;
      notIncluded = Math.max(included, aux);
      included = aux +  + map.getOrDefault(i, 0);
    }
    return Math.max(notIncluded, included);
  }
}
