public class MaxChunksToMakeSortedTwo {
  public int maxChunksToSorted(int[] arr) {
    int[] leftMaxArr  = new int[arr.length];
    int[] rightMinArr = new int[arr.length];
    leftMaxArr[0] = arr[0];
    rightMinArr[rightMinArr.length - 1] = Integer.MAX_VALUE;
    for (int i = 1; i < arr.length; i++) {
      leftMaxArr[i] = Math.max(leftMaxArr[i-1], arr[i]);
    }
    for (int i = arr.length - 2; i >= 0; i--) {
      rightMinArr[i] = Math.min(rightMinArr[i + 1], arr[i + 1]);
    }
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      count += (leftMaxArr[i] <= rightMinArr[i] ? 1 : 0);
    }
    return count;
  }
}
