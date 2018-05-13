public class FlippingAnImage {

  public int[][] flipAndInvertImage(int[][] A) {
    for (int[] row : A) {
      flipAndInverRow(row);
    }
    return A;
  }

  private void flipAndInverRow(int[] row) {
    int midIdx = row.length / 2;
    int lastIdx = row.length - 1;
    if(row.length % 2 == 1) {
      row[midIdx] = invertBit(row[midIdx]);
    }
    for (int i = 0; i < midIdx; i++) {
      if(row[i] == row[lastIdx - i]) {
        row[i] = invertBit(row[i]);
        row[lastIdx - i] = invertBit(row[lastIdx - i]);
      }
    }
  }

  private int invertBit(int num) {
    if(num == 0) return 1;
    return 0;
  }
}
