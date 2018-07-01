public class ScoreOfParenthesis {
  public int scoreOfParentheses(String S) {
    return scoreOfParentheses(S.toCharArray(), 0, S.length() - 1);
  }


  private int scoreOfParentheses(char[] S, int i, int j) {
    if (i > j)      return 0;
    if (i + 1 == j) return 1;
    int acc = 0;
    for (int k = i; k < j; k++) {
      acc += (S[k] == '(' ? 1 : -1);
      if (acc == 0) {
        return scoreOfParentheses(S, i, k) + scoreOfParentheses(S, k + 1, j);
      }
    }
    return 2 * scoreOfParentheses(S, i + 1, j - 1);
  }
}
