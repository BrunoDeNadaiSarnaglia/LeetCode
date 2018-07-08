public class LongestMountainInArray {
  public int longestMountain(int[] A) {
    int max = 0;
    for(int i = 1; i < A.length - 1; i++) {
      if(A[i - 1] < A[i] && A[i] > A[i + 1]) {
        int j = i - 1;
        while(j - 1 >= 0 && A[j - 1] < A[j]) { j--; }
        int k = i + 1;
        while(k + 1 < A.length && A[k + 1] < A[k]) { k++; }
        max = Math.max(max, k - j + 1);
      }
    }
    return max;
  }

  public int longestMountain(int[] A) {
    int max = 0;
    for(int i = 1; i < A.length;) {
      if(A[i] > A[i - 1]) {
        int j = i;
        while(j + 1 < A.length && A[j + 1] > A[j]) { j++; }
        int k = j;
        while(k + 1 < A.length && A[k + 1] < A[k]) { k++; }
        if(k != j) {
          max = Math.max(max, k - i + 1)
        }
        i = k + 1;
      } else { i++; }
    }
    return max;
  }
}
