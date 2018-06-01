public class GlobalLocalInversions {
  public boolean isIdealPermutation(int[] A) {
    int[] minList = new int[A.length];
    minList[A.length - 1] = A[A.length - 1];
    for (int i = A.length - 2; i >= 0; i--) {
      minList[i] = Math.min(minList[i + 1], A[i]);
    }
    for (int i = 0; i < A.length - 2; i++) {
      if(A[i] > minList[i + 2]) return false;
    }
    return true;
  }
}
