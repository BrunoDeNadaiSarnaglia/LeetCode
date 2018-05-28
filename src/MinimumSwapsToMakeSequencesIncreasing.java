public class MinimumSwapsToMakeSequencesIncreasing {
  public int minSwap(int[] A, int[] B) {
    int[] swap = new int[A.length];
    int[] notSwap = new int[B.length];
    swap[0] = 1;
    for (int i = 1; i < A.length; i++) {
      notSwap[i] = Integer.MAX_VALUE;
      swap[i]    = Integer.MAX_VALUE;
      if(B[i] > B[i - 1] && A[i] > A[i - 1]) {
        notSwap[i] = notSwap[i - 1];
        swap[i] = swap[i - 1] + 1;
      }
      if(B[i] > A[i - 1] && A[i] > B[i - 1]) {
        notSwap[i] = Math.min(notSwap[i], swap[i - 1]);
        swap[i] = Math.min(swap[i], notSwap[i - 1] + 1);
      }
    }
    return Math.min(swap[swap.length - 1], notSwap[notSwap.length - 1]);
  }

}
