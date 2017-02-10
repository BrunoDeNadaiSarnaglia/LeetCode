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
        return longestPalindromeSubseq(s, 0, s.length() - 1, new HashMap<>());
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
