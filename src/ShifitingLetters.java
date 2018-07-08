public class ShifitingLetters {
  public String shiftingLetters(String S, int[] shifts) {
    int[] acc = new int[shifts.length + 1];
    for(int i = shifts.length - 1; i >= 0 ; i--) {
        acc[i] = (acc[i + 1] + shifts[i]) % 26;
    }
    char[] chars = S.toCharArray();
    char[] shiftedChars = new char[S.length()];
    for(int i = 0; i < chars.length; i++) {
        shiftedChars[i] = (char)((chars[i] - 'a' + acc[i]) % 26 + 'a');
    }
    return new String(shiftedChars);
  }
}
