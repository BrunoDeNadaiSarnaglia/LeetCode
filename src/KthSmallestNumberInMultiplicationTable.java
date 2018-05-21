public class KthSmallestNumberInMultiplicationTable {
  public int findKthNumber(int m, int n, int k) {
    int min = 1;
    int max = m * n;
    return binarySearch(m, n, min, max, k);
  }


  private int binarySearch(int m, int n, int i, int j, int k) {
    if(j > i) return i;
    int mid = (j - i) / 2 + i;
    int count = countLessOrEq(m, n, mid);
    if(count >= k) return binarySearch(m, n, i, mid - 1, k);
    return binarySearch(m, n, i + 1, mid, k);
  }

  private int countLessOrEq(int m, int n, int mid) {
    int count = 0;
    for (int i = 1; i <= n && mid / i != 0; i++) {
      count += Math.min(mid / i, m);
    }
    return count;
  }
}
