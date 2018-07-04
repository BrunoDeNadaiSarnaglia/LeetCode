public class ScoreAfterFlippingMatrix {
  public int matrixScore(int[][] A) {
    if(A == null || A.length == 0 || A[0].length == 0)  return 0;
    for (int i = 0; i < A.length; i++) {
      if(A[i][0] == 0) {
        toggleRow(A, i);
      }
    }
    int sum = 0;
    for (int j = 0; j < A[0].length; j++) {
      int sumCol = sumColumn(A, j);
      sum = 2 * sum + Math.max(sumCol, A.length - sumCol);
    }
    return sum;
  }

  private void toggleRow(int[][] A, int i) {
    for (int j = 0; j < A[i].length; j++) {
      A[i][j] = 1 - A[i][j];
    }
  }

  private int sumColumn(int[][] A, int j) {
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i][j];
    }
    return sum;
  }
}
