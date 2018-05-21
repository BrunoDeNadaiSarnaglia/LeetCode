import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

public class FindKThSmallestPairDistance {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int i = binarySearch(arr, 0, arr.length - 1, x);
    int j = i + 1;
    for (int l = 0; l < k; l++) {
      if(j >= arr.length) i--;
      else if(i < 0) j++;
      else if(x - arr[i] <= arr[j] - x)  i--;
      else j++;
    }
    List<Integer> list = new ArrayList<>();
    for (int l = i + 1; l < j; l++) {
      list.add(arr[l]);
    }
    return list;
  }

  private int binarySearch(int[] arr, int i, int j, int x) {
    if(i > j) return j;
    int mid = (j - i) / 2 + i;
    if(arr[mid] == x) return mid;
    if(arr[mid] > x) return binarySearch(arr, i, mid - 1, x);
    return binarySearch(arr, mid + 1, j, x);
  }
}
