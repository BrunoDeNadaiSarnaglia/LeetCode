/**
 * Created by Sarnaglia on 4/22/17.
 */
public class LongestUncommonSubsequence1 {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
