import java.util.ArrayList;
import java.util.Arrays;

public class SplitArrayIntoFibonacci {
  public List<Integer> splitIntoFibonacci(String S) {
    if(S == null || S.length() == 0) return new ArrayList<>();
    if(S.charAt(0) == '0') return new ArrayList<>();
    for (int i = 0; i < (S.charAt(0) == '0' ? 1 : S.length()); i++) {
      long a = Long.parseLong(S.substring(0, i + 1));
      if(a > Integer.MAX_VALUE) break;
      for (int j = i + 1; j < (i + 1 < S.length() && S.charAt(i + 1) == '0' ? Math.min(S.length() - 1, i + 2) : S.length() - 1); j++) {
        long b = Long.parseLong(S.substring(i + 1, j + 1));
        if(b > Integer.MAX_VALUE) break;
        List<Integer> ans = makeFibonnaci(a, b, j + 1, S, new ArrayList(Arrays.asList(a, b)));
        if(ans != null) return ans;
      }
    }
    return new ArrayList<>();
  }

  private List<Integer> makeFibonnaci(long a, long b, int i, String S, List<Integer> l) {
    if(i == S.length()) return l;
    long c = a + b;
    if(c > Integer.MAX_VALUE) return null;
    String cStr = c + "";
    if(!isPrefix(cStr, i, S)) return null;
    l.add((int)c);
    return makeFibonnaci(b, c, i + cStr.length(), S, l);
  }

  private boolean isPrefix(String num, int i, String S) {
    if(i + num.length() > S.length()) return false;
    for (int j = 0; j < num.length(); j++) {
      if(num.charAt(j) != S.charAt(i + j)) return false;
    }
    return true;
  }
}
