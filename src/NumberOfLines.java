public class NumberOfLines {

  private static final int MAX_WIDTH_PER_LINE = 100;

  public int[] numberOfLines(int[] widths, String S) {
    if (S.length() == 0) return new int[] {0, 0};
    int numLine = 1;
    int linePosition = 0;
    for (Character ch : S.toCharArray()) {
      int width = widths[ch - 'a'];
      if (linePosition + width > MAX_WIDTH_PER_LINE) {
        numLine ++;
        linePosition = width;
      } else {
        linePosition += width;
      }
    }
    return new int[] {numLine, linePosition};
  }
}
