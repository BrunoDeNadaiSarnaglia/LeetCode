/**
 * Created by Bruno on 12/25/2016.
 */
public class UniqueSubstringsInWraparoundString {

    public static void main(String[] args){
        UniqueSubstringsInWraparoundString u = new UniqueSubstringsInWraparoundString();
        System.out.print(u.findSubstringInWraproundString("abc"));
    }

    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0)    return 0;
        int[] dp = new int[p.length()];
        dp[0] = 0;
        for (int i = 1; i < p.length(); i++) {
            char nextChar = (p.charAt(i - 1) + 1 <= 'z' ?(char) (p.charAt(i - 1) + 1) : 'a');
            dp[i] = (p.charAt(i) == nextChar ? dp[i - 1] : i);
        }
        int[] map = new int[26];
        for (int i = 0; i < dp.length; i++) {
            for (int j = dp[i], count = 0; count < 26 && j <= i; j++, count++) {
                map[p.charAt(j) - 'a'] = Math.max(map[p.charAt(j) - 'a'], i - j + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            sum += map[i];
        }
        return sum;
    }


}
