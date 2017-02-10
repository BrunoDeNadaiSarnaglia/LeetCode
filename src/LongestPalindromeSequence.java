import java.util.HashMap;

/**
 * Created by Sarnaglia on 2/10/17.
 */
public class LongestPalindromeSequence {

    public static void main(String[] args) {
        LongestPalindromeSequence l = new LongestPalindromeSequence();
        System.out.println(l.longestPalindromeSubseq("bbbabb"));
    }

    public int longestPalindromeSubseq(String s) {
        int[][] cache = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            cache[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    cache[i][j] = 2 + cache[i + 1][j - 1];
                } else {
                    cache[i][j] = Math.max(cache[i + 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[cache.length-1][cache[0].length - 1];
    }


    private int longestPalindromeSubseq(String s, int i, int j, HashMap<String, Integer> cache){
        if(i > j)   return 0;
        if(i == j)  return 1;
        if(cache.containsKey(i + "|" + j))  return cache.get(i + "|" + j);
        int longestPalindromeSubseq;
        if(s.charAt(i) == s.charAt(j)){
            longestPalindromeSubseq = 2 + longestPalindromeSubseq(s, i + 1, j - 1, cache);
        } else {
            longestPalindromeSubseq = Math.max(longestPalindromeSubseq(s, i, j - 1, cache), longestPalindromeSubseq(s, i + 1, j, cache));
        }
        cache.put(i + "|" + j, longestPalindromeSubseq);
        return longestPalindromeSubseq;
    }

}
