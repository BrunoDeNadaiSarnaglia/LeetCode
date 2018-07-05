import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SplitArrayConsecutiveSubsequences {

  private final static int MIN_VALUE = 3;

  public boolean isPossible(int[] nums) {
    LinkedList<Integer> ll = new LinkedList<>();
    int min = nums[0];
    int max = nums[nums.length - 1];
    Map<Integer, Integer> map = new HashMap<>();
    for(int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    ll.addAll(Collections.nCopies(map.getOrDefault(min, 0), min));
    for (int i = min + 1; i <= max; i++) {
      int previousCount = map.getOrDefault(i - 1, 0);
      int count = map.getOrDefault(i, 0);
      if(count > previousCount) {
        ll.addAll(Collections.nCopies(count - previousCount, i));
      } else if(count < previousCount) {
        for(int k = 0; k < previousCount - count; k++) {
          if(ll.isEmpty())  return false;
          if(i + 1 - ll.removeFirst() < MIN_VALUE) return false;
        }
      }
    }
    return ll.isEmpty() || max + 1 - ll.getLast() >= MIN_VALUE;
  }
}
