import java.util.HashMap;

public class DominoAndTrominoTiling {

  private final static int MOD = (int)Math.pow(10, 9) + 7;

  public int numTilings(int N) {
    return (int) numTilings(N, new HashMap<>(), new HashMap<>());
  }

  public long numTilings(int N, HashMap<Integer, Long> cacheTilings, HashMap<Integer, Long> cacheTilingsPlusOne) {
    if(cacheTilings.containsKey(N)) return cacheTilings.get(N);
    if(N == 1)  return 1;
    if(N == 2)  return 2;
    cacheTilings.put(N, (numTilings(N - 1, cacheTilings, cacheTilingsPlusOne) + 2 * numTilingsPlusOne(N - 2, cacheTilings, cacheTilingsPlusOne) + numTilings(N - 2, cacheTilings, cacheTilingsPlusOne)) % MOD);
    return cacheTilings.get(N);
  }

  private long numTilingsPlusOne(int N, HashMap<Integer, Long> cacheTilings, HashMap<Integer, Long> cacheTilingsPlusOne) {
    if(cacheTilingsPlusOne.containsKey(N))  return cacheTilingsPlusOne.get(N);
    if(N == 0) return 0;
    if(N == 1) return 1;
    cacheTilingsPlusOne.put(N, (numTilings(N - 1, cacheTilings, cacheTilingsPlusOne) + numTilingsPlusOne(N - 1, cacheTilings, cacheTilingsPlusOne)) % MOD);
    return cacheTilingsPlusOne.get(N);
  }
}