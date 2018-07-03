public class CustomSortString {
  public String customSortString(String S, String T) {
    int[] mapT     = new int[26];
    boolean[] mapS = new boolean[26];
    for(Character ch : T.toCharArray()) {
      mapT[ch - 'a']++;
    }
    for(Character ch : S.toCharArray()) {
      mapS[ch - 'a'] = true;;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      for (int j = 0; j < mapT[S.charAt(i) - 'a']; j++) {
        sb.add(S.charAt(i));
      }
    }
    for (int i = 0; i < 26; i++) {
      if(!mapS[i + 'a']) {
        for (int j = 0; j < mapT[S.charAt(i) - 'a']; j++) {
          sb.add(S.charAt(i));
        }
      }
    }
    return sb.toString();
  }
}
