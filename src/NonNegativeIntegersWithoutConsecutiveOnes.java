import java.util.HashSet;
import java.util.Set;

public class NonNegativeIntegersWithoutConsecutiveOnes {
  public int findIntegers(int num) {
    Set<Integer> set = new HashSet<>();
    set.add(0);
    findIntegers(num, set, 1);
    return set.size();
  }

  public void findIntegers(int num, HashSet<Integer> set, int candidate) {
    if(candidate > num) return;
    if(set.contains(candidate)) return;
    set.add(candidate);
    findIntegers(num, set, 2 * candidate);
    if(candidate % 2 == 0) {
      findIntegers(num, set, 2 * candidate + 1);
    }
  }
}
