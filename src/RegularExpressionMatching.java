/**
 * Created by Sarnaglia on 1/18/17.
 */
public class RegularExpressionMatching {

    public static void main(String[] args){
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.print(rem.isMatch("aa", ".*"));
    }


    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int i, int j){
        if(i == s.length() && j == p.length())  return true;
        if(j < p.length() && p.charAt(j) == '*' && isMatch(s, p, i, j + 1))  return true;
        if(i == s.length() || j == p.length()) return false;
        if(p.charAt(j) == '*' && isMatch(s, p, i + 1, j))  return true;
        if((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && isMatch(s, p, i + 1, j + 1))   return true;
        return false;
    }
}
