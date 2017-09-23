import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Sarnaglia on 9/23/17.
 */
public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        return findLongestChain(pairs, pairs.length - 1, new Integer[pairs.length]);
    }
    private int findLongestChain(int[][] pairs, int j, Integer[] cache) {
        if(j < 0)    return 0;
        if(j == 0)   return 1;
        if(cache[j] != null)    return cache[j];
        int i = j - 1;
        for (; i >= 0 && pairs[i][1] >= pairs[j][0]; i--);
        cache[j] = Math.max(findLongestChain(pairs, j - 1, cache),
                findLongestChain(pairs, i, cache) + 1);
        return cache[j];
    }
}
