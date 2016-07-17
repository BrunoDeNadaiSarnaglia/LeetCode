/**
 * Created by Bruno on 7/17/2016.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] encondedCountDp = new int[s.length() + 1];
        encondedCountDp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != '0') encondedCountDp[i + 1] = encondedCountDp[i];
            if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                encondedCountDp[i + 1] += encondedCountDp[i - 1];
            }
        }
        return encondedCountDp[s.length()];
    }
}
