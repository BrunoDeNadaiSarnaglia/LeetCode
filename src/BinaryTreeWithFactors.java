import java.util.Arrays;

public class BinaryTreeWithFactors {

  private final static int MOD = Math.pow(10, 9) + 7;

  public int numFactoredBinaryTrees(int[] A) {
    long acc = 0;
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {
      acc += numFactoredBinaryTrees(A, i, new int[A.length]);
    }
    return (int) acc % MOD;
  }

  private long numFactoredBinaryTrees(int[] A, int rootIdx, int[] cache) {
    if(cache[rootIdx] != 0) return cache[rootIdx];
    int root = A[rootIdx];
    int i = 0;
    int j = rootIdx - 1;
    long count = 1;
    while (i <= j) {
      if(A[i] * A[j] == root) {
        count += (i == j ? 1 : 2) * numFactoredBinaryTrees(A, i, cache) *  numFactoredBinaryTrees(A, j, cache);
        count %= MOD;
        i++; j--;
      } else if (A[i] * A[j] < root) {
        i++;
      } else {
        j--;
      }
    }
    cache[rootIdx] = count;
    return count;
  }

}