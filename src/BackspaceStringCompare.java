public class BackspaceStringCompare {
  public boolean backspaceCompare(String S, String T) {
    return normalizeString(S).equals(normalizeString(T));
  }

  private String normalizeString(String S) {
    String normalizedString = "";
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if (ch == '#') {
        normalizedString = removeLastCharacter(normalizedString);
      } else {
        normalizedString += ch;
      }
    }
    return normalizedString;
  }

  private String removeLastCharacter(String S) {
    if(S.length() == 0) return "";
    return S.substring(0, S.length() - 1);
  }
}
