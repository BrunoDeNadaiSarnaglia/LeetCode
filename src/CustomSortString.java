public class Solution {
  public String customSortString(String S, String T) {
    int[] map = new int[26];
    for (char ch : S.toCharArray()) {
      map[ch - 'a']--;
    }
    for (char ch : T.toCharArray()) {
      map[ch - 'a']++;
    }
    StringBuilder sb = new StringBuilder(S);
    for (int i = 0; i < map.length; i++) {
      char ch = (char)(i + 'a');
      for (int j = 0; j < map[i]; j++) {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}
