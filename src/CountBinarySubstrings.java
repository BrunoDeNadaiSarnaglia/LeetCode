import java.util.HashMap;

public class CountBinarySubstrings {
  public int countBinarySubstrings(String s) {
    int count = 0;
    for (int i = findAdjDiff(s, 0); i < s.length(); i = findAdjDiff(s, i + 1)) {
      int j = i;
      int k = i + 1;
      while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(i) && s.charAt(k) != s.charAt(i)) {
        j--;
        k++;
        count++;
      }
    }
    return count;
  }

  private int findAdjDiff(String s, int i) {
    for (int j = i; j < s.length() - 1; j++) {
      if(s.charAt(j) != s.charAt(j + 1))  return j;
    }
    return s.length();
  }
}
