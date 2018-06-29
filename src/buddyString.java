import java.util.HashSet;

public class BuddyString {
  public boolean buddyStrings(String A, String B) {
    if(A.length() != B.length())  return false;
    int i = firstDifferentChar(A, B, 0);
    int j = firstDifferentChar(A, B, i + 1);
    int k = firstDifferentChar(A, B, j + 1);
    if(i >= A.length()) return hasRepeatedChar(A);
    if(j >= A.length()) return false;
    if(k < A.length())  return false;
    return A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i);
  }

  private int firstDifferentChar(String A, String B, int i) {
    for(; i < A.length() && A.charAt(i) == B.charAt(i); i++);
    return i;
  }

  private boolean hasRepeatedChar(String A) {
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < A.length(); i++) {
      char ch = A.charAt(i);
      if(set.contains(ch)) return true;
      set.add(ch);
    }
    return false;
  }

}
