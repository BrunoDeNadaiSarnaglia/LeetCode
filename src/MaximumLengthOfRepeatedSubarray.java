public class MaximumLengthOfRepeatedSubarray {
  public int findLength(int[] A, int[] B) {
    int max = 0;
    int[][] matrix = new int[A.length + 1][B.length + 1];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        if(A[i] != B[j]) {
          matrix[i][j] = 0;
        } else {
          matrix[i + 1][j + 1] = matrix[i][j] + 1;
          max = Math.max(max, matrix[i + 1][j + 1]);
        }
      }
    }
    return max;
  }
}
