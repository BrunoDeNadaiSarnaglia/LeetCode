public class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    int midSum = 0;
    for (int i = 0; i < nums.length; i++) {
      if((sum - nums[i]) % 2 == 0 && midSum == (sum - nums[i])/ 2) return i + 1;
      if(midSum > sum / 2)  return -1;
      midSum += nums[i];
    }
    return -1;
  }
}
