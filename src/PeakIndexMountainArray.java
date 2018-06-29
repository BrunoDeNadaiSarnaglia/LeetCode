public class PeakIndexMountainArray {

  public int peakIndexInMountainArray(int[] A) {
    for(int i = 0; i < A.length - 1; i++) {
      if(A[i] > A[i + 1]) {
        return i;
      }
    }
    return -1;  
  }

  public int peakIndexInMountainArray(int[] A) {
    for(int i = 0; i < A.length - 1; i++) {
      if(A[i] > A[i + 1]) {
        return i;
      }
    }
    return -1;  
  }
  
}