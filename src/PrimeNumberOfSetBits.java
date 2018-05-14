import java.util.Set;

public class PrimerNumberOfSetBits {

  private final static Set<Integer> PRIME_NUMBES = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37));

  public int countPrimeSetBits(int L, int R) {
    int count = 0;
    for (int num = L; num <= R; num++) {
      if(PRIME_NUMBES.contains(countSetBitsInNum(num))) count++;
    }
    return count;
  }

  private int countSetBitsInNum(int num) {
    int count = 0;
    for(; num != 0; num >>>= 1) {
      count += num & 1;
    }
    return count;
  }
}
