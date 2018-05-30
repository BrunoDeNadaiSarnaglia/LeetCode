public class NumberSubarraysBoundedMaximum {

  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    int outBoundIdx = -1;
    int count = 0;
    for (int i = 0; i < A.length + 1; i++) {
      if(i == A.length || A[i] > R  || A[i] < L) {
        count += ((i - outBoundIdx) * (i - outBoundIdx - 1)) / 2;
        outBoundIdx = i;
      }
    }
    return count;
  }
}
