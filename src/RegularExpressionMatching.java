import java.util.HashSet;

/**
 * Created by Sarnaglia on 1/18/17.
 */
public class RegularExpressionMatching {

    public static void main(String[] args){
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch("aa", "a"));
        System.out.println(rem.isMatch("aa", "aa"));
        System.out.println(rem.isMatch("aaa", "aa"));
        System.out.println(rem.isMatch("aa", "a*"));
        System.out.println(rem.isMatch("aa", ".*"));
        System.out.println(rem.isMatch("ab", ".*"));
        System.out.println(rem.isMatch("aab", "c*a*b"));
        System.out.println(rem.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }


    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0, new HashSet<String>());
    }

    private boolean isMatch(String s, String p, int i, int j, HashSet<String> cache){
        if(cache.contains(i + "|" + j)) return false;
        if(i == s.length() && j == p.length())  return true;
        if(j == p.length()) return false;
        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (isMatch(s, p, i, j + 2, cache))    return true;
        }
        if(i == s.length()) return false;
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                if(isMatch(s, p, i + 1, j, cache)) return true;
            }
            if (isMatch(s, p, i, j + 2, cache))    return true;
        } else {
            if((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && isMatch(s, p, i + 1, j + 1, cache)) return true;
        }
        cache.add(i + "|" + j);
        return false;
    }
}
