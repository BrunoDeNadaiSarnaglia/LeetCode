public class RepeatedStrongMatch {
  public int repeatedStringMatch(String a, String b) {
    for(int i = 0; i < a.length(); i++){
          int j = 0;
        for(; j < b.length() && a.charAt((i + j) % a.length()) == b.charAt(j); j++);
          if(j == b.length()) {
            return (i + j) / a.length() + ((i + j) % a.length() != 0 ? 1 : 0);
          }
      }
      return -1;
  }
}
