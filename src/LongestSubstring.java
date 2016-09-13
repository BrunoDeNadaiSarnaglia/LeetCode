import javax.annotation.processing.SupportedSourceVersion;

/**
 * Created by Bruno on 9/12/2016.
 */
public class LongestSubstring {

    public static void main(String[] args){
        LongestSubstring a = new LongestSubstring();
        System.out.print(a.longestSubstring("aaabb", 3));
    }

    public int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length() - 1);
    }

    private int longestSubstring(String s, int k, int i, int j) {
        if(j - i + 1 < k)   return 0;
        int[] map = countCharacter(s, i, j);
        int l = i;
        int max = 0;
        for (int m = i; m <= j; m++) {
            if(map[s.charAt(m) - 'a'] < k){
                max = Math.max(max, longestSubstring(s, k, l, m - 1));
                l = m + 1;
            }
        }
        if(l == i)  return j - i + 1;
        max = Math.max(max, longestSubstring(s, k, l, j));
        return max;
    }

    private int[] countCharacter(String s, int i, int j){
        int[] map = new int[26];
        for (int k = i; k <= j; k++) {
            map[s.charAt(k) - 'a']++;
        }
        return map;
    }


}
